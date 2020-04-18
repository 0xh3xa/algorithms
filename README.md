# Algorithms :heart: :smile:
![Algorithms][alg-img] ![Datastructure][datastructure-img] ![Open Source Love][Open-Source-img]

Algorithms and data structures implementations from the `Algorithms 4th edition` :book: :atom:

## What's is this course?
- Intermediate level survey course
- Programming and problem solving with applications

## Definition
- `Algorithms`: Method for solving a problem
- `Data structures`: Method to store information
- `Program = Algorithms + Data structures`

## Topics

`Part I`  

1. Data types: stack, queue, bag, union find, priority queue  
2. Sorting: quicksort, mergesort, heapsort, radix sorts  
3. Searching: BST, red-black BST, hash table  

`Part II`  

4. Graphs: BFS, DFS, Prime, Kruskal, Dijkstra  
5. Strings: KMP, regular expression, TST, Huffman, LZW  
6. Advanced: B-tee, suffix array, maxflow  

## Why Algorithms is so important?
Algorithms all around us  

1. Internet: Web search, packet routing, distribute file sharing, ...  
2. Biology: Human genome project, protein folding, ...  
3. Computers: Circuit layout, file system, compilers, ...  
4. Computer graphics: Movies, Video games, virtual reality, ...  
5. Security: Cell phones, e-commerce, voting machines, ...  
6. Multimedia: MP3, JPG, Divx, HDTV, face recognition, ...  
7. Social networks: Recommendations, news feeds, advertisements, ...  
8. Physics: N-body simulation, particle collision simulation, ...  

## Steps for solving the problem
1. Model the problem  
2. Find an algorithm to solve it  
3. Fast enough? Fits in memory?  
4. If not, figure out why  
5. Find a way to address the problem  
6. Iterate until satisfied  

## Algorithm Analyze

### Reasons to Analyze Algorithms
- Predict performance
- Compare algorithms
- Provide guarantees
- Understand theoretical basis

### The scientific method
- Observe some feature in the natural world
- Hypothesize a model that is consistent with the observations
- Predict events using the hypothesis
- Verify the predictions by making further observations
- Validate by repeating until the hypothesis and observations agree

### Principles
- Experiments must be reproducible.
- Hypotheses must be falsifiable.

### Empirical Analysis
- Manual measurement (benchmarking) with a stopwatch or programmatic timing method.
- Measure running time for different input sizes *N* (e.g. doubling time) and observe the relationship between the running times.

### Data Analysis
- Plot running time T(N) vs input size *N*.
- Plot as log-log plot, often get a straight line. lg(T(N)) vs lg(N). Plot tells you the exponent of *N*.
- Regression, power law: *a x N<sup>b</sup>*
- Once you have the power b from the slope of the log-log plot, solve for *a* in the equation *T(N) = a x N<sup>b</sup>*

### Doubling Hypothesis
- Run program, doubling the size of the input and observe ratios. Observe to what it converges, do not take the average!

|  N   | T(N) | Ratio | lg(Ratio) |
| ---- | ---- | ----- | --------  |
| 1000 | 0.1  |   -   |     -     |
| 2000 | 0.8  |  7.7  |    2.9    |
| 4000 | 6.4  |   8   |     3     |
| ...  | ...  |  ...  |    ...    |

- Hypothesis: Running time is about *a x N<sup>b</sup>*, where *b = lg(Ratio)*
- Caveat: Cannot identify logarithmic factors with the doubling hypothesis.
- Calculate *a* by solving *T(N) = a x N<sup>b</sup>* for a with all other variables now known.

### Experimental algorithmic
- System independent effects (determines constant *a* and exponent *b* in power law)
	+ Algorithm
	+ Input data

- System dependent effects (contribute only to constant *a* in power law)
	+ Hardware: CPU, memory, cache
	+ Software compiler, interpreter, garbage collector
	+ System: OS, network, other applications

### Mathematical Models
- Analyze individual operations to determine complexity

- Simplification 1
  Count only the most expensive ones, i.e. those that take the most time or where time x frequency is highest.

- Simplification 2
  Ignore lower order terms, e.g. in 5xN<sup>3</sup> + 20N + 16, ignore the term with N
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

- Note: lgN means log<sub>2</sub>N
	
<p align="center">	
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Comparison_computational_complexity.svg/800px-Comparison_computational_complexity.svg.png" alt="graph_order_growth" width="400"/>
</p>

- We say the algorithm "is proportional to" e.g. constant time
-------------------------------------------------------------------------------------------------------------------------------
## Properties
1. Reflexive: p is connected to q  
2. Symmetric: if p is connected to q, then q is connected to p  
3. Transitive: if p is connected to q and q is connected to r, then p is connected to r

## Dynamic connectivity
Applications based on this:
1. Pixels in a digital photo  
2. Computers in network  
3. Friends in a social network  
4. Transistors in a computer chip  
5. Elements in a mathematical set  
6. Variables names in Fortran program  
7. Metallic sites in a composite system  

### Quick find (Eager approach)
- Data structure
+ Integer array `id[]` of size N
+ Interpretation: p and q are connected (iff) if and only if they have the same id
+ Complexity

	| Initialize  | Union | Find |
	| ----------- | ----- |------|
	| N           | N     |1     |

- Defect
    + Find too expensive (Could be N array accesses)  
    + If you have N union commands over N objects will be O(N<sup>2</sup>) quadratic  

- Note
```diff
+ We can not accept Quadratic in big problems
+ Quadratic algorithms do not scale
```

#### Rough standards (for now)
- 10<sup>9</sup> operations per second
- 10<sup>9</sup> words of main memory
- Touch all words in approximately 1 second

#### E.g Huge problem for quick find
- 10<sup>9</sup> union commands of 10<sup>9</sup> objects
- Quick find takes more than 10<sup>18</sup> operations
- 30+ years of computer time!

### Quick Union
- Set the first element based on the root of the second element
- Complexity
	| Initialize  | Union | Find |
	| ----------- | ----- |------|
	| N           | N'    |1     |

- Defect
    + Tree can get tall
    + Find too expensive (Could be N array accesses)

### Quick Union improvement
1. Weighted Quick union
- Modify the Quick union to avoid tall trees
- Balance by linking root of smaller tree to root of larger tree
- Depth of any node x is at most `lg N`
- Complexity

	| Initialize  | Union | Find |
	| ----------- | ----- |------|
	| N           | lg N'  |lg N   |


2. Quick union with path compression `N+ M lg N`  
3. Weighted Quick union with path compression `N+ M lg*N`  

- Note `WQUPC reduce time from 30 years to 6 seconds`

### Union find Applications
1. Percolation
2. Games (Go, Hex)
3. Dynamic connectivity
4. Last common ancestor
5. Hoshen-kopelman algorithm in physics

### Percolation
A model for many physical systems
- N-by-N grid of sites
- Each site is open probability p (or blocked with probability 1-p)
- System percolates iff top and bottom are connected by open sites
- Applications in real life

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
- `LIFO` (last in first out), useful in many applications
- Operations: push(Item item), pop(), size(), isEmpty()
- There are two implementation of stack using `Linkedlist` and `Array`
- Stack removes the item most recently added
- What are the Differences between LinkedList and Array implementation?
    + Linkedlist: Use extra space for dealing with links
    + Array: resize/shrink the array takes some time

- When should I use Linkedlist or Array implementation?
if time is important and don't want to lose any input i.e. dealing with internet packet use `Linkedlist` implementation, But if you take care of `memory` space use `Array` implementation  

- How duplicate/shrinking array?
    + Resize When reach 100% full the array resize(arr.length*2)
    + Shrink when reach one quarter full to the half resize(arr.length/2)

- Stack applications
	+ Parsing in a compiler
	+ Java virtual machine
	+ Undo in word processor
	+ Back button in a web browser
	+ Implementation function calls in a compiler
	+ Arithmetic expression evaluation
	+ Reverse objects
	
-------------------------------------------------------------------------------------------------------------------------------

## Queue
- `FIFO` (first in first out), useful in many applications  
- Operations: enqueue(Item item), dequeue(), size(), isEmpty()
- Queue removes the item lest recently
- There are two implementation of stack using `Linkedlist` and `Array`
- Queue applications
	+ Cpu scheduling
	+ Disk scheduling
	+ Data transfer asynchronously between two processes.Queue is used for synchronization.
	+ Breadth First search in a Graph
	+ Call Center phone systems
	
-------------------------------------------------------------------------------------------------------------------------------

## Elementary sorts
- Rearrange array of N times into ascending/descending order based on a key
	1. Selection sort
	2. Insertion sort
	3. Shell sort
	4. Heap sort
	5. Quick sort

- Implementation in java there are `Comparable` and `Comparator` interfaces we will them any of them in the implementation of the sort algorithms 
to allow sort any generic data types  
- There are three return values: 1, 0, -1 and throw Exception if incompatible types or null
	+ V less than W (return -1)  
	+ V equal to W (return 0)  
	+ V greater than W (return 1)  

- Total order
	1. `Antisymmetric`: if v<=w and w<=v, then v=w
	2. `Transitivity`: if v<=w and w<=x, then v<=x
	3. `Totality`: either v<=w or w<=v or both

-------------------------------------------------------------------------------------------------------------------------------

### Selection sort
- Scan from left to right  
- Find the index of `min` of smallest remaining entry, then swap `a[i]` and `a[min]`  `-->` `Time Complexity O(N<sup>2</sup>)` and doesn't sensitive if the input is sorted  

`Algorithm`

```java
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
- Scan from left to right  
- Swap `a[i]` with each larger entry to its left `<--` `Time Complexity O(N<sup>2</sup>)` and has good performance over `partially sorted arrays`  
- Fast when the array is partially sorted `O(N)`
- Array called partially sorted when number of elements to be changed less than or equal cN

`Algorithm`

```java
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
- Move entries more than one position at a time by `h-sorting` the array  What's the `h value` Knuth says `3x+1`  
- Complexity N<sup>3/2</sup>

`Algorithm`

```java
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

- Why Shell sort uses insertion sort internally?  
	1. Fast unless array size is huge
	2. Tiny used in some embedded systems
	3. Hardware sort prototype

-------------------------------------------------------------------------------------------------------------------------------

## Shuffle sort  
- Generate a random real number for each array entry  
- Sort array  

### Knuth shuffle  
- Pick integer r between 0 and i uniformly at random  
- Swap `a[i]` and `a[r]`
- Complexity: `O(n)`

`Algorithm`

```java
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
1. Convex hull of a set of N points is the smallest perimeter fence enclosing the points  
2. TODO // complete this part

-------------------------------------------------------------------------------------------------------------------------------

## Merge sort
- This sort based on the technique of `divide-and-conquer`
- Java sort for objects
- Steps:  
    + Divide array into two halves  
    + Recursively sort each half  
    + Merge two halves
    
- Complexity `N lg N`

`Algorithm`

```java
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
- Mergesort improvement
    + Stop if array is already sorted: !less(arr[mid+1], arr[mid])
    + Cutoff to insertion sort = 7
    + Eliminate-the-copy-to-the-auxiliary-array trick
- First draft of a Report on the EDVAC by John von Neuman
- Compare Running time between Insertionsort and Mergesort
    + Laptop executes 10<sup>8</sup> compares/second
    + Supercomputer executes 10<sup>12</sup> compares/second
    + In this below table will compare between normal computer in first row and supercomputer in second row

        Insertionsort N<sup>2</sup>
        | Million | Billion |
        |---------|---------|
        | 2.8 hours | 317 years |
        | 1 second | 1 week |

        Mergesort N lg N
        | Million | Billion |
        |---------|---------|
        |1 second | 18 min |
        |instant | instant |

- Note:`Good algorithm are better than supercomputers`

### Bottom-up version of Mergesort
- Basic plan  
	1. Pass through array, merging subarrays of size 1
	2. Repeat for subarrays of size 2, 4, 8, 16, ...
	3. Slower than Recursive by 10%

`Algorithm`

```java
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
- Suppose you want to sort `BY_NAME` then `BY_SECTION`
- You should sort and keep the equal elements that they came as input, don't change equal elements position
- Which sorts are stable?
	+ Insertionsort
	+ Mergesort

- Why Selectionsort and Shellsort not stable?  
	+ Selectionsort keeps keep pointer from past and might move an item some equal item
    + Shellsort makes long distance exchanges

-------------------------------------------------------------------------------------------------------------------------------

## Quick sort
- One of the most important algorithm in 20<sup>th</sup> century
- Java sort for primitive types
- Basic plan
	1. Shuffle the array
	2. Partition
	3. Sort
- Complexity `N lg N`
- Faster than Mergesort
- In place algorithm
- Not stable
- Worst case in quicksort will not gonna happen
- Problems in quick sort

`Algorithm`

```java
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
1. Sort a list of names
2. Organize an MP3 library
3. Display Google PageRank results
4. List Rss feed in reverse chronological order

, Problems became easy once items are in sorted order 
1. Find the median
2. Binary search in a database
3. Identify statistical outliers
4. Find duplicates in a mailing list

, Non-obvious applications
1. Data compression
2. Computer graphics
3. Computational biology
4. Load balancing on a parallel computers

## System sorts
- Java uses:
1. Tuned quicksort for primitive types
2. Mergesort for objects

- Which algorithm to use?
    + Applications have diverse attributes
    + Stable?
    + Parallel?
    + Deterministic?
    + Key all distinct?
    + Multiple key types?
    + Linked list or arrays?
    + Large or small items?
    + Is your array randomly ordered?
    + Need guaranteed performance?

-------------------------------------------------------------------------------------------------------------------------------

## Priority Queues
- Remove the largest or smallest item
- Operations: insert(Item item), delMax(), isEmpty(), max(), size()
- Applications
    1. Event-driven simulation: [customers in a line, colliding particles]
    2. Numerical computation: [reducing roundoff error]
    3. Data compression: [Huffman codes]
    4. Graph searching: [Dijkstra's algorithm, Prim's algorithms]
    5. Number theory: [sum of powers]
    6. Artificial intelligence: [A* search]
    7. Statistics: [maintain largest M values in a sequence]
    8. Operating systems: [load balancing, interrupt handling]
    9. Discrete optimization: [bin packing, scheduling]
    10. Spam filtering: [Bayesian spam filters]

- Implementation: you can make multiple implementation using unordered and ordered array, and Binary heap
- Complexity of unordered and ordered array

|Implementation|Insert|Del max|Max|
|--------------|------|-------|---|
|unordered array|1|N|N|
|ordered array|N|1|1|
|goal|log N|log N|log N|

### Binary heap
- Binary tree
- Complexity: `lg N`
- Complete tree, perfectly balanced, except for bottom level
- Height of complete tree with N nodes is `lgN`, why?
    Height only increase when N is a power of 2
- A complete binary tree in nature
<p align="center">	
	<img src="https://i.pinimg.com/originals/98/f8/73/98f873ccf1dc936a19f1ef9defd62cab.jpg" alt="graph_order_growth" width="400"/>
</p>

- Heap ordered binary tree
    + Keys in nodes
    + Parent's key no smaller than children's keys

- Array representation:
    + Parent of node at k is at `k/2`
    + Children of node at k are at `2k` and right `2k+1`

- Best practice use immutable keys
- Underflow and overflow
    + Underflow: throw exception if deleting from empty PQ
    + Overflow: add no-arg constructor and use resize array

`Algorithm`

```java
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
- Basic plan
    + Create max heap with all N keys
    + Repeatedly remove the maximum keys

- In place sorting algorithm with `N lg N` worst-case
- Bottom line: heapsort is optimal for both time and space, but: 
    + Inner loop longer than quicksort's
    + Make poor usage of cache memory
    + Not stable
- Not stable

-------------------------------------------------------------------------------------------------------------------------------

### Event driven simulation
- Application based on priority queue
- Simulate the motion of N moving particles that behave according to the laws of elastic collision
- Hard disc model
    + Moving particles interact via elastic collisions with each other and walls
    + Each particle is a disc with know position, velocity, mass and radius
    + No other forces


-------------------------------------------------------------------------------------------------------------------------------

## Symbol tables
- Key-value pair
- Insert a value with specified key
- Give a key, search for the corresponding value
- i.e DNS lookup
    + insert URL with specified IP address
    + Give URL, find corresponding IP address
- Applications
    1. Dictionary
    2. Book index
    3. File share
    4. Compiler
    5. Routing table
    6. DNS
    7. Genomics
    8. File system
    9. Web search

- Operations: put(Key key, Value val), get(Key key), delete(Key key), contains(Key key), isEmpty(), size(), keys()
- Conventions:
    + Values are not null
    + Method get() returns null if values not present
    + Method put() overwrites old values with new values

- Best practices: Use immutable types for symbol data types
    + Immutable in java: String, Integer, Double, java.io.File, ...
    + Mutable in java:: StringBuilder, java.net.URL, Arrays, ...

- ST Implementations
    + Linked list
    + Binary search in an order array
    + BST Binary search tress

### Binary search tree
- BST is a binary tree in symmetric order
- A binary tree is either
    + Empty
    + Two disjoint binary tress(left and right)
- Symmetric order each node has a key, and every node's key is:
    + Larger than all keys in its left subtree
    + Smaller than all keys in its right subtree

- Representation in java using linked list has key, value and reference to left and right
    ```java
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
- How to find min/max in BST?
    + For min move to the left from the root until find null key
    + For max move to the right from the root until find null key

### 2-3 Trees
- Allow 1 or 2 keys per node
    + 2-node: one key, two children
    + 3-node: two keys, three children
- Perfect balance: every path from the root to null link has same length
- Implementation: Red-black BSTs

### Red-black BSTs
- Represent 2-3 tree as a BST
- Use "internal" left-learning links as "glue" for 3-nodes
- A BST such that:
    + No node has two red links connected to it
    + Every path from root to the null link has the same number of black links
    + Red links lean left


-------------------------------------------------------------------------------------------------------------------------------

## Hash tables
- Basic plan:
    + Save items in a key-indexed table (index is a function of the key)
    + Hash function:method for computing array index from key
- Issues:
    + Computing the has function
    + Equality test: Method for checking whether two keys are equal
    + Collision resolution: Algorithm and data structure to handle two keys that hash to the same array index

- Classic space-time tradeoff
    + No space limitation: trivial hash function with key as index
    + No time limitation: trivial collision resolution with sequential search
    + Space and time limitations: hashing (the real world)

### Hash functions
- Efficiently computable
- Each table index equally likely for each key
- Ex 1. Phone numbers:
    + Bad: first three digits
    + Better: last three digits
- Ex 2. Social security numbers:
    + Bad: first three digits
    + Better: last three digits
- Practical challenge, need different approach for each key type
- Java's hash code conventions
    + All java classes inherit a method hashCode(), with return 32-bit in
    + Requirement, if x.equals(y), then (x.hashCode() == y.hashCode())
    + Highly desirable: if !x.equals(y), then (x.hashCode() != y.hashCode())

```
      X
      |
    -----
    `    `
    `````
      |
    x.hashCode()
```

- hash code design
    + Combine each significant field using the `31x+y`
    + If field is a primitive type, use wrapper type hashCode()
    + If field is null, return 0
    + If field is a reference type, use hashCode()
    + If field is an array, apply to each entry
- Basic rule, need to use the whole key to compute hash code, consult an expert for state-of-the-art hash codes

### Separate chaining (Collision resolution)
- Collision, Two distinct keys hashing to the same index
- Basic idea
    + Use an array of M < N linked list
    + Hash: map key to integer i between 0 and M-1
    + Insert: put at front of i<sub>th</sub> chain
    + Search need to search only i<sub>th</sub> chain

- Consequence, Number of probes for search/insert is proportional to N/M
    + M too large ==> too many empty chains
    + M too small ==> chains too long 
    + Typical choice M ~ N/5 ==> constant time ops

### Linear probing
- Open addressing, When a new key collides, find the next empty slot and put it there
- Hash. Map key to integer i between 0 and M-1
- Insert. Put at table index i if free, if not try i+1, i+2, etc
- Search. Search table index i, if occupied but no match, try i+1, i+2, etc
- Note, Array size M must be greater than number of key-value pairs M
- Clustering: a contiguous block of items

### Separate chaining vs. Linear probing
- Separate chaining
    + Easier to implement delete
    + Performance degrades gracefully
    + Clustering less sensitive to poorly-designed hash function

- Linear probing
    + Less wasted space
    + Better cache performance

### Applications
- Security One way hash function: MD4, MD5, SHA-0, SHA-1, SHA-2, WHIRLPOOL, RIPEMD-160, ...
    + Digital fingerprint
    + Message digest
    + Storing passwords
- Dictionary lookup
    + DNS lookup
    + Amino acids
    + Class list

### Hash tables vs. balanced search trees
- Hash tables
    + Simpler to code
    + No effective alternative for unordered keys
    + Faster for simple keys (a few arithmetic ops versus log N compares)
    + Better system support in Java for strings (e.g. cached hash code)

- Balanced search trees
    + Stronger performance guarantee
    + Support for ordered ST operations
    + Easier to implement compareTo() correctly than equals() and hashCode()

- Java system includes both:
    + Red-black BSTs: java.util.TreeMap, java.util.TreeSet
    + Hash tables: java.util.HashMap, java.util.IdentityHashMap

### ST Complexity

|ST implementation|Worst-case search| Worst-case insert|Ordered iteration|key interface|
|-----------------|-----------------|------------------|-----------------|-------------|
|linked list|N|N|no|equals()|
|binary search (ordered array)|log N|N|yes|compareTo()|
|BST|N|N|stay tuned|compareTo()|
|2-3 tree|c lg N|c lg N|yes|compareTo()|
|red-black tree|2 lg N|2 lg N|yes|compareTo()|
|separate chaining|lg N<sub>*</sub>|lg N<sub>*</sub>|no|equals()|
|linear probing|lg N<sub>*</sub>|lg N<sub>*</sub>|no|equals()|




















[Open-Source-img]: https://badges.frapsoft.com/os/v1/open-source.svg?v=103
[alg-img]: https://img.shields.io/static/v1?label=Topic&message=Algorithms&color=orange&style=flat
[datastructure-img]: https://img.shields.io/static/v1?label=Topic&message=Datastructure&color=blue&style=flat
