# Algorithms :heart: :smile:

![Algorithms][alg-img] ![Datastructures][datastructure-img] ![Open Source Love][Open-Source-img]

Algorithms and data structures' implementations in Java from the `Algorithms 4th edition` :book:

## What's is this course?

* Intermediate level survey course
* Programming and problem solving with applications

## Definitions

* `Algorithms` : Method for solving a problem
* `Data structures` : Method to store information
* `Program = Algorithms + Data structures`

## Topics

* `Part I`

01. Data types: stack, queue, bag, union find, priority queue  
02. Sorting: quicksort, mergesort, heapsort, radix sorts  
03. Searching: BST, red-black BST, hash table  

* `Part II`

04. Graphs: BFS, DFS, Prime, Kruskal, Dijkstra  
05. Strings: KMP, regular expression, TST, Huffman, LZW  
06. Advanced: B-tee, suffix array, maxflow  

---

## Why Algorithms is so important?

Algorithms all around us  

01. Internet: Web search, packet routing, distribute file sharing, ... 
02. Biology: Human genome project, protein folding, ... 
03. Computers: Circuit layout, file system, compilers, ... 
04. Computer graphics: Movies, Video games, virtual reality, ... 
05. Security: Cell phones, e-commerce, voting machines, ... 
06. Multimedia: MP3, JPG, Divx, HDTV, face recognition, ... 
07. Social networks: Recommendations, news feeds, advertisements, ... 
08. Physics: N-body simulation, particle collision simulation, ... 

---

## Steps for solving the problem

01. Model the problem  
02. Find an algorithm to solve it  
03. Fast enough? Fits in memory?  
04. If not, figure out why  
05. Find a way to address the problem  
06. Iterate until satisfied  

---

## Algorithm Analyze

### Reasons to Analyze Algorithms

* Predict performance
* Compare algorithms
* Provide guarantees
* Understand theoretical basis

### The scientific method

* Observe some feature in the natural world
* Hypothesize a model that is consistent with the observations
* Predict events using the hypothesis
* Verify the predictions by making further observations
* Validate by repeating until the hypothesis and observations agree

### Principles

* Experiments must be reproducible. 
* Hypotheses must be falsifiable. 

### Empirical Analysis

* Manual measurement (benchmarking) with a stopwatch or programmatic timing method. 
* Measure running time for different input sizes *N* (e. g. doubling time) and observe the relationship between the running times. 

### Data Analysis

* Plot running time T(N) vs input size *N*. 
* Plot as log-log plot, often get a straight line. lg(T(N)) vs lg(N). Plot tells you the exponent of *N*. 
* Regression, power law: *a x N<sup>b</sup>*
* Once you have the power b from the slope of the log-log plot, solve for *a* in the equation *T(N) = a x N<sup>b</sup>*

### Doubling Hypothesis

* Run program, doubling the size of the input and observe ratios. Observe to what it converges, do not take the average!

|  N   | T(N) | Ratio | lg(Ratio) |
| ---- | ---- | ----- | --------  |
| 1000 | 0. 1  |   -   |     -     |
| 2000 | 0. 8  |  7. 7  |    2. 9    |
| 4000 | 6. 4  |   8   |     3     |
| ... | ... |  ... |    ... |

* Hypothesis: Running time is about *a x N<sup>b</sup>*, where *b = lg(Ratio)*
* Caveat: Cannot identify logarithmic factors with the doubling hypothesis. 
* Calculate *a* by solving *T(N) = a x N<sup>b</sup>* for a with all other variables now known. 

### Experimental algorithmic

* System independent effects (determines constant *a* and exponent *b* in power law)

  + Algorithm
  + Input data

* System dependent effects (contribute only to constant *a* in power law)

  + Hardware: CPU, memory, cache
  + Software compiler, interpreter, garbage collector
  + System: OS, network, other applications

### Mathematical Models

* Analyze individual operations to determine complexity

* Simplification 1

  Count only the most expensive ones, i. e. those that take the most time or where time x frequency is highest. 

* Simplification 2

  Ignore lower order terms, e. g. in 5xN<sup>3</sup> + 20N + 16, ignore the term with N
  and the constant 16 (which is 16 x N<sup>0</sup>) because they are less significant in
  comparison with the highest order term. We use *tilde notation* `~` to say that *5
  x N<sup>3</sup> + 20 x N + 16 __~ 5 x N<sup>3</sup>__*. Technical definition is that for *f(N) ~
  G(N)* when *N* goes towards infinity, the lower order terms become so
  insignificant that *f(N)/g(N) = 1*

 ### Order-of-Growth Classifications
 - A great number of algorithms (most) are described by the following order of growth functions
 	+ 1 (constant)
 	+ log N (logarithmic)
 	+ N (linear)
 	+ N log N (linearithmic)
 	+ N<sup>2</sup> (quadratic)
 	+ N<sup>3</sup> (cubic)
 	+ 2<sup>N</sup> (exponential)

* Note: lgN means log<sub>2</sub>N

	

<p align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Comparison_computational_complexity.svg/800px-Comparison_computational_complexity.svg.png" alt="graph_order_growth" width="400"/></p>

* We say the algorithm "is proportional to" e. g. constant time

---

## Properties

01. Reflexive: p is connected to q  
02. Symmetric: if p is connected to q, then q is connected to p  
03. Transitive: if p is connected to q and q is connected to r, then p is connected to r

---

## Dynamic connectivity

Applications based on this:

01. Pixels in a digital photo  
02. Computers in network  
03. Friends in a social network  
04. Transistors in a computer chip  
05. Elements in a mathematical set  
06. Variables names in Fortran program  
07. Metallic sites in a composite system  

### Quick find (Eager approach)

* Data structure
* Integer array `id[]` of size N
* Interpretation: p and q are connected (iff) if and only if they have the same id
* Complexity

| Initialize | Union | Find |
|------------|-------|------|
| N          | N     | 1    |

* Defect

    - Find too expensive (Could be N array accesses)  
    - If you have N union commands over N objects will be O(N<sup>2</sup>) quadratic  

* Note

``` diff

* We can not accept Quadratic in big problems
* Quadratic algorithms do not scale

```

#### Rough standards (for now)

* 10<sup>9</sup> operations per second
* 10<sup>9</sup> words of main memory
* Touch all words in approximately 1 second

#### E. g Huge problem for quick find

* 10<sup>9</sup> union commands of 10<sup>9</sup> objects
* Quick find takes more than 10<sup>18</sup> operations
* 30+ years of computer time!

### Quick Union

* Set the first element based on the root of the second element
* Complexity

| Initialize | Union | Find |
|------------|-------|------|
| N          | N'    | 1    |

* Defect

    - Tree can get tall
    - Find too expensive (Could be N array accesses)

### Quick Union improvement

01. Weighted Quick union
* Modify the Quick union to avoid tall trees
* Balance by linking root of smaller tree to root of larger tree
* Depth of any node x is at most `lg N`

* Complexity

| Initialize | Union | Find |
|------------|-------|------|
| N          | lg N' | lg N |

02. Quick union with path compression `N + M lg N`

03. Weighted Quick union with path compression `N + M lg*N`

* Note `WQUPC reduce time from 30 years to 6 seconds`

### Union find Applications

01. Percolation
02. Games (Go, Hex)
03. Dynamic connectivity
04. Last common ancestor
05. Hoshen-kopelman algorithm in physics

### Percolation

A model for many physical systems

* N-by-N grid of sites
* Each site is open probability p (or blocked with probability 1-p)
* System percolates iff top and bottom are connected by open sites
* Applications in real life

| Model | System | Vacant site | Occupied site | Percolates |
| -------| -------|-------------|-------------|----------|
| electricity | material| conductor | insulated | conducts |
| fluid flow | material| empty | blocked | porous |
| social interaction | population | person | empty | communicates |

-------------------------------------------------------------------------------------------------------------------------------

## Data structure Design

Good practice to make an abstraction between the outside world and internal implementation  
In java we will use interface

## Stack

* `LIFO` (last in first out), useful in many applications
* Operations: `push(Item item), pop(), size(), isEmpty()`

* There are two implementation of stack using `Linkedlist` and `Array`

* Stack removes the item most recently added
* What are the Differences between LinkedList and Array implementation?

    - Linkedlist: Use extra space for dealing with links
    - Array: resize/shrink the array takes some time

* When should I use Linkedlist or Array implementation?

if time is important and don't want to lose any input i. e. dealing with internet packet use `Linkedlist` implementation, But if you take care of `memory` space use `Array` implementation  

* How duplicate/shrinking array?

    - Resize When reach 100% full the array resize(arr.length*2)
    - Shrink when reach one quarter full to the half resize(arr.length/2)

* Stack applications

  + Parsing in a compiler
  + Java virtual machine
  + Undo in word processor
  + Back button in a web browser
  + Implementation function calls in a compiler
  + Arithmetic expression evaluation
  + Reverse objects

	

-------------------------------------------------------------------------------------------------------------------------------

## Queue

* `FIFO` (first in first out), useful in many applications  
* Operations: `enqueue(Item item), dequeue(), size(), isEmpty()`

* Queue removes the item lest recently
* There are two implementation of stack using `Linkedlist` and `Array`

* Queue applications

  + Cpu scheduling
  + Disk scheduling
  + Data transfer asynchronously between two processes. Queue is used for synchronization. 
  + Breadth First search in a Graph
  + Call Center phone systems

	

-------------------------------------------------------------------------------------------------------------------------------

## Elementary sorts

* Rearrange array of N times into ascending/descending order based on a key

01. Selection sort
02. Insertion sort
03. Shell sort
04. Heap sort
05. Quick sort

* Implementation in java there are `Comparable` and `Comparator` interfaces we will them any of them in the implementation of the sort algorithms 

to allow sort any generic data types  

* There are three return values: 1, 0, -1 and throw Exception if incompatible types or null

  + V less than W (return -1)  
  + V equal to W (return 0)  
  + V greater than W (return 1)  

* Total order

	01. `Antisymmetric` : if v<=w and w<=v, then v=w
	02. `Transitivity` : if v<=w and w<=x, then v<=x
	03. `Totality` : either v<=w or w<=v or both

-------------------------------------------------------------------------------------------------------------------------------

### Selection sort

* Scan from left to right  
* Find the index of `min` of smallest remaining entry, then swap `a[i]` and `a[min]`  `-->`  `Time Complexity O(N<sup>2</sup>)` and doesn't sensitive if the input is sorted  

 `Algorithm`

``` java

    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        int N = arr.length; 
        int min; 
        for (int i = 0; i < N; i++) {
            min = i; 
            for (int j = i + 1; j < N; j++) {
                if (less(arr[j], arr[min])) {
                    min = j; 
                }
            }
            swap(arr, i, min); 
        }
    }

```

-------------------------------------------------------------------------------------------------------------------------------

### Insertion sort

* Scan from left to right  
* Swap `a[i]` with each larger entry to its left `<--`  `Time Complexity O(N<sup>2</sup>)` and has good performance over `partially sorted arrays`

* Fast when the array is partially sorted `O(N)`

* Array called partially sorted when number of elements to be changed less than or equal cN

 `Algorithm`

``` java

    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        int N = arr.length; 
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                    swap(arr, j, j - 1); 
            }
        }
    }

```

-------------------------------------------------------------------------------------------------------------------------------

### Shell sort

* Move entries more than one position at a time by `h-sorting` the array  What's the `h value` Knuth says `3x+1`

* Complexity N<sup>3/2</sup>

 `Algorithm`

``` java

    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        int N = arr.length; 
        int h = 1; 
        while (h < N / 3)
            h = 3 * h + 1; 

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    swap(arr, j, j - h); 
                }
            }
            h /= 3; 
        }
    }

```

* Why Shell sort uses insertion sort internally?  

	01. Fast unless array size is huge
	02. Tiny used in some embedded systems
	03. Hardware sort prototype

-------------------------------------------------------------------------------------------------------------------------------

## Shuffle sort  

* Generate a random real number for each array entry  
* Sort array  

### Knuth shuffle  

* Pick integer r between 0 and i uniformly at random  
* Swap `a[i]` and `a[r]`

* Complexity: `O(n)`

 `Algorithm`

``` java

    public static <Item extends Comparable<Item>> void shuffle(Item[] arr) {
        int N = arr.length; 
        Random random = new Random(); 
        for (int i = 0; i < N; i++) {
            int r = random.nextInt(i + 1); 
            swap(arr, i, r); 
        }
    }

```

### Applications in sorting

01. Convex hull of a set of N points is the smallest perimeter fence enclosing the points  
02. TODO // complete this part

-------------------------------------------------------------------------------------------------------------------------------

## Merge sort

* This sort based on the technique of `divide-and-conquer`

* Java sort for objects
* Steps:  

    - Divide array into two halves  
    - Recursively sort each half  
    - Merge two halves

    

* Complexity `N lg N`

 `Algorithm`

``` java

    public static <Item extends Comparable<Item>> void sort(Item[] arr, Item[] aux, int lo, int hi) {
        if (hi <= lo)
            return; 
        int mid = lo + (hi - lo) / 2; 
        sort(arr, aux, lo, mid); 
        sort(arr, aux, mid + 1, hi); 
        merge(arr, aux, lo, mid, hi); 
    }

    private static <Item extends Comparable<Item>> void merge(Item[] arr, Item[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1; 
        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k]; 
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                arr[k] = aux[j++]; 
            else if (j > hi)
                arr[k] = aux[i++]; 
            else if (less(aux[j], aux[i]))
                arr[k] = aux[j++]; 
            else
                arr[k] = aux[i++]; 
        }
    }

```

* Mergesort improvement

    - Stop if array is already sorted: !less(arr[mid+1], arr[mid])
    - Cutoff to insertion sort = 7
    - Eliminate-the-copy-to-the-auxiliary-array trick

* First draft of a Report on the EDVAC by John von Neuman
* Compare Running time between Insertionsort and Mergesort

    - Laptop executes 10<sup>8</sup> compares/second
    - Supercomputer executes 10<sup>12</sup> compares/second
    - In this below table will compare between normal computer in first row and supercomputer in second row

        Insertionsort N<sup>2</sup>

| Million   | Billion   |
|-----------|-----------|
| 2. 8 hours | 317 years |
| 1 second  | 1 week    |

        Mergesort N lg N

| Million  | Billion |
|----------|---------|
| 1 second | 18 min  |
| instant  | instant |

* Note: `Good algorithm are better than supercomputers`

### Bottom-up version of Mergesort

* Basic plan  

	01. Pass through array, merging subarrays of size 1
	02. Repeat for subarrays of size 2, 4, 8, 16, ... 
	03. Slower than Recursive by 10%

 `Algorithm`

``` java

    public static <Item extends Comparable<Item>> void sortBottomUp(Item[] arr) {
        int N = arr.length; 
        Item[] aux = (Item[]) new Comparable[N]; 
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo <= N - sz; lo += sz + sz)
                merge(arr, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1)); 
    }

```

-------------------------------------------------------------------------------------------------------------------------------

## Sort Stability

* Suppose you want to sort `BY_NAME` then `BY_SECTION`

* You should sort and keep the equal elements that they came as input, don't change equal elements position
* Which sorts are stable?

  + Insertionsort
  + Mergesort

* Why Selectionsort and Shellsort not stable?  

  + Selectionsort keeps keep pointer from past and might move an item some equal item

    - Shellsort makes long distance exchanges

-------------------------------------------------------------------------------------------------------------------------------

## Quick sort

* One of the most important algorithm in 20<sup>th</sup> century
* Java sort for primitive types
* Basic plan

	01. Shuffle the array
	02. Partition
	03. Sort

* Complexity `N lg N`

* Faster than Mergesort
* In place algorithm
* Not stable
* Worst case in quicksort will not gonna happen
* Problems in quick sort

 `Algorithm`

``` java

    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        KnuthShuffleSort.shuffle(arr); 
        sort(arr, 0, arr.length - 1); 
    }

    private static <Item extends Comparable<Item>> void sort(Item[] arr, int lo, int hi) {
        if (hi <= lo)
            return; 
        if (hi <= lo + CUTOFF) {
            InsertionSort.sort(arr, lo, hi); 
            return; 
        }
        int j = partition(arr, lo, hi); 
        sort(arr, lo, j - 1); 
        sort(arr, j + 1, hi); 
    }

    private static <Item extends Comparable<Item>> int partition(Item[] arr, int lo, int hi) {
        int i = lo, j = hi + 1; 
        while (true) {
            while (less(arr[++i], arr[lo]))
                if (i == hi)
                    break; 
            while (less(arr[lo], arr[--j]))
                ; 
            if (i >= j)
                break; 
            swap(arr, i, j); 
        }
        swap(arr, lo, j); 
        return j; 
    }

```

-------------------------------------------------------------------------------------------------------------------------------

## Sort complexity

|Name|Inplace|Stable|Best|Average|Worst   |Remarks|
|----|-------|------|----|-------|--------|-------|
|Selectionsort|Yes|No|1/2 N<sup>2</sup>|1/2 N<sup>2</sup>|1/2 N<sup>2</sup>|N exchanges|
|Insertionsort|Yes|Yes|N|l/4N<sup>2</sup>|l/2N<sup>2</sup>|use for small N or partially ordered|
|Shellsort|Yes|No|N log<sub>3</sub>N|?|cN<sup>3/2</sup>|tight code, sub-quadratic|
|Mergesort|No|Yes|½ N lg N|N lg N|N lg N|N lg N guarantee, stable|
|Quicksort|Yes|No|N|N lg N|½ N<sup>2</sup>|N lg N probabilistic guarantee fastest in practice|
|3-ways Quicksort|Yes|No|N<sup>2</sup>/2|2 N ln N|½ N<sup>2</sup>|improves quicksort in presence of duplicate keys|
|Timesort|No|Yes|N|N lg N|N lg N|-|

## Sort applications

01. Sort a list of names
02. Organize an MP3 library
03. Display Google PageRank results
04. List Rss feed in reverse chronological order

, Problems became easy once items are in sorted order 

01. Find the median
02. Binary search in a database
03. Identify statistical outliers
04. Find duplicates in a mailing list

, Non-obvious applications

01. Data compression
02. Computer graphics
03. Computational biology
04. Load balancing on a parallel computers

## System sorts

* Java uses:
01. Tuned quicksort for primitive types
02. Mergesort for objects

* Which algorithm to use?

    - Applications have diverse attributes
    - Stable?
    - Parallel?
    - Deterministic?
    - Key all distinct?
    - Multiple key types?
    - Linked list or arrays?
    - Large or small items?
    - Is your array randomly ordered?
    - Need guaranteed performance?

-------------------------------------------------------------------------------------------------------------------------------

## Priority Queues

* Remove the largest or smallest item
* Operations: `insert(Item item), delMax(), isEmpty(), max(), size()`

* Applications

    01. Event-driven simulation: [customers in a line, colliding particles]
    02. Numerical computation: [reducing roundoff error]
    03. Data compression: [Huffman codes]
    04. Graph searching: [Dijkstra's algorithm, Prim's algorithms]
    05. Number theory: [sum of powers]
    06. Artificial intelligence: [A* search]
    07. Statistics: [maintain largest M values in a sequence]
    08. Operating systems: [load balancing, interrupt handling]
    09. Discrete optimization: [bin packing, scheduling]
    10. Spam filtering: [Bayesian spam filters]

* Implementation: you can make multiple implementation using unordered and ordered array, and Binary heap
* Complexity of unordered and ordered array

|Implementation|Insert|Del max|Max|
|--------------|------|-------|---|
|unordered array|1|N|N|
|ordered array|N|1|1|
|goal|log N|log N|log N|

### Binary heap

* Binary tree
* Complexity: `lg N`

* Complete tree, perfectly balanced, except for bottom level
* Height of complete tree with N nodes is `lgN` , why?

    Height only increase when N is a power of 2

* A complete binary tree in nature

<p align="center"><img src="https://i.pinimg.com/originals/98/f8/73/98f873ccf1dc936a19f1ef9defd62cab.jpg" alt="graph_order_growth" width="400"/></p>

* Heap ordered binary tree

    - Keys in nodes
    - Parent's key no smaller than children's keys

* Array representation:

    - Parent of node at k is at `k/2`

    - Children of node at k are at `2k` and right `2k+1`

* Best practice use immutable keys
* Underflow and overflow

    - Underflow: throw exception if deleting from empty PQ
    - Overflow: add no-arg constructor and use resize array

 `Algorithm`

``` java

    public final static <Item extends Comparable<Item>> void sort(Item[] pq) {
        int n = pq.length; 

        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n); 
        }

        int k = n; 
        while (k > 1) {
            swap(pq, 1, k--); 
            sink(pq, 1, k); 
        }
    }

    // Get the largest and put as a parent
    private static <Item extends Comparable<Item>> void sink(Item[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k; 
            if (j < n && less(pq, j, j + 1))
                j++; 
            if (!less(pq, k, j)) // K less than children then break
                break; 
            swap(pq, k, j); 
            k = j; 
        }
    }

    private static <Item extends Comparable<Item>> boolean less(Item[] pq, int firstIndex, int secondIndex) {
        return pq[firstIndex - 1].compareTo(pq[secondIndex - 1]) < 0; 
    }

    private static <Item extends Comparable<Item>> void swap(Item[] pq, int firstIndex, int secondIndex) {
        Item temp = pq[firstIndex - 1]; 
        pq[firstIndex - 1] = pq[secondIndex - 1]; 
        pq[secondIndex - 1] = temp; 
    }

```

-------------------------------------------------------------------------------------------------------------------------------

## Heapsort

* Basic plan

    - Create max heap with all N keys
    - Repeatedly remove the maximum keys

* In place sorting algorithm with `N lg N` worst-case
* Bottom line: heapsort is optimal for both time and space, but: 

    - Inner loop longer than quicksort's
    - Make poor usage of cache memory
    - Not stable

* Not stable

-------------------------------------------------------------------------------------------------------------------------------

### Event driven simulation

* Application based on priority queue
* Simulate the motion of N moving particles that behave according to the laws of elastic collision
* Hard disc model

    - Moving particles interact via elastic collisions with each other and walls
    - Each particle is a disc with know position, velocity, mass and radius
    - No other forces

-------------------------------------------------------------------------------------------------------------------------------

## Symbol tables

* Key-value pair
* Insert a value with specified key
* Give a key, search for the corresponding value
* i. e DNS lookup

    - insert URL with specified IP address
    - Give URL, find corresponding IP address

* Applications

    01. Dictionary
    02. Book index
    03. File share
    04. Compiler
    05. Routing table
    06. DNS
    07. Genomics
    08. File system
    09. Web search

* Operations: `put(Key key, Value val), get(Key key), delete(Key key), contains(Key key), isEmpty(), size(), keys()`

* Conventions:

    - Values are not null
    - Method get() returns null if values not present
    - Method put() overwrites old values with new values

* Best practices: Use immutable types for symbol data types

    - Immutable in java: String, Integer, Double, java.io. File, ... 
    - Mutable in java:: StringBuilder, java.net. URL, Arrays, ... 

* ST Implementations

    - Linked list
    - Binary search in an order array
    - BST Binary search tress

### Binary search tree

* BST is a binary tree in symmetric order
* A binary tree is either

    - Empty
    - Two disjoint binary tress(left and right)

* Symmetric order each node has a key, and every node's key is:

    - Larger than all keys in its left subtree
    - Smaller than all keys in its right subtree

* Representation in java using linked list has key, value and reference to left and right

``` java

    private class Node {
        private Key key; 
        private Value val; 
        private Node left, right; 

        public Node(Key key, Value val) {
            this.key = key; 
            this.val = val; 
        }
    }

```

* How to find min/max in BST?

    - For min move to the left from the root until find null key
    - For max move to the right from the root until find null key

### 2-3 Trees

* Allow 1 or 2 keys per node

    - 2-node: one key, two children
    - 3-node: two keys, three children

* Perfect balance: every path from the root to null link has same length
* Implementation: Red-black BSTs

### Red-black BSTs

* Represent 2-3 tree as a BST
* Use "internal" left-learning links as "glue" for 3-nodes
* A BST such that:

    - No node has two red links connected to it
    - Every path from root to the null link has the same number of black links
    - Red links lean left

-------------------------------------------------------------------------------------------------------------------------------

## Hash tables

* Basic plan:

    - Save items in a key-indexed table (index is a function of the key)
    - Hash function:method for computing array index from key

* Issues:

    - Computing the has function
    - Equality test: Method for checking whether two keys are equal
    - Collision resolution: Algorithm and data structure to handle two keys that hash to the same array index

* Classic space-time tradeoff

    - No space limitation: trivial hash function with key as index
    - No time limitation: trivial collision resolution with sequential search
    - Space and time limitations: hashing (the real world)

### Hash functions

* Efficiently computable
* Each table index equally likely for each key
* Ex 1. Phone numbers:

    - Bad: first three digits
    - Better: last three digits

* Ex 2. Social security numbers:

    - Bad: first three digits
    - Better: last three digits

* Practical challenge, need different approach for each key type
* Java's hash code conventions

    - All java classes inherit a method `hashCode()` , with return 32-bit in
    - Requirement, if `x.equals(y), then (x.hashCode() == y.hashCode())`

    - Highly desirable: if `!x.equals(y), then (x.hashCode() != y.hashCode())`

``` 

      X
      |
    -----
    |   |   
    -----
      |
    x.hashCode()

```

* hash code design

    - Combine each significant field using the `31x+y`

    - If field is a primitive type, use wrapper type `hashCode()`

    - If field is null, return 0
    - If field is a reference type, use `hashCode()`

    - If field is an array, apply to each entry

* Basic rule, need to use the whole key to compute hash code, consult an expert for state-of-the-art hash codes

### Separate chaining (Collision resolution)

* Collision, Two distinct keys hashing to the same index
* Basic idea

    - Use an array of M < N linked list
    - Hash: map key to integer i between 0 and M-1
    - Insert: put at front of i<sub>th</sub> chain
    - Search need to search only i<sub>th</sub> chain

* Consequence, Number of probes for search/insert is proportional to N/M

    - M too large ==> too many empty chains
    - M too small ==> chains too long 
    - Typical choice M ~ N/5 ==> constant time ops

### Linear probing

* Open addressing, When a new key collides, find the next empty slot and put it there
* Hash. Map key to integer i between 0 and M-1
* Insert. Put at table index i if free, if not try i+1, i+2, etc
* Search. Search table index i, if occupied but no match, try i+1, i+2, etc
* Note, Array size M must be greater than number of key-value pairs M
* Clustering: a contiguous block of items

### Separate chaining vs. Linear probing

* Separate chaining

    - Easier to implement delete
    - Performance degrades gracefully
    - Clustering less sensitive to poorly-designed hash function

* Linear probing

    - Less wasted space
    - Better cache performance

### Applications

* Security One way hash function: MD4, MD5, SHA-0, SHA-1, SHA-2, WHIRLPOOL, RIPEMD-160, ... 

    - Digital fingerprint
    - Message digest
    - Storing passwords

* Dictionary lookup

    - DNS lookup
    - Amino acids
    - Class list

### Hash tables vs.balanced search trees

* Hash tables

    - Simpler to code
    - No effective alternative for unordered keys
    - Faster for simple keys (a few arithmetic ops versus log N compares)
    - Better system support in Java for strings (e.g.cached hash code)

* Balanced search trees

    - Stronger performance guarantee
    - Support for ordered ST operations
    - Easier to implement `compareTo()` correctly than `equals()` and `hashCode()`

* Java system includes both:

    - Red-black BSTs: java.util. TreeMap, java.util. TreeSet
    - Hash tables: java.util. HashMap, java.util. IdentityHashMap

### Set

* Mathematical set: a collection of distinct keys
* Operations: `add(Key key), contains(Key key), remove(Key key), size(), iterator()`

### ST Complexity

|ST implementation|Worst-case search| Worst-case insert|Worst-case delete|Ordered iteration|key interface|
|-----------------|-----------------|------------------|-----------------|-----------------|-------------|
|linked list|N|N|N|no|equals()|
|binary search (ordered array)|log N|N|N|yes|compareTo()|
|BST|N|N|N|stay tuned|compareTo()|
|2-3 tree|c lg N|c lg N|?|yes|compareTo()|
|red-black tree|2 lg N|2 lg N|2 lg N|yes|compareTo()|
|separate chaining|lg N<sub>*</sub>|lg N<sub>*</sub>|lg N<sub>*</sub>|no|equals()|
|linear probing|lg N<sub>*</sub>|lg N<sub>*</sub>|lg N<sub>*</sub>|no|equals()|

-------------------------------------------------------------------------------------------------------------------------------

## Graph

* Definition: is a Graph from set of vertices connected pairwise by edges

* Why study graph algorithms?

    - Thousand of practical applications
    - Hundreds of graph algorithms known
    - Interesting and broadly useful abstraction
    - Challenging branch of computer science and discrete math

* Example of graph

    - protein-protein interaction network
    - The internet as mapped by the Opte project
    - Map of science click-streams
    - Facebook friends
    - One week of Enron emails
    - Framingham heart study

* Graph terminology

    - Path: sequence of `vertices`  `connected` by `edges`

    - Cycle: path whose `first` and `last` vertices are the `same`

    - Two vertices are `connected` if there is a `path between them`

* Some graph-processing problems

    - Path. Is there a path between v and w?
    - Shortest path. What is the shortest path between v and w?
    - Cycle. Is there a cycle in the graph?
    - Euler cycle. Is there a cycle that uses each edge exactly once?
    - Hamilton cycle. Is there a cycle that uses each vertex exactly once
    - Connectivity. Is there a way to connect all of the vertices?
    - MST. What is the best way to connect all of the vertices?
    - Bi-connectivity. Is there a vertex whose removal disconnects the graph?

## Undirected Graph api

* Graph drawing provides intuition about the structure of the graph
* Caveat intuition can be misleading
* Vertex representation

    - Will use integers between 0 and V-1
    - Applications: convert between names and integers which symbol table

* Operations: `addEdge(int v, int w), adj(int v), V(), E(), toString()`

 `Algorithm`

``` java
public class Graph {

    private final int vertices; 
    private int edges; 
    private Bag<Integer>[] adj; 

    public Graph(int v) {
        this.vertices = v; 
        this.edges = 0; 
        adj = (Bag<Integer>[]) new Bag[v]; 
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<Integer>(); 
        }
    }

    public int getVertices() {
        return vertices; 
    }

    public int getEdges() {
        return edges; 
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); 
        adj[w].add(v); 
        edges++; 
    }

    public int degree(int v) {
        return adj[v].size(); 
    }

    public Iterable<Integer> adj(int v) {
        return adj[v]; 
    }

}
```

* In practice, use adjacency-lists representation

    - Algorithms based on iterating over vertices adjacent to v
    - Real-world graphs tend to be `sparse`

| representation   | space         | add edge      | edge between v and w? | iterate over vertices adjacent to v? |
|------------------|---------------|---------------|-----------------------|--------------------------------------|
| list of edges    | E             | 1             | E                     | E                                    |
| adjacency matrix | v<sub>2</sub> | 1<sub>*</sub> | 1                     | v                                    |
| adjacency lists  | E+V           | 1             | degree(v)             | degree(v)                            |

-------------------------------------------------------------------------------------------------------------------------------

### Depth-first search DFS Undirected search

* Classical graphical search algorithm

* Once you explored vertex suspend then explore the new vertices

* Good example: Maze graph

    - Vertex = intersection
    - Edge = passage

* Algorithm Idea:

    - Unroll a ball of string behind you
    - Mark each visited intersection and each visited passage
    - Retrace steps when no unvisited options

* Goal: systematically search through a graph

* To visit a vertex v:    

    - Mark v as visited
    - Recursively visit all unmarked vertices w adjacent to v

* Design pattern: We decouple Graph representation from graph-processing routine

    - Create a Graph object
    - Pass the Graph to a graph-processing routine
    - Query the graph-processing routine for information

* Put unvisited vertices on a `stack`

 `Algorithm`

``` java

    public class DepthFirstPath {
        private boolean[] marked; 
        private int[] edgeTo; 
        private int s; 

        public DepthFirstPath(Graph G, int s) {
            dfs(G, s); 
        }

        private void dfs(Graph G, int v) {
            marked[v] = true; 
            for (int w : G.adj(v))
                if (!marked[w]) {
                    dfs(G, w); 
                    edgeTo[w] = v; 
                }
        }
    }

```

-------------------------------------------------------------------------------------------------------------------------------

### Breadth-first search BFS Undirected search

* Explore vertices and it's adjacency then go next vertices for exploration

* Put s into a FIFO queue, and mark s as visited, Repeat until the queue is empty

    - Remove the least recently added vertex v
    - Add each of v's unvisited neighbors to the queue, and mark them as visited

* BFS computes the shortest paths (fewest number of edges) from s to all other vertices in a graph in time proportional to E + V

* Application: routing

 `Algorithm`

``` java

    public class BreadthFirstPath {
        private boolean[] marked; 
        private int[] edgeTo; 
        private int[] distTo; 

        private void bfs(Graph G, int s) {
            Queue<Integer> q = new Queue<Integer>(); 
            q.enqueue(s); 
            marked[s] = true; 
            distTo[s] = 0; 
            while (!q.isEmpty()) {
                int v = q.dequeue(); 
                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        q.enqueue(w); 
                        marked[w] = true; 
                        edgeTo[w] = v; 
                        distTo[w] = distTo[v] + 1; 
                    }
                }
            }
        }
    }

```

### BFS vs. DFS

``` 

      1
     /  \
    /    \

   2       3
  / \     / \
 4   5   6   7
 
```

* Level order, BFS: 1, 2, 3, 4, 5, 6, 7
* Pre-order, DFS: 1, 2, 4, 5, 3, 6, 7

-------------------------------------------------------------------------------------------------------------------------------

### Connected components

* Def. vertices v and w are connected if there is a path between them
* Goal. preprocess graph to answer queries of the form is v connected to w? in constant time
* Operations: `connected(int v, int w), count(), id(int v)`

* Union-find? not quite
* Depth-first search. Yes
* The relation "is connected to" is an equivalence relation

    - Reflexive
    - Symmetric
    - Transitive

* Def. A connected component is a maximal set of connected vertices

-------------------------------------------------------------------------------------------------------------------------------

## Directed graph

* Edges now have direction
* Digraph: set of vertices connected pairwise by `direct` edges
* Example, road network

    - Vertex = intersection
    - Edge = one-way street
* Digraph application

|Digraph|Vertex|Directed Edge|
|-------|------|-------------|
|web|web page|hyperlink|
|game|board position|legal move|
|object graph|object|pointer|
|cell phone|person|placed call|
|financial|bank|transaction|
|control flow|code block|jump|
|Inheritance hierarchy |class|inherits from|

* Some digraph problems:
    - Is there a directed path from s to t?
    - Shortest path, What's the shortest directed path from s to t?
    - Topological sort, can you draw a digraph so that all edge point upwards?
    - Strong connectivity, Is there a directed path between all pairs of vertices?
    - Transitive closure, For which vertices v and w is there a path from v to w?
    - PageRank, What is the importance of a web page?

### Digraph api

* Operations: `addEdge(int v, int w), adj(int v), vertices(), edges(), reverse(), toString()`

* In practice, use adjacency-lists representation

    - Algorithms based on iterating over vertices adjacent to v
    - Real-world graphs tend to be `sparse`

| representation   | space         | add edge      | edge between v and w? | iterate over vertices adjacent to v? |
|------------------|---------------|---------------|-----------------------|--------------------------------------|
| list of edges    | E             | 1             | E                     | E                                    |
| adjacency matrix | v<sub>2</sub> | 1<sub>|<sub>^</sub></sub></sub> | 1                     | v                                    |
| adjacency lists  | E+V           | 1             | degree(v)             | degree(v)  

### DFS Digraph search

* Problem. find all vertices reachable from s along a directed path
* Some method as for undirected graphs

    - Every undirected graph is digraph (with edges in both directions)
    - DFS is a `digraph` algorithm

* Applications:

    1\. Program control-flow analysis

        - Vertex = basic block of instructions
        - Edge = jump
        - Benefits
            + Dead-code elimination, find and remove unreachable code
            + Infinite-loop detected, Determine whether exit is unreachable

    2\. Mark-sweep garbage collector

        - Vertex = object
        - Edge = reference

* DFS enables direct solution of simple digraph problems

    1\. Reachability
    2\. Path finding
    3\. Topological sort
    4\. Directed cycle direction

* Basis for solving difficult digraph problems

    1\. 2- satisfiability
    2\. Directed Euler path
    3\. Strongly-connected components

### BFS Digraph search

* BFS is a `digraph` algorithms
* BFS computes shortest paths (fewest number of edges) from s to all other vertices n a digraph in time proportional to E+V

### Topological sort

* DAG Directed acyclic graph, has no cycle

### Strong component

-------------------------------------------------------------------------------------------------------------------------------

## MST (Minimum spanning tree)

* Edge-weighted graph: is a graph with weights or costs with each edge
* Spanning tree connected sub graph with no cycles that includes all vertices
* Minimum Spanning tree: spanning tree who weight no larger than the weight of any other spanning tree
* MST is fundamental problem with diverse application
    - Cluster analysis
    - Real-time face verification
    - Image registration with renyi entropy
    - Find road networks in satellite and aerial imagery
    - Network design (communication, electrical, computer, road)
    - Auto config protocol for ether bridging to avoid cycles in a network
    - Reducing data storage in sequencing amino acids in a protein

### Greedy algorithm

* Simplifying assumptions
    - Edge weights are `distinct`

    - Graph is `connected`

    - Based on these `MST exists and unique`

* Cut property
    - Partition of its vertices into two nonempty set
    - Crossing edge connected a vertex in one set with a vertex in the other

* Greedy MST algorithm
    - Start with all edges colored gray
    - Find cut with no block crossing edges, color its min0weight edge black
    - Repeat until V-1 edges are colored black

* Efficient implementations. Choose cut? find min-weight edge?
    - Kruskal's algorithm [stay tuned]
    - Prim's algorithm [stay tuned]
    - Boruvka's algorithm

* Q. What if edge weights are not all distinct?
    - A. Greedy MST algorithm still correct if equal weights are present!

* Q. What iff graph is not connected?
    - A. Compute m,minimum spanning forest = MST of each components

### Kruskal's algorithm

* classical algorithm for computing MST
*  Steps:

    - Consider edges in ascending order of weight
    - Add next edge to tree T unless doing so would create a cycle
    - Ignore edge that create a cycle

* We will use `union-find` to add edge `v-w` to tree that not creating cycle
* And use `Min-Priority-Queue` to detect the min weight

### Prim's algorithm

* Classical algorithm for computing MST
* Steps:

    - Start with vertex 0 and greedily grow tree T
    - Add to T the min weight edge with exactly one endpoint in T
    - Repeat until V-1 edges

### MST context

 
-------------------------------------------------------------------------------------------------------------------------------

## Shortest path

* Given an edge weighted digraph, find the shortest path from s to t

* Applications:

    - Google maps
    - Car navigation
    - Network routing protocols (OSPF, BGP, RIP)
    - Optimal pipelining of VLSI chip
    - Robot navigation

* Which vertices?

    - Source-sink: from one vertex to another
    - Single source: from one vertex to every other
    - All pairs: between all pairs of vertices

* Restrictions on edge weights

    - Nonnegative weights
    - Arbitrary weights
    - Euclidean weights

* Cycles?
    - No directed cycles
    - No "negative cycles"

### Weighted directed edge API

* DirectedEdge API

``` java
public class DirectedEdge {

    DirectedEdge(int v, int w, double weight)

    int from()

    int to()

    double weight()

    String toString()
}

```

* Edge-weighted digraph API

``` java
public class EdgeWeightedDigraph {

    EdgeWeightedDigraph(int v)

    void addEdge(DirectedEdge e)

    Iterable<DirectedEdge> adj(int v)

    int V()

    int E()

    Iterable<DirectedEdge> edges()

    String toString()
}
```

`TODO` continue from Minimum spanning tree
-------------------------------------------------------------------------------------------------------------------------------

## Strings

* Definition `string` is a sequence of characters
* Important fundamentals abstractions
    - Information processing
    - Genomic sequences
    - Communication systems (e.g email)
    - Programming systems (e.g java programs)
* C char data type
    - Supports 7-bit ASCII
    - Can represent only 256 characters

### Strings in java

* Java char data type
    - Support 16-bit Unicode
    - Support 21-bit Unicode 3.0

* String data type in Java. sequence of characters (immutable)
* Length. Number of characters
* Substring extraction. Get a contiguous subsequence of characters
* String concatenation. Append one character to end of another string

 `representation in java`

``` java
public final class String implements Comparable<String> {
    private char[] value; // characters
    private int offset; // index of first char in array
    private int length; // length of substring
    private int hash; // cache of hashCode()

    public int length() { return length;}

    public char charAt(int i) { return value[i + offset];}

    private String(int offset, int length, char[] value) {
        this.offset = offset;
        this.length = length;
        this.value = value;
    }

    public String substring(int from, int to) {
        return new String(offset + from, to - from, value); // copy of reference to char array
    }
}

```

* String data type performance

|operation|guarantee|extra space|
|---------|---------|-----------|
|length()|1|1|
|charAt()|1|1|
|substring()|1|1|
|concat()|N|N|

    - Memory `40+2N` bytes for a virgin String of length of N

* StringBuilder data type performance

|operation|guarantee|extra space|
|---------|---------|-----------|
|length()|1|1|
|charAt()|1|1|
|substring()|N|N|
|concat()|1<sub>*</sub>|1<sub>*</sub>|

    - Remark StringBuffer data type is similar, but thread safe (and slower)

* For `Concat` string use `StringBuilder` , for `substring()` use `String`

* Alphabets
    - Radix. Number of possible value in String

    |name|R()|lgR()|characters|
    |----|---|-----|----------|
    |Binary|2|1|01|
    |Octal|8|3|01234567|
    |Decimal|10|4|0123456789|
    |HexaDecimal|16|4|0123456789ABCED|
    |DNA|4|2|ACTG|
    |LowerCase|26|5|a-z|
    |UpperCase|26|5|A-Z|
    |Protein|20|5|A-Y|
    |Base64|64|6|A-Za-z0-9+/|
    |ASCII|128|7|ASCII characters|
    |Extended ASCII|256|8|extended ASCII characters|
    |Unicode16|65536|16|unicode characters|

### Key-indexed counting algorithms

* we stop in sort at Heap sort
    - Lower bound ~ N lg N compares required by any compared-based algorithm
    - Q. Can e do better (despite the lower bound) ?  

        A. Yes if e don't depend o key compares

* Frequency of operations = key compares
* Assumption about keys
    - Assumption. Keys are integers between 0 and R-1
    - Implication. Can use key as an array index
    - Applications

        1\. Sort string by first letter
        2\. Sort class roster by section
        3\. Sort phone numbers by area code
        4\. Subroutine in a sorting algorithm

    - Remark. keys may have associated data => can't just count up number of keys of each value

* Steps
    - Count frequencies of each letter using key as index
    - Compute frequency cumulates which specify destination
    - Access cumulates using key as index to remove items
    - Copy back into original array

* Performance ~ `11 N + 4 R` and use extra space `N + R`

    - R is Radix from table above

 `algorithms`

``` java
    public final static void sort(char[] a) {
        int N = a.length;
        int R = 256;
        int[] count = new int[R + 1];
        char[] aux = new char[N];
        for (int i = 0; i < N; i++)
            count[a[i] + 1]++; // count frequencies offset by 1

        for (int r = 0; r < R; r++)
            count[r + 1] += count[r]; // compute cumulates

        for (int i = 0; i < N; i++)
            aux[count[a[i]]++] = a[i]; // move items

        for (int i = 0; i < N; i++)
            a[i] = aux[i]; // copy back
    }
```

### Least-significant-digit-first (LSD radix) string sort

* LSD string (radix) sort
    - Consider characters from right to left
    - Stably sort using d<sub>th</sub> character as the key (using key-indexed counting)

``` java
public static void sort(String[] a, int W) { // Fixed length W strings
        int R = 256; // radix R
        int N = a.length;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) { // do key-indexed counting for each digit from right to left
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++; // key-indexed counting
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
```

* Summary of the performance of sorting algorithms

|algorithm|guarantee|random|extra space|stable?|operations on keys|
|---------|---------|------|-----------|-------|------------------|
|insertion sort|N<sup>2</sup>/2|N<sup>2</sup>/4|1|yes|compareTo()|
|mergesort|N lg N|N lg N|N |yes|compareTo()|
|quicksort|1.39 N lg N|1.39 N lg N|c lg N |no|compareTo()|
|heapsort|2 N lg N|2 N lg N|1|no|compareTo()|
|LSD<sup>*</sup>|2 N W|2 N W|N + R|yes|charAt()|

### Most-significant-digit-first (MSD radix) string sort

* Steps
    - Partition array into R pieces according to first character (use key-indexed counting)
    - Recursively sort all strings that start ith each character (key-indexed counts delineate subarrays to sort)

 `Algorithm`

``` java
  public final static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private final static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (hi <= lo)
            return;
        int R = 256;
        int[] count = new int[R + 1];
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1); // sort R subarrays recursively
    }

    private final static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }
```

* Observation 1. Much too slow for small subarrays
    - Each function call needs its own count[] array
    - ASCII (256 counts) 100x slower than copy pass for N=2
    - Unicode (65,536 counts): 32.000x slower for N = 2

* Observation 2. Huge number of small subarrays because of recursion

* Improvement

    1\. Cutoff to insertion sort for small subarrays

* Disadvantage of MSD string sort
    - ACcess memory "randomly" (cache inefficient)
    - Inner loop has a lot of instructions
    - Extra space for count[]
    - Extra space for aux[]

* Disadvantage of quicksort
    - Linearithmic number of string compares (not linear)
    - Has to re-scan many characters in keys with long prefix matches

* Complexity

|algorithm|guarantee|random|extra space|stable?|operations on keys|
|---------|---------|------|-----------|-------|------------------|
|insertion sort|N<sup>2</sup>/2|N<sup>2</sup>/4|1|yes|compareTo()|
|mergesort|N lg N|N lg N|N |yes|compareTo()|
|quicksort|1.39 N lg N|1.39 N lg N|c lg N |no|compareTo()|
|heapsort|2 N lg N|2 N lg N|1|no|compareTo()|
|LSD<sup>*</sup>|2 N W|2 N W|N + R|yes|charAt()|
|MSD<sup>*</sup>|2 N W|N log<sub>2</sub>N|N + D R|yes|charAt()|

### 3-Way string quicksort

### Suffix arrays

-------------------------------------------------------------------------------------------------------------------------------

## Search in String

* Data structure for searching in String
* Complexity for previous searching

|algorithm|search|insert|delete|ordered operations|operations on keys|
|---------|------|------|------|------------------|------------------|
|red-black BST|lg N|lg N|lg N|yes|compareAt()|
|hash table|1<sup>*</sup>|1<sup>*</sup>|1<sup>*</sup>|no|compareAt()|

* Q. Can we do better?  

    A. yes, if we can avoid examining the entire key, as with string sorting 

* String symbol table API

``` java
public class StringST<Value> {
    StringST()

    void put(String key, Value val)

    void get(String key)

    void delete(String key)
}
```

* Goal. Faster than hashing, more flexible than BSTs
* Challenge. Efficient performance for string keys

### R-way Tries

* From retrieval, but pronounced "try"
* For now store characters in nodes (not key)
* Each node has R children, one for each possible character
* Store values in nodes corresponding to last characters in keys
* Search in a trie
    - Follow links corresponding to each character in the key
    - Search hit: node where search ends has a non-null value
    - Search miss: reach null link or node where search ends has null value

* Delete in an R-way tries
    - Find the node corresponding to key and set value to null
    - If node has null value and all null links, remove that node (and recur)

* Trie performance
    - Search hit. Need to examine all L characters for equality
    - Search miss. Could have mismatch on first character, typical case examine only a few characters
    - Space. R null links at each leaf. (but sub-linear space possible if many short strings share common prefixes)
    - Bottom line. Fast search hit and even faster search miss, but `wastes space`

* Goal. Design a data structure to perform efficient spell checking
    - Solution. Build a 26 way trie (key = word, value = bit), 26 English letters

 `Implementation`

``` java

public class TriesST<Value> {

    private final static int R = 256;
    private Node root = new Node();

    private class Node {
        private Object val;
        private Node[] next = (Node[]) new Object[R];
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node node, String key, Value val, int d) {
        if (node == null)
            node = new Node();
        if (d == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(d);
        node.next[c] = put(node.next[c], key, val, d + 1);
        return node;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null)
            return null;
        return (Value) node.val;
    }

    private Node get(Node node, String key, int d) {
        if (node == null)
            return null;
        if (d == key.length())
            return node;
        char c = key.charAt(d);
        return get(node.next[c], key, d + 1);
    }
}
```

* Comparison 

|algorithm|search|search miss|insert|space|
|---------|------|-----------|------|-----|
|red-black BST|L + c lg<sup>2</sup> N|c lg<sup>2</sup>N|c lg<sup>2</sup>N|4N|
|hash table (linear probing)|L|L|L|4N to 16N|
|R-way tries|L|log<sub>*</sub>N|L|(R+1)N|

* R-way tries
    - Method of choice for small R
    - Too much memory for large R

* Challenge. Use less memory, e.g. 65, 536-way trie for Unicode!

### Ternary Tries

* Store characters and values in nodes (not keys)
* Each node has 3 children: small(left), equal(middle), larger(right)
* Follow links corresponding to each character in the key
    - If less take left link, if greater take right link
    - If equal take the middle link and move to the next key character

* Search hit. Node where search ends has a non-nul value
* Search miss. Reach a null link or node where search node ends has null value

* 26-way trie vs. TST

    - 26-way trie. 26 null links in each leaf
    - TST. 3 null links in each leaf

* Comparison 

|algorithm|search|search miss|insert|space|
|---------|------|-----------|------|-----|
|red-black BST|L + c lg<sup>2</sup> N|c lg<sup>2</sup>N|c lg<sup>2</sup>N|4N|
|hash table (linear probing)|L|L|L|4N to 16N|
|R-way tries|L|log<sub>*</sub>N|L|(R+1)N|
|TST|L + ln N|ln N|L + ln N|4 N|

* Remark. can build balanced TST via rotations to achieve `L + Log N` worst-case guarantees

* String symbol table implementation cost summary

|algorithm|search|search miss|insert|space|
|---------|------|-----------|------|-----|
|red-black BST|L + c lg<sup>2</sup> N|c lg<sup>2</sup>N|c lg<sup>2</sup>N|4N|
|hash table (linear probing)|L|L|L|4N to 16N|
|R-way tries|L|log<sub>*</sub>N|L|(R+1)N|
|TST|L + ln N|ln N|L + ln N|4 N|
|TST with R<sup>2</sup>|L + ln N|ln N|L + ln N|4 N + R<sup>2</sup>|

* Bottom line. TST is as fast as hashing (for string keys), space efficient

* TST vs. hashing
    - Hashing

        1\. Need to examine entire key
        2\. Search hits and misses cost about the same
        3\. Performance relies on hash function
        4\. Does not support ordered symbol table operations

    - TSTs.

        1\. works only for strings \(or digital keys\)
        2\. Only examines just enough key characters
        3\. Search miss may involve only a fe characters
        4\. Supports ordered symbol table operations \(plus others\)

* Bottom line. TSTs are:
    - Faster than hashing (especially for search misses)
    - More flexible than red-black BSTs [stay tuned]

### Character based operations

* The string symbol table API supports several useful character-based operations

* Prefix match. keys with prefix "sh": "she", "shells" and "shore"

* wildcard match. keys that match ".he": "she" and "the"

* Longest prefix. key that is the longest prefix of "shellsort": "shells"

* Prefix matches
    - Find all keys in a symbol table starting with a given prefix
    - Ex. Autocomplete in a cell phone, search bar (Google search), text editor or shell

        1\. User types characters one at a time
        2\. System reports all matching strings

* T9 texting
    - Goal. type text messages on a phone keypad
    - Multi-tap input. Enter a letter by repeatedly pressing a key until the desired
    - T9 text input

        1\. Find all words that correspond to given sequence of numbers
        2\. Press 0 to see all completion options

* Patricia trie
    - Remove one-way branching
    - Each node represents a sequence of characters
    - Implementation: one step beyond this course
    - Applications

        1\. Database search
        2\. P2P network search
        3\. IP routing table: find longest prefix match
        4\. Compressed quad-tree for N-body simulation
        5\. Efficiently storing and query XML documents

### String symbol tables summary

* A success stroy in algorithm design and analysis

* Red-black BST
    - Performance guarantee: log N key compares
    - Supports ordered symbol table API

* Hash tables
    - Performance guarantee: constant number of probes
    - Requires good hash function for key type

* Tries. R-way TST
    - Performance guarantee: log N characters accessed
    - Support character-based operations

 `Bottom line. You can get at anything by examining 50-100 bits!!!!!`

### Substring search

* Goal. find pattern of length <i>M</i> in a text of length <i>N</i> typically N>>M
* Applications
    - Find and replace
    - computer forensics. Search memory or disk for signatures, e.g. al URLs or RSA keys that the user has entered
    - Identify patterns indicative of spam

        1\. Profits
        2\. Lose weight
        3\. herbal viagra
        4\. there is no catch
        5\. this is a one-time mailing
        6\. this message is sent in compliance with spam regulations

    - Screen scraping. Extract relevant data from web page

        1\. Ex\. find string delimited by <b> and </b> after first occurrence of pattern last trade

#### Brute-force substring search

* Check for pattern starting at each text position
* Worst case ~ <i>M N</i> char compares
* Brute-force algorithm can be slow if text and pattern are repetitive

 `algorithm`

``` java
    public final static int indexOf(String text, String sub) {
        int N = text.length();
        int M = sub.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (sub.charAt(i + j) != text.charAt(j))
                    break;
                if (j == M)
                    return i; // index in text where patterns starts
            }
        }
        return N; // not found
    }
```

* Bad performance for search in repeated e.g. "AB" in "AAAAAAAAAB"

* Backup
    - In  many applications, we want to avoid backup in text stream

        1\. Treat input as stream of data
        2\. Abstract model: standard input

``` java
    public final static int indexOfEnhanced(String text, String sub) {
        int i, N = text.length();
        int j, M = sub.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == sub.charAt(j))
                j++;
            else { // backup
                i -= j;
                j = 0;
            }
        }
        if (j == M)
            return i - M;
        else
            return N;
    }
```

* Brute-force is not always good enough
* Theoretical challenge. Linear-time guarantee
* Practical challenge. Avoid backup in text stream

#### Knuth-Morris-Pratt substring search

* Coolest algorithm :)
* This is the algorithm when theoretical meets practices, this discovered by two theoreticians and a hacker
* Intuition. Suppose e are search in text for pattern BAAAAAAAAA
* Clever method to avoid backup in brute-force substring
* Deterministic finite state automaton (DFA)
    - Finite number of states (includes start and halt)
    - Exactly one transition for each char in alphabet
    - Accept if sequence of transitions leads to halt state

* Q. what is interpretation of DFA state after reading in txt[i]?
    - A. State = number of characters in pattern that have been matched

* Key difference from brute-force implementation
    - Need to pre-compute dfa[][] from pattern
    - Text pointer i never decrements

* Running time
    - Simulate DFA on text: at most N character accesses
    - Build DFA: ho to do efficiently? [warning: tricky algorithm ahead!]

* How to build DFA from pattern?

    - if in state j and next char `c != pat.charAt(j)` , then the last `j-1` characters of input are pat[1..j-1] followed by c

* Proposition. KMP substring search access no more than `M + N` chars to search for a pattern of length M in a text of length N
    - Pf. each pattern char accessed once when constructing DFA, each text char accessed once (in the worst case) when simulating of the DFA

* Proposition. KMP constructs dfa[][] in time and space proportional to RM

 `algorithm`

``` java
public class KMP {

    private static final int R = 256;

    private int M;
    private int[][] dfa;

    public KMP(String pattern) {
        M = pattern.length();
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;
        for (int i = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][i]; // copy mis-match cases
            }
            dfa[pattern.charAt(j)][j] = j + 1; // set match case
            i = dfa[pattern.charAt(j)][i]; // update restart state
        }
    }

    public int search(String text) {
        int i, j, N = text.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j]; // no backup
        }
        if (j == M)
            return i - M;
        else
            return N;
    }
}
```

#### Boyer-Moore

* KMP in linear time can we improve over that? yes : D

* Rather than scan elements from left to right will do scan from right to left

, to know fast if then end pattern matches or not to avoid from 1 to M-1

* Key here: find the mismatch quickly

* Steps
    - Scan characters in pattern from right to left
    - Can skip as many as M text chars when finding one not in the pattern

* How much to skip?

    - Pre-compute index of rightmost occurrence of character c in pattern (-1 if character not in the pattern)

* Property. substring search with the Boyer-Moore mismatched character heuristic takes about ~ `N / M` character compares to search for a pattern of length M in a text of length N

* worse-case can be as bad as ~ `M N`

* Boyer-Moore variant. Can improve worst case to ~ `3 N` by adding a KMP-like rule to guard against repetitive patterns

 `algorithm`

``` java
public class BoyerMoore {

    private final int R;
    private int[] right;
    private String pat;

    public BoyerMoore(String pattern) {
        this.R = 256;
        this.pat = pat;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pat.length(); j++)
            right[pat.charAt(j)] = j;

    }

    public int indexOf(String text) {
        int N = text.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }

            if (skip == 0)
                return i;
        }
        return -1; // not found
    }
}
```

#### Rabin-Karp algorithm

* Basic idea = modular hashing

    - Computer a hash of pattern characters 0 to M-1
    - For each i, compute a hash of text characters i to M+i-1
    - If pattern hash = text substring hash check for a match

* Complexity `7N`

* Advantage

    - Extends to 2d patterns
    - Extends to finding multiple patterns

 `algorithm`

``` java
public class RabinKarp {

    private long patHash; // pattern hash
    private int M; // pattern length
    private long Q; // modulus
    private int R; // radix
    private long RM; // R^(M-1)%Q

    public RabinKarp(String pattern) {
        M = pattern.length();
        R = 256;
        Q = longRandomPrime();

        RM = 1;

        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pattern, M);
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public int search(String text) {
        int N = text.length();
        long txtHash = hash(text, M);

        if (patHash == txtHash)
            return 0;

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + 0 - RM * text.charAt(i - M) % Q) % Q;
            txtHash = (txtHash + R + text.charAt(i)) % Q;

            if (patHash == txtHash)
                return i - M + 1;

        }
        return -1;
    }
}
```

* Compare the substring algorithms

|algorithm|version|guarantee|typical|backup in input|correct|extra space|
|---------|-------|---------|-------|---------------|-------|-----------|
|brute force|M N|1.1 N|yes|yes|1|
|knuth-Morris-Pratt (full DFA)|2 N|1.1 N|no|yes|M R|
|knuth-Morris-Pratt (mismatch transitions only)|3 N|1.1 N|no|yes|M|
|Boyer-Moore (full algorithm)|3 N|N / M|yes|yes|R|
|Boyer-Moore (mismatched char)|M N|N / M|yes|yes|R|
|Robin-Karp (monte carlo)|7 N|7 N|no|yes<sup>*</sup>|1|
|Robin-Karp (las vegas)|7 N<sup>*</sup>|7 N|yes|yes|1|

`*` probability guarantee with uniform hash function

-------------------------------------------------------------------------------------------------------------------------------

## Regular expression

-------------------------------------------------------------------------------------------------------------------------------

## Data compression

### Introduction

* Compression reduces size of a file

    - To save space when sorting it
    - To save time when transmitting it
    - Most files have lots of redundancy

* Who needs compressions?

    - Moore's law: # transistors on a chip doubles every 18-24 months
    - Parkinsons' law: data expands to fill space available
    - Text, image, sound, video, ....

* Applications

    - Generic file compression

        1\. Files:GZIP, BZIP, 7z
        2\. Archives: RKZIP
        3\. File systems: NTFS, HFS\+, ZFS

    - Multimedia

        1\. Images: GIF, JPEG
        2\. Sound: MP3
        3\. Video: MPED, DivX, HDTV

    - Communication

        1\. ITU-T T4 Group 3 fax
        2\. Skype

    - Databases

        1\. Google
        2\. Facebook

* Lossless compression and expansion

    - Message. Binary data B we want to compress

    - Compress. Generates a "compressed" representation C(B)

    - Expand. Reconstructs original bit-stream B

    - Compression ration. Bits in `C(B) / bits in B`

    - Ex. 50-75% or better compression ration for natural language

* Food for thought

    - has played a central role in communication technology

        1\. Grade 2 Braille
        2\. Morse code
        3\. Telephone systems

        , And is part of modern life

        4\. MP3
        5\. MPEG

* Another application. Data representation: genomic code

    - Genome. String over the alphabet { A, C, T, G }
    - Goal. Encode an N-character genome: ATAGATGCATِG....
    - Standard ASCIII encoding

        1\. 8 bits per chars

    - Two-bit encoding

        1\. 2 bits per chars

    - Fixed-length code. A-bit code support alphabet of size 2<sup>k</sup>
    - Amazing but true. Initial genomic databases in 1990s used ASCII

### Run length coding

* Simple type of redundancy in a bitstream. Long runs of repeated bits
    - This string `0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1`

    - Representation. 4-bit counts to represent alternating runs of 0s and 1s: 15 0s, then7 1s, then 7 0s, then 11 1a
    - Q. How many bits to store the counts?

        A. We'll use 8 (but 4 in the example above)

    - Q. What to do when run length exceeds max count?

        A. if longer than 55, intersperse runs on length -

    - Applications. JPEG, ITU-T T$ Group 3 fax, ....

### Huffman compression

* Variable-length codes
* Use different number of bits to encode different chars
* Ex. Morse code: `. . . - - - . . .`

* Issue. Ambiguity

    SOS ?
    V7 ?
    IAMIE ?
    EEWNI ?

* Q. How do we avoid ambiguity?

    A. Ensure that no codeword is a `prefix` of another
    Ex 1. Fixed-length code
    Ex 2. General prefix-free code

* Q. How to represent the prefix-free code?

    A. A binary trie!
        . Chars in leaves
        . Codeword is path from root to leaf

* Compression

    - Method 1: start at leaf, follow path up to the root, print bits in reverse
    - Method 2: creates ST of key-value pairs

* Expansion

    - Start at root
    - Go left if bit is 0, go right if 1
    - If leaf node, print char and return to root

* Q. How to write the trie?

    A. Write pre-order traversal of trie, mark leaf and internal nodes with a bit 

* How to find best prefix-free code?

    - Shannon-Fano algorithm

        . Partition symbols S into two subsets S0 and S1 of (roughly) equal freq
        . Codewords for symbols in S0 start with 0, for symbols in S1 start with 1
        . Recur in S0 and S1
    

    - Problem 1. How to divide up symbols?
    - Problem 2. Not optimal!

* Huffman algorithm demo

    - Start with one node corresponding to each character wit weight equal to frequency

    - Select two tries with min weight

    - Merge into single trie with cumulative weight

* Applications

    - JPEG
    - PDF adobe
    - MP3
    - Divx MPEG4
    - Gzip

* Huffman codes

    - Q. How to find best prefix-free code?

        . Huffman algorithm:

            1\. Count frequency freq\[i\] for each char i in input
            2\. Start with one node corresponding to each char i \(with weight freq\[i\]\)
            3\. Repeat until single trie formed

                Select two tries with min weight freq[i] and freq[j]  
                Merge into single trie with freq[i] + freq[j]

* Running time. Use a binary heap `N + R log R`

-------------------------------------------------------------------------------------------------------------------------------

### LZW compression

*  Static model. Same model for all texts

    

    - Fast
    - Not optimal: different texts have different statistical properties
    - Ex: ASCII, Morse code

* Dynamic model. Generate model based on text

    - Preliminary pass needed to generate model
    - Must transmit the model
    - Ex: Huffman code

* Adaptive model. Progressively learn and update model as you read text

    - More accurate modeling produces better compression
    - Decoding must start from beginning
    - EX: LZW

* Steps

    1\. Create ST associating W-bit codewords with string keys
    2\. Initialize ST with codewords for single-char keys
    3\. Find longest string s in ST that is a prefix of un-scanned part of input
    4\. Write the w-bit codeword associated with s
    5\. Add s\+c to ST, where c is next char in the input

* Q. How to represent LZW compression code table?
    - A. A trie to support longest prefix match

* How big to make ST?
    - How long is message?
    - While message similar model
    - [many variations have been developed]

* What to do when ST fills up?
    - Throw away and start over [GIF]
    - Throw away when not effective [Unix compression]
    - [many other variations]

* LZW in the real world

    - Lempel-Ziv and friends

        . LZ77
        . LZ78
        . LZW
        . Deflate / zlib = LZ77 variant + huffman

-------------------------------------------------------------------------------------------------------------------------------

### Data compression summary

* Lossless compression
    - Represent fixed-length symbols with variable-length codes [huffman]
    - Represent variable-length symbols with fixed-length codes [LZW]

* Lossy compression [not covered in this course]

    - JPEG, MPEG, MP3
    - FFT, wavelets, fractals

-------------------------------------------------------------------------------------------------------------------------------

## Overview: introduction to advanced topics

* Reduction: design algorithms, establish lower bounds, classify problems
* Linear programming: the ultimate practical problem-solving model
* Intractability: problems beyond our reach
* Shifting gears

    - From individual problems to problem-solving models
    - From linear/quadratic to polynomial/exponential scale
    - From details of implementation to conceptual framework

* Goal

    - Place algorithms we've studied in a larger context
    - Introduce you to important and essential ideas
    - Inspire you to learn more about algorithms :smile: !

-------------------------------------------------------------------------------------------------------------------------------

### Reductions

* Classify problems according to computational requirements

|complexity|order of growth|examples|
|----------|---------------|--------|
|linear|N|min, max, median, burrows-wheeler transform|
|linearithmic|N log N|sorting, convex hull, closest pair, farthest pair|
|quadratic|N2|?|
|.....|.....|.....|
|exponential|c<sup>N</sup>|?|

* Frustrating news. Huge number of problems have defined classification

* Suppose we could (could not) solve problem X efficiently

what else could (could not) we solve efficiently?

* Definition
    - Problem X reduces to problem Y if you can use an algorithm that solves Y to help solve X
    - Cost of solving X = total cost of solving Y + cost of reduction
    - Ex 1. [finding the median reduces to sorting]

        . To find median of N items

            1\. Sort N items
            2\. Return item in the middle

        . Cost of solving finding the median `N log N + 1`

    - Ex 2. [element distinctness reduces to sorting]

        . To solve elements distinctness on N times:

            1\. Sort N items
            2\. Check adjacent paris for equality

        . Cost of solving finding the median `N log N + 1`

-------------------------------------------------------------------------------------------------------------------------------

### Design algorithms

* Def. Problem X reduces to problem Y if you can use an algorithm that solves Y to help solve X
* Design  algorithm. Given algorithm for Y, can also solve X
* Ex.
    - 3-collinear reduces to sorting
    - Finding the median reduces to sorting
    - Element distinctness reduces to sorting
    - CPM reduces to topological sort
    - Arbitrage reduces to shortest paths
    - Burrows-wheeler transform reduces to suffix sort

* Mentality. Since I know how to solve Y, can I use that algorithm to solve X

-------------------------------------------------------------------------------------------------------------------------------

### Establish lower bound

* Goal. prove that a problem require a certain number of steps
* Ex. In decision tree model, any compare-based sorting algorithm requires theta N log N in the worst case
* BAd news. very difficult to establish lower bounds from scratch
* Good news. spreed theta N log N lower bound to Y by reducing sorting to Y

* Linear-time reductions

    - Def. problem X `linear-time reduces` to problem Y if x can be solved with:

        . Linear number of standard computational steps
        . Constant number of calls to Y
    

    - Ex. almost all of the reductions we've seen so far

    - Establish lower bound

        . If x takes theta N log N steps, then so does Y
        . If x takes theta N<sup>2</sup>, then so does Y
        

    - Mentality

        . If I could easily solve Y, then I could easily solve X
        . I can't easily solve X
        . Therefore, I can't easily solve Y
    

-------------------------------------------------------------------------------------------------------------------------------

### Classify problems

* Desiderata. Problem with algorithm that matches lower bound
    - Ex. sorting and convex hull have complexity of N log N

* Desiderata. prove that two problems X and Y have the same complexity
    - First, show that problem X linear-time reduces to Y
    - Second, show that Y linear-time reduces to X
    - Concludes that X and Y have same complexity

* Integer arithmetic reductions

    - Integer multiplication. given two N-bit integers, compute their product
    - Brute force. N<sup>2</sup> bit operations
    - Q. Is brute-force algorithm optimal?

-------------------------------------------------------------------------------------------------------------------------------

[Open-Source-img]: https://badges.frapsoft.com/os/v1/open-source.svg?v=103
[alg-img]: https://img.shields.io/static/v1?label=Topic&message=Algorithms&color=orange&style=flat
[datastructure-img]: https://img.shields.io/static/v1?label=Topic&message=Datastructure&color=blue&style=flat
