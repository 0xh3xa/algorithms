# Algorithms :heart: :smile:
![Algorithms][alg-img] ![Datastructure][datastructure-img] ![Open Source Love][Open-Source-img]

Algorithms and data structures implementations from the `Algorithms 4th edition` :book: :atom:

## What's is this course?

* Intermediate level survey course
* Programming and problem solving with applications

## Definition

* `Algorithms` : Method for solving a problem
* `Data structures` : Method to store information
* `Program = Algorithms + Data structures` 

## Topics

`Part I` 

01. Data types: stack, queue, bag, union find, priority queue  
02. Sorting: quicksort, mergesort, heapsort, radix sorts  
03. Searching: BST, red-black BST, hash table  

`Part II` 

04. Graphs: BFS, DFS, Prime, Kruskal, Dijkstra  
05. Strings: KMP, regular expression, TST, Huffman, LZW  
06. Advanced: B-tee, suffix array, maxflow  

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

## Steps for solving the problem

01. Model the problem  
02. Find an algorithm to solve it  
03. Fast enough? Fits in memory?  
04. If not, figure out why  
05. Find a way to address the problem  
06. Iterate until satisfied  

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

-------------------------------------------------------------------------------------------------------------------------------

## Properties

01. Reflexive: p is connected to q  
02. Symmetric: if p is connected to q, then q is connected to p  
03. Transitive: if p is connected to q and q is connected to r, then p is connected to r

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

02. Quick union with path compression `N+ M lg N` 
03. Weighted Quick union with path compression `N+ M lg*N` 

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

```java
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

```java
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

    - `Remark` StringBuffer data type is similar, but thread safe (and slower)

* For `Concat` string use `StringBuilder`, for `substring()` use `String`
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

### Key indexed counting

[Open-Source-img]: https://badges.frapsoft.com/os/v1/open-source.svg?v=103
[alg-img]: https://img.shields.io/static/v1?label=Topic&message=Algorithms&color=orange&style=flat
[datastructure-img]: https://img.shields.io/static/v1?label=Topic&message=Datastructure&color=blue&style=flat


















































