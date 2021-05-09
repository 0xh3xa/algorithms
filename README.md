# Algorithms and Data Structures

[![Algorithms][alg-img]][rep-url] [![Data Structures][datastr-img]][rep-url] [![Open Source Love][open-source-img]][rep-url]

Algorithms and data structures' implementations in Java from the `Algorithms 4th edition` :book:

# What is this course?

* Intermediate level survey course
* Programming and problem solving with applications

# Definitions

* `Algorithms`: Method for solving a problem
* `Data structures`: Method to store information
* `Program = Algorithms + Data structures`

# Topics

* `Part I`

01. Data types: stack, queue, bag, union find, priority queue  
02. Sorting: quicksort, mergesort, heapsort, radix sorts  
03. Searching: BST, red-black BST, hash table  

* `Part II`

04. Graphs: BFS, DFS, Prime, Kruskal, Dijkstra  
05. Strings: KMP, regular expression, TST, Huffman, LZW  
06. Advanced: B-tee, suffix array, maxflow  

---

# Why Algorithms is so important?

Algorithms all around us  

01. Internet: web search, packet routing, distribute file sharing, ... 
02. Biology: human genome project, protein folding, ... 
03. Computers: circuit layout, file system, compilers, ... 
04. Computer graphics: Movies, video games, virtual reality, ... 
05. Security: cell phones, e-commerce, voting machines, ... 
06. Multimedia: MP3, JPG, Divx, HDTV, face recognition, ... 
07. Social networks: recommendations, news feeds, advertisements, ... 
08. Physics: N-body simulation, particle collision simulation, ... 

# Steps for solving the problem

01. Model the problem  
02. Find an algorithm to solve it  
03. Fast enough? Fits in memory?  
04. If not, figure out why  
05. Find a way to address the problem  
06. Iterate until satisfied  

---

# Algorithm Analyze

## Reasons to Analyze Algorithms

* Predict performance
* Compare algorithms
* Provide guarantees
* Understand theoretical basis

## The scientific method

* Observe some feature in the natural world
* Hypothesize a model that is consistent with the observations
* Predict events using the hypothesis
* Verify the predictions by making further observations
* Validate by repeating until the hypothesis and observations agree

## Principles

* Experiments must be reproducible. 
* Hypotheses must be falsifiable. 

## Empirical Analysis

* Manual measurement (benchmarking) with a stopwatch or programmatic timing method. 
* Measure running time for different input sizes *N* (e. g. doubling time) and observe the relationship between the running times. 

## Data Analysis

* Plot running time T(N) vs input size *N*. 
* Plot as log-log plot, often get a straight line. lg(T(N)) vs lg(N). Plot tells you the exponent of *N*. 
* Regression, power law: *a x N<sup>b</sup>*
* Once you have the power b from the slope of the log-log plot, solve for *a* in the equation *T(N) = a x N<sup>b</sup>*

## Doubling Hypothesis

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

## Experimental algorithmic

* System independent effects (determines constant *a* and exponent *b* in power law)

  + Algorithm
  + Input data

* System dependent effects (contribute only to constant *a* in power law)

  + Hardware: CPU, memory, cache
  + Software compiler, interpreter, garbage collector
  + System: OS, network, other applications

## Mathematical Models

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

 ## Order-of-Growth Classifications

 - A great number of algorithms (most) are described by the following order of growth functions
 	+ 1 (constant)
 	+ log N (logarithmic)
 	+ N (linear)
 	+ N log N (linearithmic)
 	+ N<sup>2</sup> (quadratic)
 	+ N<sup>3</sup> (cubic)
 	+ 2<sup>N</sup> (exponential)

> Note: lgN means log<sub>2</sub>N

<p align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Comparison_computational_complexity.svg/800px-Comparison_computational_complexity.svg.png" alt="graph_order_growth" width="400"/></p>

* We say the algorithm "is proportional to" e. g. constant time

---

# Properties

01. Reflexive: p is connected to q  
02. Symmetric: if p is connected to q, then q is connected to p  
03. Transitive: if p is connected to q and q is connected to r, then p is connected to r

# Dynamic connectivity

Applications based on this:

01. Pixels in a digital photo  
02. Computers in network  
03. Friends in a social network  
04. Transistors in a computer chip  
05. Elements in a mathematical set  
06. Variables names in Fortran program  
07. Metallic sites in a composite system  

## Quick find (Eager approach)

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

* Note: We can not accept Quadratic in big problems Quadratic algorithms do not scale

### Rough standards (for now)

* 10<sup>9</sup> operations per second
* 10<sup>9</sup> words of main memory
* Touch all words in approximately 1 second

### E. g Huge problem for quick find

* 10<sup>9</sup> union commands of 10<sup>9</sup> objects
* Quick find takes more than 10<sup>18</sup> operations
* 30+ years of computer time!

## Quick Union

* Set the first element based on the root of the second element
* Complexity

| Initialize | Union | Find |
|------------|-------|------|
| N          | N'    | 1    |

* Defect

    - Tree can get tall
    - Find too expensive (Could be N array accesses)

## Quick Union improvement

01. Weighted Quick union
* Modify the Quick union to avoid tall trees
* Balance by linking root of smaller tree to root of larger tree
* Depth of any node x is at most `lg N`

* Complexity

| Initialize | Union | Find |
|------------|-------|------|
| N          | lg N' | lg N |

02. Quick union with path compression `N + M lg N`

03. Weighted Quick union with path compression `N + M lg * N`

> Note: WQUPC reduce time from 30 years to 6 seconds

## Union find Applications

01. Percolation
02. Games (Go, Hex)
03. Dynamic connectivity
04. Last common ancestor
05. Hoshen-kopelman algorithm in physics

## Percolation

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

---

# Data structures Design

* Good practice to make an abstraction between the outside world and internal implementation, In java we will use interface

    - Benefits
        + Client can't know details of implementation

        + Implementation can't know details of client needs

        + Design: creates modular, reusable libraries

        + Performance: use optimized implementation where it matters

* Client: program using operations defined in interface

* Implementation: actual code implementing operations

* Interface: description of data type, basic operations

## Stack

* `LIFO` (last in first out), useful in many applications
* Operations: `push(Item item), pop(), size(), isEmpty()`

* There are two implementation of stack using `Linkedlist` and `Array`

* Stack removes the item most recently added
* What are the Differences between LinkedList and Array implementation?

    - Linkedlist: Use extra space for dealing with links
    - Array: resize/shrink the array takes some time

* When should I use Linkedlist or Array implementation?

    - if time is important and don't want to lose any input i. e. dealing with internet packet use `Linkedlist` implementation, But if you take care of `memory` space use `Array` implementation  

* How duplicate/shrinking array?

    - `Duplicate` When reach 100% full the array resize`(arr.length * 2)`
    - `Shrink` when reach one quarter full to the half `resize(arr.length / 2)`

* Stack applications

    - Parsing in a compiler
    - Java virtual machine
    - Undo in word processor
    - Back button in a web browser
    - Implementation function calls in a compiler
    - Arithmetic expression evaluation
    - Reverse objects

* `LinkedList` implementation code

``` java
public class LinkedStack<Item> implements Stack<Item> {

    private class NodeList {
        Item item;
        NodeList next;

        public NodeList(Item item) {
            this.item = item;
        }
    }

    private NodeList first = null;
    private int size = 0;

    public void push(Item item) {
        if (first == null) {
            first = new NodeList(item);
            first.next = null;
        } else {
            NodeList oldFirst = first;
            first = new NodeList(item);
            first.next = oldFirst;
        }
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }
}
```

---

## Queue

* `FIFO` (first in first out), useful in many applications  
* Operations: `enqueue(Item item), dequeue(), size(), isEmpty()`

* Queue removes the item lest recently
* There are two implementation of stack using `Linkedlist` and `Array`

* Queue applications

    - CPU scheduling
    - Disk scheduling
    - Data transfer asynchronously between two processes. Queue is used for synchronization. 
    - Breadth First search in a Graph
    - Call Center phone systems

* `LinkedList` implementation code

``` java
public class LinkedQueue<Item> implements Queue<Item> {

    private class NodeList {
        Item item;
        NodeList next;

        public NodeList(Item item) {
            this.item = item;
        }
    }

    private NodeList first;
    private NodeList last;
    private int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(Item item) {
        NodeList oldLast = last;
        last = new NodeList(item);
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }
}
```

---

# Elementary sorts

* Rearrange array of N times into ascending/descending order based on a key

    - Selection sort
    - Insertion sort
    - Shell sort
    - Heap sort
    - Quick sort

* Implementation in java there are `Comparable` and `Comparator` interfaces we will them any of them in the implementation of the sort algorithms 

to allow sort any generic data types  

* There are three return values: 1, 0, -1 and throw Exception if incompatible types or null

  + V less than W (return -1)  
  + V equal to W (return 0)  
  + V greater than W (return 1)  

* Total order

  + `Antisymmetric` : if v<=w and w<=v, then v=w
  + `Transitivity` : if v<=w and w<=x, then v<=x
  + `Totality` : either v<=w or w<=v or both

## Selection sort

* Scan from left to right  
* Find the index of `min` of smallest remaining entry, then swap `a[i]` and `a[min]`  `-&#8594;`  `Time Complexity O(N<sup>2</sup>)` and doesn't sensitive if the input is sorted  

 `Code`

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

## Insertion sort

* Scan from left to right  
* Swap `a[i]` with each larger entry to its left &#8592;  `Time Complexity O(N<sup>2</sup>)` and has good performance over `partially sorted arrays`

* Fast when the array is partially sorted `O(N)`

* Array called partially sorted when number of elements to be changed less than or equal cN

 `Code`

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

## Shell sort

* Move entries more than one position at a time by `h-sorting` the array  What's the `h value` Knuth says `3x+1`

* Complexity N<sup>3/2</sup>

 `Code`

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

## Shuffle sort  

* Generate a random real number for each array entry  
* Sort array
* Knuth shuffle  

    - Pick integer r between 0 and i uniformly at random  
    - Swap `a[i]` and `a[r]`
    - Complexity: `O(N)`

 `Code`

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

## Applications in sorting

* Convex hull of a set of N points

    - Is the smallest perimeter fence enclosing the points
    - Equivalent definitions:
        01. Smallest convex set containing all the points
        02. Smallest area convex polygon enclosing the points
        03. Convex polygon enclosing the points, whose vertices are points in set

    - Convex hull output. Sequence of vertices in counterclockwise order
    - Mechanical algorithm. Hammer nails perpendicular to plane, search elastic rubber band around points
    - Convex hull application
        01. Robot motion planning. Find shortest path in the plan from s to t that avoids a polygonal obstacle
            + Fact. Shortest path is either straight line from s to t or it is one of two polygonai chains of convex hull

        02. Farthest pair problem. Given N points in the plane, find a pair, find a pair of points with the largest Euclidean distance between them
            + Fact. Farthest pair of points are extreme points on convex hull
    - Convex hull: geometric properties
        + Fact. Can traverse the convex hull by making only counterclockwise turns
        + Fact. The vertices of convex hull appear in interesting order of polar angle with respect to point p with lowest y-coordinate
    - Graham scan, based on above facts |
        + Choose point p with smallest y-coordinate
        + Sort points by polar angle with p
        + Consider points in order, discard unless if create a ccw turn
        + Q. How to find point p with smallest y-coordinate?

            A. Define a total order, comparing by y-coordinate

        + Q. How to sort points by polar angle with respect to p?

            A. Define a total order for each point p

        + Q. How to determine where p1  &#8594; p2 &#8594; p3 is counterclockwise turn?

            A. Computational geometry

        + Q. How to sort efficiently?

            A. Merge sort in `N lg N`

    - Implement CCW
        + CCW. Given three points a, b and c, is a&#8594;b&#8594;c a counterclockwise turn?

            A. Determinant (or cross product) gives 2x signed area of planer triangle

                01. if signed area > 0, then a&#8594;b&#8594;c is counterclockwise
                02. if signed area < 0, then a&#8594;b&#8594;c is clockwise
                03. if signed area = 0, then a&#8594;b&#8594;c are colliner

        + Running time `N lg N` for sorting and linear for rest

## Merge sort

* This sort based on the technique of `divide-and-conquer`

* Java sort for objects
* Steps:  

    - Divide array into two halves  
    - Recursively sort each half  
    - Merge two halves

* Complexity `N lg N`

 `Code`

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

        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k];
        
        int i = lo, j = mid + 1;
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

Mergesort `N lg N`

| Million  | Billion |
|----------|---------|
| 1 second | 18 min  |
| instant  | instant |

> Note: Good algorithm are better than supercomputers

### Bottom-up version of Mergesort

* Basic plan  

	01. Pass through array, merging subarrays of size 1
	02. Repeat for subarrays of size 2, 4, 8, 16, ... 
	03. Slower than Recursive by 10%

 `Code`

``` java
    public static <Item extends Comparable<Item>> void sortBottomUp(Item[] arr) {
        int N = arr.length; 
        Item[] aux = (Item[]) new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo <= N - sz; lo += sz + sz)
                merge(arr, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1)); 
    }
```

## Sort Stability

* Suppose you want to sort `BY_NAME` then `BY_SECTION`

* You should sort and keep the equal elements that they came as input, don't change equal elements position
* Which sorts are stable?

  + Insertionsort
  + Mergesort

* Why Selectionsort and Shellsort not stable?  

  + Selectionsort keeps keep pointer from past and might move an item some equal item

    - Shellsort makes long distance exchanges

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

 `Code`

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

* Improvement
    01. Insertion sort for small subarrays
        - Cut OFF ~ 10 items
    02. Median of sample
        - Best choice of pivot item = median
        - Median-of-3 random items

## Selection

* Goal. Given an array of N items, find the k<sup>th</sup> largest

    - Min(k=0), max(k=N-1), median(k=N/2)

* Applications

    - Order statistics
    - Find the top k

* Use theory as a guide
    - Easy `N lg N` upper bound. How? By sorting the array and loop util reach k<sup>th</sup>
    - Easy `N` upper bound for k = 1,2,3. How?
    - Easy `N` lower bound. Why?

* Which is true?
    - `N lg N` lower bound? &#8592; Is selection as hard as sorting?
    - `N` upper bound? &#8592; Is there a linear algorithm for each k?

* Quick-select
    - Version of Quick-sort
    - Entry a[j] is in
    - No larger entry to the left of j
    - No smaller entry to the right of j
    - Repeat in one sub-array, depending on j; finished when j equals k

    - Analysis: Linear time on average

    > Remark. Quick-select uses ~ 1/2N<sup>2</sup> compares in the worst case, but (as with quicksort) the random shuffle provides a probabilistic guarantee

    - Algorithm

``` java
    public static <Item extends Comparable<Item>> Comparable<Item> select(Item[] arr, int k) {
        KnuthShuffleSort.shuffle(arr);
        int lo = 0, hi = arr.length - 1;
        while (hi > lo) {
            int j = partition(arr, lo, hi);
            if (j < k)
                lo = j + 1;
            else if (j > k)
                hi = j - 1;
            else
                return arr[k];
        }
        return arr[k];
    }
```

> Remark. But, constants are too high => not used in practice

* Use theory as a guide

    - Still in worthwhile to seek practical linear time (worst-case) algorithm
    - Until one is discovered, use quick-select if you don't need a full sort   

## Duplicate keys

* Often, purpose of sort is to bring items with equal keys together
    - Sort population by age
    - Find collinear points
    - Remove duplicates from mailing list
    - Sort job applicants by college attended

* Typical characteristics of such applications
    - Huge array
    - Small number of key values

* Mergesort with duplicate keys. always between 1/2 N lg N and N lg N compares

* Quicksort with duplicate keys.
    - Algorithms goes quadratic unless partition stop on equal keys

    - 1990s C user found this defect in qsort()
    - Mistake. Put all items equals to the partitioning item in one side
        + Consequence. ~1/2N<sup>2</sup> compares when all keys equal

            B A A B A B B B C C C       A A A A A A A A A A `A`

    - Recommended. Stp scan on item equals to the partitioning item
        + Consequence. ~ N lg N compares when all keys equal

            B A A B A B B B C C C       A A A A A `A` A A A A A

    - Desirable. Put all items equal to the partitioning item in place

            A A A `B B B B B` C C C `A A A A A A A A A A A`

* 3-way partitioning
    - Goal. Partition array into 3 parts so that:
        01. Entries between lt and gt equal to partition item v
        02. No larger entries to left of lt
        03. No smaller entries to right of gt
    - Dutch national flag problem. [Edsger Dijkstra]
        + Conventional wisdom until mid 1990s: not worth doing
        + New approach discovered when fixing mistake in C library qsort()
        + Now incorporated into qsort() and Java system sort
    - Steps
        01. Let v be partitioning item a[lo]
        02. Scan i from left to right

            . (a[i] < v): exchange a[lt] with a[i]; increment both it and i
            . (a[i] > v): exchange a[gt] with a[i]; decrement gt
            . (a[i] == v): increment i

 `Code`

``` java
    private static <Item extends Comparable<Item>> void sort(Item[] arr, int lo, int hi) {
        if (hi <= lo)
            return;
        int lt = lo, gt = hi;
        Item v = arr[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0)
                swap(arr, lt++, i++);
            else if (cmp > 0)
                swap(arr, i, gt--);
            else
                i++;
        }
        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }
```

* Proposition. [Sedgewick-Bentley, 1997]
    - Quicksort with 3-way partition is entropy-optimal

* Bottom line. Randomized quicksort with 3-way partitioning reduces running time from linearithmic to linear in broad class of application

## System sorts

* Sort applications

    - obvious applications
        + Sort a list of names
        + Organize an MP3 library
        + Display Google PageRank results
        + List Rss feed in reverse chronological order

    - Problems became easy once items are in sorted order

        + Find the median
        + Binary search in a database
        + Identify statistical outliers
        + Find duplicates in a mailing list

    - Non-obvious applications

        + Data compression
        + Computer graphics
        + Computational biology
        + Load balancing on a parallel computers

* Java System sort

    - Arrays.sort()
    - Has different method for each primitive type
    - Has a method for data types that implement Comparable
    - Has a method that uses a Comparator
    - Uses tuned quicksort for primitive types; tuned mergesort for objects

## System sort: Which algorithm to use?

* Many sorting algorithms to choose from

    - Internal sorts
        + Insertion sort, selection sort, bubblesort, shaker sort
        + Quicksort, mergesort, heapsort, samplesort, shellsort
        + Solitaire sort, red-black sort, splaysort, Yaroslavskiy sort, psort

    - External sorts. Poly-phase mergesort, cascade-merge, oscallating sort

    - String/radix sorts. Distribution, MSD, LSD, 3-way string quicksort

    - Parallel sorts
        + Bitonic sort, Batcher even-odd sort
        + Smooth sort, cube sort, column sort
        + GPUsort

* Applications have diverse attributes

    - Stable?
    - Parallel?
    - Deterministic?
    - Key all distinct?
    - Multiple key types?
    - Linked list or arrays?
    - Large or small items?
    - Is your array randomly ordered?
    - Need guaranteed performance?

* Elementary sort may be method of choice for some combination
    - Cannot cover all combinations of attributes
* Q. Is the system sort good enough?

    A. Usually

---

## Sort complexity

|Name|In-place|Stable|Best  |Average  |Worst|Remarks|
|----|-------|------|------|---------|-----|-------|
|Selectionsort|Yes|No|1/2 N<sup>2</sup>|1/2 N<sup>2</sup>|1/2 N<sup>2</sup>|N exchanges|
|Insertionsort|Yes|Yes|N|l/4N<sup>2</sup>|l/2N<sup>2</sup>|use for small N or partially ordered|
|Shellsort|Yes|No|N log<sub>3</sub>N|?|cN<sup>3/2</sup>|tight code, sub-quadratic|
|Mergesort|No|Yes|½ N lg N|N lg N|N lg N|N lg N guarantee, stable|
|Quicksort|Yes|No|N|N lg N|½ N<sup>2</sup>|N lg N probabilistic guarantee fastest in practice|
|3-ways Quicksort|Yes|No|N<sup>2</sup>/2|2 N ln N|½ N<sup>2</sup>|improves quicksort in presence of duplicate keys|
|Timesort|No|Yes|N|N lg N|N lg N|-|

---

# Priority Queues

* A collection is a data types that store group of items

|data type|key operations|data structures|
|---------|--------------|---------------|
|stack|Push, Pop|linked list, resizing array|
|queue|Enqueue, Dequeue|linked list, resizing array|
|priority queue|Insert, Del-Max/Min|binary heap|
|symbol table|Put, Get, Delete|BST, hash table|
|set|Add, Contains, Delete|BST, hash table|

## Priority Queue (PQ)

* Collections. Insert and delete items. which item to delete?

    - Stack. Remove the item most recently added
    - Queue. Remove the item least recently added
    - Randomized queue. Remove a random item
    - Priority Queue. Remove the `largest` or `smallest` item

* Operations: `insert(Item item), delMax(), isEmpty(), max(), size()`

* Applications

    - Event-driven simulation: [customers in a line, colliding particles]
    - Numerical computation: [reducing roundoff error]
    - Data compression: [Huffman codes]
    - Graph searching: [Dijkstra's algorithm, Prim's algorithms]
    - Number theory: [sum of powers]
    - Artificial intelligence: [A* search]
    - Statistics: [maintain largest M values in a sequence]
    - Operating systems: [load balancing, interrupt handling]
    - Discrete optimization: [bin packing, scheduling]
    - Spam filtering: [Bayesian spam filters]

* Implementation: you can make multiple implementation using unordered and ordered array, and Binary heap
* Complexity of unordered and ordered array

|Implementation|Insert|Del max|Max|
|--------------|------|-------|---|
|unordered array|1|N|N|
|ordered array|N|1|1|
|goal|lg N|lg N|lg N|

---

## Binary heaps

* Binary tree, Empty or node with links to left and right binary trees

* Complete tree, perfectly balanced, except for bottom level

* Complexity: `lg N`

* Height of complete tree with N nodes is `lg N` , why?

    Height only increase when N is a power of 2

* A complete binary tree in nature

<p align="center"><img src="https://i.pinimg.com/originals/98/f8/73/98f873ccf1dc936a19f1ef9defd62cab.jpg" alt="graph_order_growth" width="400"/></p>

* Binary heap representations

    - Binary heap, Array representation of a heap-ordered complete binary tree.

    - Heap-ordered binary tree
        + Keys in nodes
        + Parent's key no smaller than children's keys

    - Array representation
        + Indices start at 1
        + Take nodes in level order
        + No explicit links needed!

* Binary heap properties

    - Parent of node at k is at `k/2`
    - Children of node at k are at `2k` and right `2k+1`

* Best practice use immutable keys
* Underflow and overflow

    - Underflow: throw exception if deleting from empty PQ
    - Overflow: add no-arg constructor and use resize array

* To avoid maxing the operating like `delMax(), delMin()` there are two implementations `MaxPQ` and `MinPQ`
    - The difference in comparing `less()`, `greater()`

* Good practice to use immutable keys, to prevent the client to change the key while processing the PQ

    - Advantages
        + Simplifies debugging
        + Safer in presence of hostile code
        + Simplifies concurrent programming
        + Safe to use as key in priority queue or symbol table

    - Disadvantages
        + Must create new object for each data type value

 `Code`

``` java
    public void insert(Item key) {
        pq[++N] = key;
        swim(N);
    }

    public Item delMax() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        Item max = pq[1];
        swap(1, N); 
        N--; // decrement N here, will be used in sink
        sink(1);
        pq[N + 1] = null; // prevent loitering, object no longer needed
        return max;
    }

    public Item max() {
        return pq[1];
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) { // k less than parent, swap
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j)) // K less than children then break
                break;
            swap(k, j);
            k = j;
        }
    }
```

---

## Heapsort

* Basic plan

    - Create max heap with all N keys
    - Repeatedly remove the maximum key

* Steps
    - First pass
        + Build heap using bottom-up method
        + arrange from max parent to min child

``` java
for (int k = N/2; k >= 1; k--) sink(arr, k, N);
```

        + we will loop from N/2 to 1 because in sink operation

    - Second pass
        + Remove the maximum, one at a time
        + Leave in array, instead of nulling out
        + replace from min to max in the array

``` java
while (N > 1) {
    swap(arr, 1, N--);
    sink(arr, 1, N);
}
```

* In place sorting algorithm with `N lg N` worst-case

* Proposition. Heap construction uses <= 2 N compares and exchanges

* Proposition. Heapsort uses <= 2 N lg N compares and exchanges

* Significance. In-place sorting algorithm with N lg N worst-case

    

    - Mergesort: no, linear extra space
    - Quicksort: no, quadratic time in worst-case
    - Heapsort: yes

* Bottom line: heapsort is optimal for both time and space, but: 

    - Inner loop longer than quicksort's
    - Make poor usage of cache memory
    - Not stable

 `Code`

``` java
    public final static <Item extends Comparable<Item>> void sort(Item[] pq) {
        int n = pq.length;

        // heapify phase
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        // sortdown phase
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
            if (!less(pq, k, j)) // K greater or equal than children then break
                break;
            swap(pq, k, j);
            k = j;
        }
    }
```

* Sorting algorithms complexity till heapsort

|Name|In-place|Stable|Best  |Average  |Worst|Remarks|
|----|-------|------|------|---------|-----|-------|
|Selectionsort|Yes|No|1/2 N<sup>2</sup>|1/2 N<sup>2</sup>|1/2 N<sup>2</sup>|N exchanges|
|Insertionsort|Yes|Yes|N|l/4N<sup>2</sup>|l/2N<sup>2</sup>|use for small N or partially ordered|
|Shellsort|Yes|No|N log<sub>3</sub>N|?|cN<sup>3/2</sup>|tight code, sub-quadratic|
|Mergesort|No|Yes|½ N lg N|N lg N|N lg N|N lg N guarantee, stable|
|Quicksort|Yes|No|N|N lg N|½ N<sup>2</sup>|N lg N probabilistic guarantee fastest in practice|
|3-ways Quicksort|Yes|No|N<sup>2</sup>/2|2 N ln N|½ N<sup>2</sup>|improves quicksort in presence of duplicate keys|
|Timesort|No|Yes|N|N lg N|N lg N|-|
|Heapsort|Yes|No|N|2 N lg N|2 N lg N|N lg N|N lg N guarantee, in-place|
|???|Yes|Yes|N lg N|N lg N|N lg N|holy sorting grail|

---

## Event driven simulation

* Goal. Simulate the motion of N moving particles that behave according to the laws of elastic collision

* Idea goes back to Einstein 

* Application based on priority queue, without PQ you can not do it with large number of particles because would required quadratic time and not affordable

* Hard disc model

    - Moving particles interact via elastic collisions with each other and walls
    - Each particle is a disc with know position, velocity, mass and radius
    - No other forces

* Significance. Relates macroscopic observables to microscopic dynamics
    - Maxwell-Boltzmann: distribution of speeds as function of temperature
    - Einstein: explain Brownian motion of pollen grains

* Time-driven simulation
    - Update the position of each particle every after dt units of time, and check for overlaps
    - If overlap, roll back the clock to the time of the collision, update the velocities of the colliding particles, and continue the simulation
    - Main drawbacks
        + ~ N<sup>2</sup>/2 overlap checks per time quantum
        + Simulation is too slow if dt is very small
        + May miss collisions if dt is too large

* Event-driven simulation
    - Between collisions, particle move in straight-line trajectories
    - Change sate only when something happens
    - Focus on times when collision occur
    - Maintain PQ of collision events, prioritized by time
    - Remove the min = get next collision

    - Collision prediction. Given position, velocity, and radius of a particle, when will it collide next a wall or another particle?

    - Collision resolution. if collision occurs, update colliding particle(s) according to law of elastic collisions

    - Steps
        + Initialization
            01. Fill PQ with all potential particle-wall collisions
            02. Fill PQ with all potential particle-particle collisions

---

# Symbol tables

## API

* Key-value pair abstraction

    - Insert a value with specified key
    - Give a key, search for the corresponding value

* Ex. DNS lookup

    - Insert URL with specified IP address
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

* Operations: 

``` 

put(Key key, Value val)
get(Key key)
delete(Key key)
contains(Key key)
isEmpty()
size()
keys()
```

* Conventions:

    - Values are not null
    - Method get() returns null if key not present
    - Method put() overwrites old values with new value

* Key type: several natural assumption

    - Assume keys are Comparable, use compareTo()
    - Assume keys are any generic type, use equals() to test equality
    - Assume keys are any generic type, use equals() to test equality, use hashCode() to scramble key

* Best practices: Use immutable types for symbol data keys

    - Immutable in Java: String, Integer, Double, java.io. File, ... 
    - Mutable in Java:: StringBuilder, java.net. URL, Arrays, ... 

* Equality test

    - All Java classes inherit a method equals()
    - Java requirements. For any references x, y and z

        + Reflexive: x.equals(x) is true
        + Symmetric: x.equals(y), iff y.equals(x)
        + Transitive: if x.equals(y) and y.equals(z), then x.equals(z)
        + Non-null: x.equals(null) is false

* Equals design

    - Standard recipe for user-defined type

        + Optimization for reference equality
        + Check again null
        + Check that two objects are of the same type and cast
        + Compare each significant field
            01. if field is a primitive type, use ==
            02. if field is an object, use equals()()
            03. if field is any array, apply to each entry

    - Best practices
        + No need to use calculated fields that depends on other fields
        + Compare fields mostly likely to differ first
        + Make compareTo() consistent with equals() `x.equals(y), if and only if (x.compareTo(y) == 0)`

## Elementary implementations

* Sequential search (unordered list)

    - Data structure: Maintain an (unordered) linked list of key-value pairs
    - Node contains key and value
    - Search: Scan through all keys until find a match
    - Insert: Scan through all keys until find a match, if no match add to front
    - summary

|worst-case search|worst-case insert|average-case search|average-case insert|ordered|key interface|
|-----------------|-----------------|-------------------|-------------------|-------|-------------|
|N|N|N / 2|N|no|equals()|

* Binary search in an order array

    - Data structure: Maintain an ordered array of key-value pairs
    - Rank helper function. how many keys < k?
    - summary

|worst-case search|worst-case insert|average-case search|average-case insert|ordered|key interface|
|-----------------|-----------------|-------------------|-------------------|-------|-------------|
|lg N|N|lg N|N / 2|yes|compareTo()|

* BST Binary search tree

## Ordered operations

``` java
void put(Key key, Value value)
Value get(Key key)
void delete(Key key)
boolean contains(Key key)
boolean isEmpty()
int size()
Key min()
Key max()
Key floor(Key key) // largest key less than or equal to key
Key ceiling(Key key) // smallest key greater than or equal to key
int rank(Key key) // number of key less than key
Key select(int k) // Key of rank k
void deleteMin() // delete smallest key
void deleteMax() // delete largest key
int size(Key lo, Key hi)
Iterable<Key> keys(Key lo, Key hi)
Iterable<Key> keys()
```

## Binary search trees

* Classic data structure provides efficient implementations of ST algorithm

* BST is a binary tree in symmetric order

* A binary tree is either
    - Empty
    - Two disjoint binary tress(left and right)

* Symmetric order each node has a key, and every node's key is:

 

    - Larger than all keys in its left subtree
    - Smaller than all keys in its right subtree

* Representation in java using a Node has key, value and reference to left and right

 `Code`

``` java
    public void put(Key key, Value val) {
        root = put(root, key, val);
        size++;
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;
        return node;
    }

    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.val;
        }
        return null;
    }
```

* Tree shape

    - Many BSTs correspond to same set of keys
    - Number of compares for search/insert is equal to 1 + depth of node
    - Remark. Tree shape depends on order of insertion
    - Worst case will be in natural order

* Mathematical analysis
    - Proposition. If N distinct keys are inserted into a BST in random order, the expected number of compares for a search/insert is ~ 2 ln N
    - Pf. 1-1 correspondence with quicksort partitioning
    - But worst case height is N

|worst-case search|worst-case insert|average-case search|average-case insert|ordered|key interface|
|-----------------|-----------------|-------------------|-------------------|-------|-------------|
|N|N|1.39 lg N|1.39 lg N|stay tunned|compareTo()|

 ## Ordered ST operations

* Minimum and maximum

    - Minimum. Smallest key in table
    - Maximum. Largest key in table
    - Q. How to find min/max in BST?

        + For min move to the left from the root until find null key
        + For max move to the right from the root until find null key

* Floor and ceiling

    

    - Floor. Largest key <= to given key
    - Ceiling. Smallest key >= to given key

* Computing the floor

    - Case 1. [k equals the key at root]
        + The floor of k is k

    

    - Case 2. [k is less than the key at root]
        + The floor of k in the left subtree

    - Case 3. [k is greater than the key at root]
        + The floor of k is in the right subtree 
        + if there is any key <= k in right subtree otherwise it is the key in the root

``` java
public Key floor(Key key) {
    Node node = floor(root, key);
    if (node == null) return null;
    return node.key;
}

private Node floor(Node node, Key key) {
    if (node == null) return null;

    int cmp = key.compareTo(node.key);
    if (cmp == 0) return node;
    if (cmp < 0) return floor(node.left, key);

    Node n = floor(node.right, key);
    if (n != null) return n;
    else return node;
}
```

* Ceiling

``` java
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null)
            return null;
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp < 0) {
            Node n = ceiling(node.left, key);
            if (n != null)
                return n;
            else
                return n;
        }

        return ceiling(node.right, key);
    }
```

* Rank

* Rank. How many keys < k?

    - Easy recursive algorithm (3 cases!)

``` java
public int rank(Key key) {
    return rank(key, root);
}

private int rank(Key key, Node node) {
    if (node == null) return 0;
    int cmp = key.compareTo(node.key);

    if (cmp < 0) return rank(key, node.left);
    else if (cmp > 0) return 1 + size(node.left) + rank(key, node.right);
    else return size(node.left);
}
```

* Inorder traversal

    

    - Traverse left subtree
    - Enqueue key
    - Traverse right substree

``` java
public Iterable<Key> keys() {
    Queue<Key> q = new Queue<>();
    inorder(root, q);
    return q;
}

private void inorder(Node node, Queue<Key> q) {
    if (node == null) return;
    inorder(node.left, q);
    q.enqueue(node.key);
    inoder(node.right, q);
}
```

* Property. inorder traversal of a BST yields keys in ascending order

## Deletion in BST

* To remove a node with a given key

    - Set its value to null
    - Leave key in tree to guide searches (but don't consider it equal in search)
    - Cost ~ 2 ln N<sup>'</sup> per insert, search, and delete (if keys in random order)
    - Unsatisfied solution. Tombstone (memory) overload

* To delete the minimum

    - Go left until finding a node with null left link
    - Replace that node by its right link
    - Update subtree counts

``` java
public void deleteMin() {
    root = deleteMin(root);
}

private Node deleteMin(Node node) {
    if (node.left == null) return node.right;
    node.left = deleteMin(node.left);
    node.count = 1 + size(node.left) + size(node.right);
    return node;
}
```

* Hibbard deletion

    - To delete a node with key k: search for node n containing key k
        + Case 0. Delete n by setting parent link to null
        + Case 1. Delete n by replacing parent link
        + Case 2. [2 children]
            01. Find successor x of n
            02. Delete the minimum in n's right subtree
            03. Put x in n's spot

``` java
    public void delete(Key key) {
        size--;
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }
```

---

## Balanced search tree

### 2-3 search trees

* Allow 1 or 2 keys per node

    - 2-node: one key, two children
    - 3-node: two keys, three children

* Perfect balance: every path from the root to null link has same length
* Implementation: Red-black BSTs

### Red-black BSTs

* Represent 2-3 tree as a BST (binary search tree)
* Left-leaning red-black BSTs (Guibas-Sedgewick 1979 and 2007)
    - Use "internal" left-learning links as "glue" for 3-nodes
    - A BST such that:

        + No node has two red links connected to it
        + Every path from root to the null link has the same number of black links
        + Red links lean left

### B-Tree

* TODO this part

---

## Geometric applications of BSTs

* Intersections among geometric objects
* Applications. CAD, games, movies, virtual reality, database, ...
* Efficient solutions. Binary search trees (and extensions)

### 1 d range search

* Extensions of ordered symbol table
    - Same operations or ordered symbol table
    - Range search: find all keys between k1 and k2
    - Range count: number of keys between k1 and k2

* Application. Database queries
    - i.e salary between val-1 AND val-2

* Geometric interpretation
    - Keys are point of a line
    - Find/count points in a given 1 d interval

* Implementations
    - Unordered array. Fast insert, slow range search
    - Order array. Slow insert, binary search for k1 and k2 to do range search
    - 1 d range count

### line segment intersection

* TODO this part

### kd trees

* TODO this part

### interval search trees

* Instead of points the data is interval
* 1 d interval search. Data structure to hold set of (overlapping) intervals

* Create BST, where each node stores an interval (lo, hi)
    - Use left endpoints as BST key
    - Store max endpoint in subtree rooted at node

* TODO this part

### rectangle intersection

* TODO this part

---

## Hash tables

* Basic plan:

    - Save items in a key-indexed table (index is a function of the key)
    - Hash function: Method for computing array index from key

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

    - Default implementation. Memory address of x

    - Legal (but poor) implementation. Always return 17

    - Customized implementations. Integer, Double, String, File, URL, Date, ...

``` tree
      x
      |
    -----
    |   |   
    -----
      |
  x.hashCode()
```

* Implementing hash code: strings

    - Cache the hash value in an instance variable
    - Return cached value

``` java
public final class String {
    private int hash = 0; // cache of hash code
    private final char[] s;

    public int hashCode() {
        int h = hash;
        if (h != 0) return h; // returned cached value
        for (int i = 0; i < length(); i++) {
            h = s[i] + (31 * h);
        }
        hash = h; // store cache of hash code
        return h;
    }
}
```

* Implementing hash code: user-defined types

``` java
public final class Transaction implements Comparable<Transaction> {
    private final String who;
    private final Date when;
    private final double amount;

    public int hashCode() {
        int hash = 17; // nonzero constant
        // typical a small prime 31
        // get all fields in the class
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + when.hashCode();
        hash = 31 * hash + ((Double) amount).hashCode();
        return hash;
    }
 }
```

* Hash code design

    - Standard recipe for user-defined types

        + Combine each significant field using the `31x+y` rule

        + If field is a primitive type, use wrapper type `hashCode()`

        + If field is null, return 0

        + If field is a reference type, use `hashCode()` &#8592; applies rule recursively

        + If field is an array, apply to each entry &#8592; or use `Arrays.deepHashCode()`

    - In practice. Recipe works reasonably well, used in Java libraries

    - In theory. Keys are bit string: universal hash functions exits

    - Basic rule. Need to use the whole key to compute hash code, consult an expert for state-of-the-art hash codes

* Modular hashing

    - Hash code. An int between -2<sup>31</sup> and 2<sup>31</sup>-1
    - Hash function. An int between 0 and M-1 (for uses as array index)
        + M typically a prime or power of 2

    - Why choose a prime for M?
        + We will use all the bits in the number in that point

There is a problem in below code for detect the negative values 

``` java
// Bug
private int hash(Key key) {
    return key.hashCode() % M;
}
```

There is another problem in below code which is will hit 
-2<sup>31</sup>

``` java
// 1-in-a-billion bug
private int hash(Key key) {
    return Math.abs(key.hashCode()) % M;
}
```

The correct implementation, this is a template for hashCode to get number between 0 and M - 1

``` java
private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
}
```

* Uniform hashing assumption

    - Uniform hashing assumption. Each key is equally likely to hash to an integer between 0 and M - 1

    - Bins and balls. Throw balls uniformly at random into M bins

    - Classically studies in statistics

        + Birthday problem. Expect two balls in the same bin after `~ sqrt(PI M /2)` tosses

        + Coupon collector. Expect every bin hash >= 1 ball after `~ M ln M` tosses

        + Load balancing. After M tosses, expect most loaded bin hash `Omega (log M / Log Log M)` balls

### Separate chaining (Collision resolution)

* Collision, Two distinct keys hashing to the same index

    - Birthday problem &#8594; can't avoid collisions unless you have a ridiculous quadratic amount of memory

    - Coupon collector + load balancing &#8594; collisions will be evenly distributed

    

    - Challenge. Deal with collisions efficiently

* Separate chaining symbol table

    - Use an array of M < N linked lists [H.P. Luhn, IBM 1953]

        + Hash: map key to integer i between 0 and M-1

        + Insert: put at front of i<sub>th</sub> chain (if not already there)

        + Search: need to search only i<sub>th</sub> chain

``` java
public class SeparateChainingHashST<Key, Value> {
    private int M = 97;
    private Node[] st = new Node[M];

    private static class Node {
        private Key key;
        private Value val;
        private Node next;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0xfffffff) % M;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node node = st[i]; node != null; node = node.next) {
            if (key.equals(node.key)) return node.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node node = st[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]); // put the new node at the beginning of the LinkedList
    }
}
```

* Consequence. Number of probes for search/insert is proportional to N/M

    - M too large ==> too many empty chains

    - M too small ==> chains too long 

    

    - Typical choice `M ~ N/5` ==> constant time ops

### Linear probing

* Open addressing. When a new key collides, find the next empty slot and put it there

* Hash. Map key to integer i between 0 and M-1

* Insert. Put at table index i if free, if not try i+1, i+2, etc

* Search. Search table index i, if occupied but no match, try i+1, i+2, etc

> Note: Array size M must be greater than number of key-value pairs N

``` java
public class LinearProbingHashST<Key, Value> {
    private int M = 30001;
    private Value[] vals = (Value[]) new Object[M];
    private Key[] keys = (Key[]) new Object[M];

    private int hash(Key key) {
        return (key.hashCode() & 0xfffffff) % M;
    }

    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) break;
        }
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) %  M) {
            if (key.equals(keys[i])) return vals[i];
        }
        return null;
    }
}
```

* Clustering

    - Cluster. A contiguous block of items

    - Observation. New keys likely to hash into middle of big clusters

* Knuth's parking problem

    - Model. Cars arrive at one-way street with M parking spaces, each desires a random space i: if space i is taken, try i + 1, i + 2, etc

    - Q. What is mean displacement of a car?

        + Half-full. With M / 2 cars, mean displacement is ~ 3 / 2

        + Full. With M cars, mean displacement is ~ sqrt(PI * M / 8)

### ST implementations: summary

|ST implementation|Worst-case search| Worst-case insert|Worst-case delete|Ordered iteration|key interface|
|-----------------|-----------------|------------------|-----------------|-----------------|-------------|
|linked list|N|N|N|no|equals()|
|binary search (ordered array)|log N|N|N|yes|compareTo()|
|BST|N|N|N|stay tuned|compareTo()|
|2-3 tree|c lg N|c lg N|?|yes|compareTo()|
|red-black tree|2 lg N|2 lg N|2 lg N|yes|compareTo()|
|separate chaining|lg N<sub>*</sub>|lg N<sub>*</sub>|lg N<sub>*</sub>|no|equals()|
|linear probing|lg N<sub>*</sub>|lg N<sub>*</sub>|lg N<sub>*</sub>|no|equals()|

> Note: * under uniform hashing assumption

### Context

* War storey: String hashing in Java

    - String hashCode() in Java 1.1

        + For long strings: only examine 8-9 evenly spaced characters

        

        + Benefit: save time in performing arithmetic

        + Downside: great potential for bad collision patterns

``` java
public int hashCode() {
    int hash = 0;
    int skip = Math.max(1, length() / 8);
    for (int i = 0; i < length(); i += skip) {
        hash = st[i] + (37 * hash);
    }
    return hash;
}
```

    - Could end with examine the same spaced character, so you have to examine the all string

* Q. Is the uniform hashing assumption important in practice?

    - A. Obvious situations: aircraft control, nuclear reactor, pacemaker

    - A. Surprising situations. denial-of-service attacks

* Algorithmic complexity attach on Java

    - Goal. Find family of strings with the same hash code

    - Solution. the base 31 hash code is  part of Java's string API

* Diversion: one-way hash functions

    - One-way hash function. "Hard" to find a key that will hash to a desired value (or two keys that hash to the same value)

        + Ex. MD4, MD5, SHA-0, SHA-1, SHA-2, WHIRLPOOL, RIPEMD-160, etc

        + Applications. Digital fingerprint, message digest, storing passwords

        + Caveat. Too expensive for use in ST implementations

* Separate chaining vs. Linear probing

    - Separate chaining

        + Easier to implement delete

        + Performance degrades gracefully

        + Clustering less sensitive to poorly-designed hash function, if you have a bad function

    - Linear probing
        + Less wasted space
        + Better cache performance

    - Q. How to delete?
    - Q. How to resize?

* Hashing: variations on the theme

    - Many improved versions have been studied.

    - Two-probe hashing (separate-chaining variant)

        + Hash to two positions, insert key in shorter of two chains

        + Reduces expected length of the longest chain to log log N

    - Double hashing (linear-probing variant)

        + Use linear probing, but skip a variable amount, not just 1 each time

        + Effectively eliminates clustering

        

        + Can allow table to become nearly full

        + More difficult to implement delete

    

    - Cuckoo hashing (linear-probing variant)
        + Hash key to two positions, insert key either position, if occupied reinsert displaced key into its alternative position (and recur)

        _ Constant worst case time for search

* Applications

    - Security One way hash function: MD4, MD5, SHA-0, SHA-1, SHA-2, WHIRLPOOL, RIPEMD-160, ... 
        + Digital fingerprint
        + Message digest
        + Storing passwords

    - Dictionary lookup
        + DNS lookup
        + Amino acids
        + Class list

* Hash tables vs.balanced search trees

    - Hash tables

        + Simpler to code

        + No effective alternative for unordered keys

        + Faster for simple keys (a few arithmetic ops versus log N compares)

        + Better system support in Java for strings (e.g. cached hash code)

    - Balanced search trees

        + Stronger performance guarantee

        + Support for ordered ST operations

        + Easier to implement `compareTo()` correctly than `equals()` and `hashCode()`

    - Java system includes both:

        + Red-black BSTs: java.util. TreeMap, java.util. TreeSet

        + Hash tables: java.util. HashMap, java.util. IdentityHashMap

### Applications

* Sets

    - Mathematical set: a collection of `distinct` keys
    - Operations:  `add(Key key), contains(Key key), remove(Key key), size(), iterator()`

* Dictionary lookup

    - Command-line arguments
        + A comma-separated value (CVS) file
        + Key field
        + Value field

    

    - Ex 1. DNS lookup
    - Ex 2. Amino acids
    - Ex 3. Class list

* File indexing

    - Goal. Index a PC (or the web), given a list of files specified, create an index so that you can efficiently find all files contains a given query string

    - Book index
        + Goal. preprocess a text corpus to support concordance queries: given a word, find all occurrences with their immediate contexts

* Sparse vectors

    

    - Matrix-vector multiplication

    - Problem. sparse matrix-vector multiplication

    

    - Assumptions. Matrix dimension is 10, 000 average nonzeros per row ~ 10

    - Vector representations

        

        + 1D array (standard) representation

            . Constant time access to elements

            . Space proportional to N
        

        + Symbol table representation

        

            . Key = index, value = entry

            . Efficient iterator

            . Space proportional to number of nonzeros

    - Matrix representations

        

        + 2D array (standard) matrix representation. Each row of matrix is an array

        + Space proportional of N<sup>2</sup>

    - Sparse matrix representation: Each row of matrix is a sparse vector

        

        + Efficient access to elements

        + Space proportional to number of nonzeros (plus N)

``` java
public class SparseVector {
    private HashST<Integer, Double> v;

    public SparseVector() {
        v = new HashST<>(); // empty ST represents all 0s vector
    }

    public void put(int i, double x) {
        v.put(i, x); // put all not zero values
    }

    public double get(int i) {
        if (!v.contains(i)) return 0.0;
        return v.get(i);
    }

    public Iterable<Integer> indices() {
        return v.keys;
    }

    public double dot(double[] that) {
        double sum = 0.0;
        fo (int i : indices()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }
}
```

---

# Graph

## Undirected graphs

* Graph.: Set of vertices connected pairwise by edges

* Why study graph algorithms?

    

    - Thousand of practical applications

    - Hundreds of graph algorithms known

    - Interesting and broadly useful abstraction

    - Challenging branch of computer science and discrete math

* Example of graph

    - Protein-protein interaction network

    - The internet as mapped by the Opte project

    - Map of science click-streams

    - Facebook friends

    - One week of Enron emails

    - Framingham heart study

* Graph terminology

    - Path: Sequence of vertices connected edges

    - Cycle: Path whose first and last vertices are the same

    - Two vertices are `connected` if there is a path between them

* Some graph-processing problems

    - Path. Is there a path between v and w?

    - Shortest path. What is the shortest path between v and w?

    - Cycle. Is there a cycle in the graph?

    - Euler cycle. Is there a cycle that uses each edge exactly once?

    - Hamilton cycle. Is there a cycle that uses each vertex exactly once

    - Connectivity. Is there a way to connect all of the vertices?

    - MST. What is the best way to connect all of the vertices?

    - Bi-connectivity. Is there a vertex whose removal disconnects the graph?

    - Planarity. Can you draw the graph in the plane with no crossing edges

    - Graph isomorphism. Do two adjacency lists represent the same graph?

### Undirected Graph API

* Graph drawing provides intuition about the structure of the graph

* Caveat intuition can be misleading

* Vertex representation

    - Will use integers between 0 and V-1

    - Applications: convert between names and integers which symbol table

    - Implementations

        01. Set-of-edges graph representation

            

            . Maintain a list of the edges (linked list or array)

            . In-efficient implementation make unusable in huge graph
        

        02. Adjacency-matrix graph representation

            

            . Maintain a two-dimensional V-by-V boolean array, for each edge v-w in graph: adj[v][w] = adj[w][v] = true

            . Not very widely used because for a huge graph, you would have billion square number of entries

        03. Adjacency-list graph representation

            . Maintain vertex-indexed array of lists

            . Widely used

* Operations:  `addEdge(int v, int w), adj(int v), V(), E(), toString()`

 `Code`

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

    - Real-world graphs tend to be `sparse` (huge number of vertices small average vertex degree)

| representation   | space         | add edge      | edge between v and w? | iterate over vertices adjacent to v? |
|------------------|---------------|---------------|-----------------------|--------------------------------------|
| list of edges    | E             | 1             | E                     | E                                    |
| adjacency matrix | v<sup>2</sup> | 1<sup>*</sup> | 1                     | v                                    |
| adjacency lists  | E + V         | 1             | degree(v)             | degree(v)                            |

---

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

* Idea: Mimic maze exploration

* Typically applications:

    - Find all vertices connected to a given source vertex
    - Find a path between two vertices

* Design pattern: We decouple Graph representation from graph-processing routine

    - Create a Graph object
    - Pass the Graph to a graph-processing routine
    - Query the graph-processing routine for information

* Depth-first search demo

    - To visit a vertex v:    

        + Mark v as visited
        + Recursively visit all unmarked vertices w adjacent to v

    - Put unvisited vertices on a `stack`

 `Code`

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
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dfs(G, w); 
                    edgeTo[w] = v; 
                }
            }
        }
    }
```

* Proposition. DFS marks all vertices connected to s in time proportional to the `sum of their degrees` from single source

    - PF. [correctness]
        + If w marked, then w connected to s (why?)
        + If w connected to s, then w marked
        + If w unmarked, then consider last edge on a path from s to w that goes from a marked vertex to an unmarked one

    - Pf. [running time]
        + Each vertex connected to s is visited once

* Proposition. After DFS, can find vertices connected to s in constant time and can find a path to s (if not exist) in time proportional to its length

    - Pf. edgeTo[] is parent-link representation of a tree rooted at s

* Challenge. Flood fill (Photoshop magic wand)

    - Assumptions. Pictures has millions to billions of pixels

        + Solution. Build a grid graph
            01. Vertex: pixel
            02. Edge: between two adjacent gray pixels
            03. Blob: all pixels connected to given pixel

---

### Breadth-first search BFS Undirected search

* Explore vertices and it's adjacency then go next vertices for exploration

* Not recursive algorithm, it uses a queue

* Put s into a FIFO queue, and mark s as visited, Repeat until the queue is empty

    - Remove the least recently added vertex v
    - Add each of v's unvisited neighbors to the queue, and mark them as visited

* Proposition. BFS computes the shortest paths (fewest number of edges) from s to all other vertices in a graph in time proportional to `E + V` from single source

    - Pf. [correctness] Queue always consists of zero or more vertices of distance k from s, followed by zero more vertices of distance k + 1

    - Pf. [running time] Each vertex connected to s is visited once

 `Code`

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

* Applications

    - routing: Fewest number of hops in a communication network

### BFS vs. DFS

* Depth-first search. Put unvisited vertices on a `stack`

* Breadth-first search. Put unvisited vertices on a `queue`

* Shortest path. Find from s to w that uses `fewest number of edges`

```tree
       1
     /   \
    /     \
   2       3
  / \     / \
 4   5   6   7
 
```

* Level order, BFS: 1, 2, 3, 4, 5, 6, 7
* Pre-order, DFS: 1, 2, 4, 5, 3, 6, 7

---

### Connected components

* Connectivity queries

    - Def. vertices v and w are connected if there is a path between them
    - Goal. preprocess graph to answer queries of the form is v connected to w? in constant time
    - Operations:  `connected(int v, int w), count(), id(int v)`

* Union-find? not quite
* Depth-first search. Yes

* The relation "is connected to" is an equivalence relation

    - Reflexive: v is connected to v
    - Symmetric: if v is connected to w, then w is connected to v
    - Transitive: if v connected to w and w connected to x, then v connected to x

* Def. A connected component is a maximal set of connected vertices

* Goal. Partition vertices into connected components

* Demo

    - To visit a vertex v:

        + Mark vertex v as visited
        + Recursively visit all unmarked vertices adjacent to v

``` java
public class ConnectedComponent {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponent(Graph graph) {
        marked = new boolean[graph.getVertices()];
        id = new int[graph.getVertices()];
        for (int s = 0; s < graph.getVertices(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count; // all vertices discovered in same call have samd id
        for (int w : graph.adj(v)) {
            if (!marked[w])
                dfs(graph, w);
        }
    }

    /**
     * two vertices are connected if have the same id
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * the id of the vert
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * sum of the connected components in the graph
     */
    public int count() {
        return count;
    }
}
```

* Applications

    - Particle detection

        + Given grayscale image of particles, identity blobs

            01. Vertex: pixel
            02. Edge: between two adjacent pixels with grayscale value >= 70 "black 0, white = 255"
            03. Blob: connected components of 20-30 pixels

        + Particle tracking. Track moving particle over time

### Graph challenges

* Graph-processing challenge 1 

    - Problem. Is a graph bipartite?

        + You can use DFS to solve it

        + Divide the vertices into two subsets with property every edge connects one subset to another

           >0-1
            0-2
            0-5
            0-6

            >1-3
             2-3
             2-4

            >4-5
             4-6

        + Application: is dating graph bipartite? 

    - Problem. Find a cycle

        + You can use DFS to solve it

        + Ex. 0-5-4-6-0

    - Problem. the seven bridges of konigsberg [1736]

        + Euler tour. Is there a (general) cycle that uses each edge exactly once?

            . Answer. A connected grapy is Eulerian iff all vertices have `even` degree

    - Problem. Find a (general) cycle that uses every edge exactly once

        + Eulerian tour (classic graph-processing problem)

    - Problem. Find a (cycle) that visits every vertex exactly once

        + Sometimes called "Travelling sells person between cities and visit each city once"

            . Hamiltonian cycle (classical NP-complete problem)

    - Problem. Are two graphs identically except for vertex names?

        + Graph isomorphism problem longstanding open problem

        + No one knows how to classify the problem

    - Problem. Lay out a graph in the plane without crossing edges?

        + Classic problem in graph processing

        + Linear-time DFS-based planarity algorithm discovered by Tarjan in 1970s

---

## Directed graphs

* Edges now have direction

* Digraph: set of vertices connected pairwise by `directed` edges

* Examples

    -  road network
        + Vertex = intersection
        + Edge = one-way street

    - Political blogosphere graph
        + Vertex = political blog
        + Edge = link

    - Overnight interbank load graph
        + Vertex = bank
        + Edge = overnight loan

    - Implication graph
        + Vertex = variable
        + Edge = logical implication

    - Combinatorial circuit
        + Vertex = logical gate
        + Edge = wire

    - WordNet graph
        + Vertex = synset
        + Edge = hypernym relationship

* Digraph applications

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

### Digraph API

* Operations:  `addEdge(int v, int w), adj(int v), vertices(), edges(), reverse(), toString()`

``` java
public class Digraph {

    private static final String NEW_LINE = System.lineSeparator();

    private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    public Digraph(int v) {
        this.vertices = v;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
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
        edges++;
    }

    /**
     * get number of adjacency to vertex v
     */
    public int degree(int v) {
        return adj[v].size();
    }

    /**
     * get adjacency to vertex v
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Returns the reverse of the digraph
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(vertices);
        for (int v = 0; v < vertices; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int v = 0; v < vertices; v++) {
            builder.append(v + ": ");
            for (int w : adj[v]) {
                builder.append(w + " ");
            }
            builder.append(NEW_LINE);
        }
        return builder.toString();
    }
}
```

* Digraph representations

    - In practice. Use adjacency-list representation

        + Algorithms based on iterating over vertices adjacent to v

        + Real-world graphs tend to be sparse

| representation   | space         | add edge      | edge between v and w? | iterate over vertices adjacent to v? |
|------------------|---------------|---------------|-----------------------|--------------------------------------|
| list of edges    | E             | 1             | E                     | E                                    |
| adjacency matrix | v<sup>2</sup> | 1<sup>+</sup> | 1      | v            |                                      |
| adjacency lists  | E + V           | 1           | outdegree(v)          | outdegree(v)                         |

### Depth-first search in digraphs

* Problem. find all vertices reachable from s along a directed path

* Some method as for undirected graphs

    - Every undirected graph is digraph (with edges in both directions)

    - DFS is a `digraph` algorithm

* Applications:

    01. Reachability application: Program control-flow analysis

        - Every program is a digraph

            + Vertex = basic block of instructions (straight-line program)

            + Edge = jump

        - Dead-code elimination

            + find and remove unreachable code

        - Infinite-loop detected

            + Determine whether exit is unreachable

    02. Mark-sweep garbage collector

        -  Every data structure is a digraph

            + Vertex = object
            + Edge = reference

        - Memory cost. Uses 1 extra mark bit per object (plus DFS stack)

        - Roots. Objects known to be directly accessible by program (e.g. stack)

        - Reachable objects. Objects indirectly accessible by program (starting at a root and following a chain of pointers)

        - Mark-sweep algorithm. [McCarthy, 1960]
            + Mark: mark all reachable objects
            + Sweep: if object is unmarked, it is garbage (so add to free list)

* DFS enables direct solution of simple digraph problems

    01. Reachability
    02. Path finding
    03. Topological sort
    04. Directed cycle direction

* Basis for solving difficult digraph problems

    01. 2-satisfiability
    02. Directed Euler path
    03. Strongly-connected components

### Breadth-first search in digraphs

* BFS is a `digraph` algorithms

* Proposition. BFS computes shortest paths (fewest  number of edges) from s to all other vertices n a digraph in time proportional to `E + V`

* Multiple-source shortest paths

    - Given. a digraph and set of source vertices, find shortest path from any vertex in the set to each other vertex

    - Q. How to implement multi-source constructor?
        + A. Use BFS, but initialize by `enqueuing all source vertices`

* Web crawler

    - Goal. Crawl web, starting from some root web page, say www.princeton.edu

        + Solution. [BFS with implicit digraph]

            . Choose root web page as source s

            . Maintain a Queue of websites to explore

            . Maintain a SET of discovered websites

            . Dequeue the next website and enqueue websites to which it links (provided you haven't done so before)

    - Q. Why not use DFS?

        + A. You gonna far away for searching web, some web page traps new page

 `Code`

``` java
public class BareBonesWebCrawler {

    private Queue<String> queue = new ArrayQueue<>();
    private Set<String> discovered = new HashSet<>();
    private static final String REGEX = "https://(\\w+\\.)*(\\w+)";

    public BareBonesWebCrawler(String root) {
        queue.enqueue(root);
        discovered.add(root);
        bfs();
    }

    private void bfs() {
        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            System.out.println(v);
            String input = readRawHtml(v);
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String w = matcher.group();
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.enqueue(w);
                }
            }
        }
    }

    private String readRawHtml(String url) {
        URL u;
        try {
            u = new URL(url);
            URLConnection conn = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            in.close();
            // System.out.println(buffer.toString());
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        new BareBonesWebCrawler("https://github.com/openjdk");
    }
}
```

### Topological sort

* Goal. Given a set of tasks to completed with precedence constraints in which order should we schedule with the tasks?

* Digraph model

    - Vertex = task

    - Edge = precedence constraint

* DAG
    - `acyclic` Digraph with no cycle

    - If you have cycle there is no way to solve the problem

* Topological sort. Redraw DAG so all edges points upwards

* Solution. DFS

* Demo

    01. run depth-first search
    02. Return vertices in reverse post order

 `Code`

``` java
public class DepthFirstOrder {

    private boolean[] marked;
    private Stack<Integer> reverseOrder;

    public DepthFirstOrder(Digraph graph) {
        reverseOrder = new ArrayStack<>();
        marked = new boolean[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) 
            if (!marked[w]) {
                dfs(graph, w);
        reverseOrder.push(v);
    }

    // return all vertices in reverse DFS post-order
    public Stack<Integer> reversePost() {
        return reverseOrder;
    }
}
```

, Detect cycle in directed graph

``` java
public class DirectedCycleDetector {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle
    private boolean[] onStack; // vertices on recursive call stack

    public DirectedCycleDetector(Digraph graph) {
        onStack = new boolean[graph.getVertices()];
        marked = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v] && cycle == null)
                dfs(graph, v);
        }
    }

    private void dfs(Digraph graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (cycle != null) {
                // short circuit if directed cycle found
                return;
            } else if (!marked[w]) {
                // found new vertex, so recur
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                // trace back directed cycle
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
```

, Will check if no cycle first then get order

``` java
public class TopologicalSort {

    private Stack<Integer> order;

    public TopologicalSort(Digraph graph) {
        DirectedCycleDetector finder = new DirectedCycleDetector(graph);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }

    public Stack<Integer> order() {
        return order;
    }

    public boolean hasOrder() {
        return order != null;
    }

    public boolean isDag() {
        return hasOrder();
    }
}
```

* Used for package management, like maven, brew, etc

* Proposition. Reverse DFS post-order of a DAG is a topological order

    - Pf. [correctness] Consider any edge v &#8594; w. When dfs(v) is called

        + Case 1: dfs(w) has already been called and returned. Thus, w was done before v

        + Case 2: dfs(w) has not yet been called, dfs(w) will get called directly on indirectly by dfs(v) and will finish before dfs(v). Thus, w will be done before v

        + Case 3: dfs(w) has already been called, but has not yet returned. Can't happen in a DAG: function call stack contains path from w to v, so v&#8594;w would complete a cycle

* Directed cycle detection

    - Proposition. A digraph has a topological order iff no directed cycle

        + Pf.

            01. If directed cycle, topological order impossible

            02. If directed cycle, DFS-based algorithm finds a topological order

    - Goal. Given a digraph. find a directed cycle

        + Solution. DFS

    - Applications

        01. Scheduling. Given a set of tasks to be completed with precedence constraints, in what order should we schedule the tasks??

            . Remark. A directed cycle implies scheduling problem is infeasible

        02. Java compiler does cycle detection (cyclic inheritance)

        03. Microsoft Excel does cycle detection (and has a circular reference toolbar!)

 `Code`

``` java
public class DirectedCycleDetector {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle
    private boolean[] onStack; // vertices on recursive call stack

    public DirectedCycleDetector(Digraph graph) {
        onStack = new boolean[graph.getVertices()];
        marked = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v] && cycle == null)
                dfs(graph, v);
        }
    }

    private void dfs(Digraph graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (cycle != null) {
                // short circuit if directed cycle found
                return;
            } else if (!marked[w]) {
                // found new vertex, so recur
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                // trace back directed cycle
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
```

### Strong components

* Def. Vertices v and w are `strongly connected` if there is a directed path from v to w and a directed path from w to v

* Key property. Strong connectivity is an `equivalence relation`

    - v is strongly connected to v
    - If v is strongly connected to w, then w is strongly connected to v
    - If v is strongly connected to w and w connected to x, then v is strongly connected x

* v and w are `connected` if there is a path between v and w

* Applications

    - Food web graph

        + Vertex = species
        + Edge = from producer to consumer
        + Strong component. Subset of species with common energy flow

    - Software modules

        + Vertex = software module
        + Edge = from module to dependency
        + Strong component. Subset of mutually interacting modules
            01. Approach 1. Package strong components together
            02. Approach 2. Use to improve design

* Kosaraju-Sharir algorithm

    - Reverse graph. Strong components in G are same as G<sup>R</sup>

    - Kernel DAG. Contact each strong components into a single vertex

    - Idea
        + Compute topological order (reverse post-order) in kernel DAG
        + Run DFS, considering vertices in reverse topological order

    - Demo

        01. Phase 1. Compute reverse postorder in G<sup>R</sup>
        02. Phase 2. Run DFS in G, visiting unmarked vertices in reverse postorder of G<sup>R</sup>

    - Simple (but mysterious) algorithm for computing strong components

    - Proposition. Kosaraju-Sharir algorithm computes the strong components of a digraph in time proportional to E + V

        + pf.

            01. Running time: bottleneck is running DFS twice (and computing G<sup>R</sup>)
            02. Correctness: tricky
            03. Implementation: easy

 `Code`

``` java
public class KosarajuSharirCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSharirCC(Digraph graph) {
        marked = new boolean[graph.getVertices()];
        id = new int[graph.getVertices()];
        count = 0;
        DepthFirstOrder order = new DepthFirstOrder(graph);
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
```

---

## MST (Minimum spanning trees)

* Given. `Undirected graph` G with positive edge weights (connected)

* Def. A `spanning tree` of G is a `subgraph` T that is both a `tree` (connected and `acyclic`) and `spanning` (includes all of the vertices)

* Goal. Find a min weight spanning tree

* Applications

    - Dithering
    - Cluster analysis
    - Real-time face verification
    - Image registration with Renyi entropy
    - Find road networks in satellite and aerial imagery
    - Network design (communication, electrical, computer, road)
    - Auto config protocol for ether bridging to avoid cycles in a network
    - Reducing data storage in sequencing amino acids in a protein

### Greedy algorithm

* General principle of Algorithm desing

* Simplifying assumptions

    - Edge weights are `distinct`
    - Graph is `connected`

* Based on these MST exists and unique

* Cut property

    - Def. A `cut` in a graph is partition of its vertices into two non-empty set
    - Def. A `crossing edge` connects a vertex in one set with a vertex in the other

    - Cut property. Given any cut, the crossing edge of min weight is the MST

    - Pf. Suppose min-weight crossing edge *e* is not in the MST        

        + Adding e to the MST creates a cycle
        + Some other edge *f* in cycle must be a crossing edge
        + Removing *f* and adding *e* is also a spanning tree
        + Since weight of *e* is less than the weight of *f* that spanning tree is lower weight

* Greedy MST algorithm demo

    - Start with all edges colored gray
    - Find cut with no black crossing edges, color its min-weight edge black
    - Repeat until V-1 edges are colored black

* Proposition. The greedy algorithm computes the MST

    - Pf. [correctness]

        + Any edge colored black is in the MST (via cut property)
        + Fewer than *V-1* black edges &#8594; cut with no black crossing edges (consider cut whose vertices are one connected component)

* Efficient implementations. Choose cut? find min-weight edge?
    01. Kruskal's algorithm [stay tuned]
    02. Prim's algorithm [stay tuned]
    03. Boruvka's algorithm

* Q. What if edge weights are not all distinct?
    - A. Greedy MST algorithm still correct if equal weights are present!

* Q. What iff graph is not connected?
    - A. Compute m,minimum spanning forest = MST of each components

### Edge-weight graph API

* Edge abstraction needed for weighted edges

* Idiom for processing an edge e: `int v = e.either(), w = e.other(v); `

``` java
public class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * Either endpoint
     */
    public int either() {
        return v;
    }

    /**
     * Other endpoint
     */
    public int other(int vertex) {
        if (vertex == v)
            return w;
        else
            return v;
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight < that.weight)
            return -1;
        else if (this.weight > that.weight)
            return 1;
        return 0;
    }
}
```

* Graph API which has weighted edges, we will use `EdgeWeightedGraph`

``` java
public class EdgeWeightedGraph {

    private final int vertices;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.vertices = v;
        adj = (Bag<Edge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public void addEdge(Edge edge) {
        int v = edge.either(), w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
```

* Edge-weighted graph: adjacency-list representation

    - Maintain vertex-indexed array of Edge lists

* Minimum spanning tree API

    - Q. How to represent the MST?

``` java
public class MST {
    MST(EdgeWeightedGraph G)
    Iterable<Edge> edges() // edges in MST
    double weight() // weight of MST
}
```

### Kruskal's algorithm

* classical algorithm for computing MST
*  Steps:

    - Consider edges in ascending order of weight
    - Add next edge to tree T unless doing so would create a cycle
    - Ignore edge that create a cycle

* Proposition. [Kruskal 1956] Kruskal's algorithm computes the MST

    - Pf. Kruskal's algorithm is a special case of the greedy MST algorithm

        + Suppose Kruskal's algorithm colors the edge *e=v-w* black

        + Cut = set of vertices connected to *v* in tree *T*

        + No crossing edge is black

        + No crossing edge has lower weight, why?

* Challenge. Would adding edge *v-w* to tree *T* create a cycle? if not, add it

    - *V* run DFS from v, check if w is reachable (T has at most V-1 edges)

    - <i>log<sup>*</sup>V</i> use union-find data structure

    - Efficient solution. Use the `Union-find` data structure

        . Maintain a set for each connected component in T

        . If v and w are in same set, then add v-w would create a cycle

        . To add v-w to T, merge sets containing v and w

 `Code`

``` java
public class KruskalMST {

    private double weight;
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph graph) {
        MinPQ<Edge> pq = new MinPQ<>(graph.getVertices());
        mst = new ArrayQueue<>();
        for (Edge e : graph.edges())
            pq.insert(e);

        UnionFind unionFind = new WeightedQuickUnionPassCompression(graph.getVertices());

        while (!pq.isEmpty() && mst.size() < graph.getVertices() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (!unionFind.isConnected(v, w)) {
                unionFind.union(v, w);
                mst.enqueue(e);
                weight += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return this.weight;
    }
}
```

* Proposition. Kruskal's algorithm computes MST in time proportional to *E log E* (in the worst case)

### Prim's algorithm

* Classical algorithm for computing MST

* Steps:

    - Start with vertex 0 and greedily grow tree T
    - Add to T the min weight edge with exactly one endpoint in T
    - Repeat until V-1 edges

* Proposition. Prim's algorithm computes the MST

    - Pf. Prime's algorithm is a special case of the greedy MST algorithm

        

        + Suppose edge *e* = min weight edge connecting a vertex on the tree to a vertex not on the tree

        + Cut = set of vertices connected on tree

        + No crossing edge is black

        + No crossing edge has lower weight

* Challenge. Find the min weight edge with exactly one endpoint in *T*

    - *E* &#8592; try all edges
    - *lg E* &#8592; Priority Queue

### Prim's algorithm: lazy implementation

    

* Challenge. Find the min weight edge with exactly one endpoint in *T*

    - Lazy solution. Maintain a PQ of `edges` with (at least) one endpoint in T

        + Key = edge, priority = weight of edge

        + Delete-min to determine next edge *e = v-w* to add to *T*

        + Disregard if both endpoints v and w are in *T*

            . add to PQ any edge incident to w (assuming other endpoint not in *T*)

            . add *w* to *T*

* Prim's algorithm (lazy) demo

    - Start with vertex 0 and greedily grow tree *T*

    - Add to *T* the min weight edge with exactly one endpoint *T*

    - Repeat until *V-1* edges

 `Code`

``` java
public class LazyPrimMST {

    private double weight;
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph) {
        pq = new MinPQ<>(graph.getVertices());
        mst = new ArrayQueue<>();
        marked = new boolean[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) { // run Prim from all vertices to
            if (!marked[v])
                prim(graph, v); // get a minimum spanning forest
        }
    }

    private void prim(EdgeWeightedGraph graph, int s) {
        scan(graph, s);

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w])
                continue;
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v])
                scan(graph, v); // v become part of tree
            if (!marked[w])
                scan(graph, w); // w become part of tree
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been
    // scanned
    private void scan(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge e : graph.adj(v))
            if (!marked[e.other(v)])
                pq.insert(e);
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return this.weight;
    }
}
```

* Proposition. Lazy Prim's algorithm computes the MST in time proportional to *E log E*

and extra space proportional to *E* (in the worst case)

    - Pf. 

    |operation|frequency|binary heap|
    |---------|---------|-----------|
    |delete min| E | lg E |
    |insert| E | lg E |

### Prim's algorithm: eager implementation

* Challenge. Find the min weight edge with exactly one endpoint in *T*

* Eager solution. Maintain a PQ of vertices connected by an edge to *T*, where priority of vertex *v* = weight of shortest edge connected *v* to T

    - Delete min vertex *v* and add its associated edge *e = v-w* to *T*

    - Update PQ by considering all edges *e=v-x* incident to v

        + ignore if x is already in T

        + add x to PQ if not already on it

        + `decrease priority` of x if v-x becomes shortest edge connecting x to T

* Prim's algorithm (eager) demo

    - Start with vertex 0 and greedily grow tree *

    - Add to T the min weight edge with exactly one endpoint in T

    - Repeat until *V-1* edges

* Indexed priority queue

    - Associate an index between 0 and N-1 with each key in a priority queue

        + Client can insert and delete-the-minimum

        + Client can change the key by specify the index

    - Implementation

        + Start with same code as MinPQ

        + Maintain parallel arrays keys[], pq[], and qp[] so that:

            01. keys[i] is the priority of i
            02. pq[i] is the index of the key in heap position i
            03. pq[i] is the index of the key in heap position i
            04. qp[i] is the heap position of the key with index i

        + Use swim(qp[k]) implementation

``` java
public class IndexMinPQ<Key extends Comparable<Key>> {
    IndexMinPQ(int N)

    void insert(int i, Key key)
    
    void decreaseKey(int i, Key key)

    boolean contains(int i)

    int delMin()

    boolean isEmpty()

    int size()
}
```

* Prims' (eager) algorithm: running time

    - Depends on PQ implementation: v insert, v delete-min, E decrease key

|PQ implementation|Insert|delete-min|decrease-key|total|
|-----------------|------|----------|------------|-----|
|array|1|V|1|V<sup>2</sup>|
|binary heap|log V| log V|log V|E log V|
|d-way heap|log<sub>d</sub>V|d log<sub>d</sub>V|log<sub>d</sub>V|E log<sub>1/v</sub>V|
|Fibonacci heap|1<sup>+</sup>|log V<sup>*</sup>|1<sup>+</sup>|E + V log V|

> Note: <sup>+</sup> amortized

### MST context

* Euclidean MST

    - Given *N* points in the plane, find MST connecting them, where the distances between point paris are their `Euclidean` distances

* Scientific application: clustering

    - K-clustering. Divide a set of objects classify into K coherent groups

    - Distance function. Numeric value specifying "closeness" of two objects

    - Goal. Divide into clusters so that objects in different clusters are far apart

* Applications

    - Routing in mobile ad hoc networks
    - Document categorization for web search
    - Similarity searching in medical image databases
    - Sky-cat: cluster 10<sup>9</sup> objects into stars, quasars, galaxies

---

## Shortest path

* Given an edge weighted digraph, find the shortest path from *s* to *t*

* Applications:

    - Map routing
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

* Similar to Edge for undirected graphs, but a bit simpler

 `Code`

``` java
public class DirectedEdge {

    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }
}
```

### Edge-weighted digraph API

* Same as EdgeWeightedGraph except replace Graph with Digraph

 `Code`

``` java
public class EdgeWeightedDigraph {

    private final int vertices;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int vertices) {
        this.vertices = vertices;
        adj = (Bag<DirectedEdge>[]) new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
}
```

### Single-source shortest paths API

* Goal. Find the shortest path from s to every other vertex

 `API`

``` java
public class SP {
    SP(EdgeWeightedDigraph graph, int s)

    double distTo(int v)
    
    Iterable<DirectedEdge> pathTo(int v)
    
    boolean hasPathTo(int v)
}
```

### Shortest paths properties

* Goal. Find the shortest path from s to every other vertex

* Observation. A shortest-paths tree (SPT) solution exists, why?

* Consequence. Can represent the SPT with two vertices-indexed arrays:

    - distTo[v] is length of shortest path from s to v
    - edgeTo[v] is last edge on shortest path from s to v

 `Code`

``` java
public double distTo(int v) {
    return distTo[v];
}

public Iterable<DirectedEdge> pathTo(int v) {
    Stack<DirectedEdge> path = new Stack<>();
    for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
        path.push(e);
    }
    return path;
}
```

* Edge relaxation

    - Relax edge *e = v &#8594; w*

        + distTo[v] is length of shortest `known` path from s to v
        + distTo[v] is length of shortest `known` path from s to w
        + edgeTo[w] is last edge on shortest `known` path from s to w
        + If e = v&#8594;w gives shorter path to w through v, update both distTo[w] and edgeTo[w]

 `Code`

``` java
private void relax(DirectedEdge e) {
    int v = e.from(), w = e.to();
    if (distTo[w] > distTo[v] + e.weight() {
        distTo[w] = distTo[v] + e.weight();
        edgeTo[w] = e;
        if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
        else pq.insert(w, distTo[w]);
    }
}
```

* Shortest-paths optimality conditions

    - Proposition. Let *G* be an edge-weighted digraph then distTo[] are the shortest path distances from s iff
        + distTo[s] = 0
        + For each vertex v, distTo[v] is the length of some path from s to v
        + For each edge = e = v&#8594;w, distTo[w] <= distTo[v] + e.weight()

        + Pf. [necessary]

            . Suppose that distTo[w] > distTo[v] + e.weight() for some edge e = v&#8594;w

            . Then, e gives a path from s to w (through v) of length less than distTo[w]
        

* Generic shortest-paths algorithm

    - Initialize distTo[s] = 0 and distTo[v] = &infin; for all other vertices

    - Repeat until optimality donstions are satisfied
        + Relax any edge

* Efficient implementations. How to choose which edge to relax?

    - Dijkstra's algorithm (non-negative weights)
    - Topological sort algorithm (no directed cycles)
    - Bellman-Ford algorithm (no negative cycles)

### Dijkstra's algorithm

* Dijkstra's algorithm demo

    - Consider vertices in increasing order of distance from s (non-tree vertex with the lowest distTo[] value)

    - Add vertex to tree and relax all edges pointing from that vertex

 `Code`

``` java
public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph graph, int s) {
        edgeTo = new DirectedEdge[graph.getVertices()];
        distTo = new double[graph.getVertices()];
        pq = new IndexMinPQ<>(graph.getVertices());

        for (int v = 0; v < graph.getVertices(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : graph.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight(){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }
}
```

* Proposition. Dijkstra's algorithm computes a SPT in any edge-weighted digraph with nonnegative weights

    - Pf. 
        + Each edge e = v&#8594; w is relaxed exactly once (when v is relaxed) leaving distTo[w] <= distTo[v] + e.weight()

        +  Inequality holds until algorithm terminates because

            . distTo[w] cannot increase

            . distTo[v] will not change

* Computing spanning trees in graphs

    - Dijkstra's algorithm seems familiar?

        + Prim's algorithm is essentially the `same` algorithm

        + Both are in a family of algorithms that computes a graph's `spanning tree`

    - Main distinction. Rule uses to choose next vertex for the tree

        + Prim's: Closest vertex to the tree (via an undirected edge)

        + Dijkstra's: Closest vertex to the source (via a directed path)

> Note: DFS and BFS are also in this family of algorithms

* Dijkstra's algorithm: which priority queue?

    - Bottom line

        + Array implementation optimal for dense graphs

        + Binary heap much faster for sparse graphs

        + 4-way heap worth the trouble in performance critical situations

        + Fibonacci heap best in theory, but not worth implementing

|PQ implementation|Insert|delete-min|decrease-key|total|
|-----------------|------|----------|------------|-----|
|array|1|V|1|V<sup>2</sup>|
|binary heap|log V| log V|log V|E log V|
|d-way heap|log<sub>d</sub>V|d log<sub>d</sub>V|log<sub>d</sub>V|E log<sub>1/v</sub>V|
|Fibonacci heap|1<sup>+</sup>|log V<sup>*</sup>|1<sup>+</sup>|E + V log V|

### Edge-weighted DAGs

* Q. Suppose that an edge digraph has no directed cycles is it easier to find shortest paths than in general digraph?

    - A. Yes

* Acyclic shortest paths demo

    - Consider vertices in topological order
    - Relax all edges pointing from that vertex

* Proposition. Topological sort algorithm computes SPT in any edge weighted DAG in time proportional to *E + V*

    - Pf.
        + Each edge e = v&#8594;w relaxed exactly once (when v is relaxed)

        + Inequality holds until algorithm terminates because

            . distTo[w] cannot increase

            . distTo[v] will not change

        + Thus, upon termination, shortest-paths optimality conditions hold

 `Code`

``` java
public class AcyclicSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph graph, int s) {
        edgeTo = new DirectedEdge[graph.getVertices()];
        distTo = new double[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;

        TopologicalSort topological = new TopologicalSort(graph);
        for (int v : topological.order()) {
            for (DirectedEdge e : graph.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<DirectedEdge> path = new ArrayStack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
```

* Applications

    - Content-aware resizing

        + Seam carving. Resizing an image without distortion for display on cell phones and web browsers

        + Photoshop, GIMP, etc

    - To find vertical seam:

        + Grid DAG: vertex = pixel, edge = from pixel to 3 downward neighbors

        + Weight of pixel = energy function of 8 neighboring pixels

        + Seam = shortest path (sum of vertex weights) from top to bottom

    - To remove vertical seam:

        + Delete pixels on seam (one in each row)

* Longest paths in edge-weighted DAGs

    - Formulate as a shortest paths problem in edge-weighted DAGs

        [equivalent: reverse senes of equality in relax()]

        + Negate all weights
        + Find shortest paths
        + Negate weights in result

    - Parallel job scheduling. Given a set of jobs with durations and precedence constraints, schedule the jobs (by finding a start time for each) so as to achieve the minimum completion time, while respecting the constraints

        + Critical path method (CPM)

### Negative weights

* Dijkstra. Doesn't work with negative edge weights

* Negative cycles

    - Def. A negative cycle is a directed cycle whose sum of edge weights is negative

* Bellman-Ford algorithm

    - Initialize distTo[s] = 0 and distTo[v] = &infin; for all other vertices

    - Repeat V times:
        + Relax each edge

    - Proposition. Dynamic programming algorithm computes SPT in any edge weighted digraph with no negative cycles in time proportional to *E x V*

        + Pf idea. After passing *i*, found shortest path containing at most *i* edges

    - Improvement

        + Observation. If distTo[v] does not change during pass i, no need to relax any edge pointing from v in pass i+1

        + FIFO implementation. Maintain queue of vertices whose distTo[] changed

        + Overall effect

            . The running time is still proportional to *E x V* in worst case

            . But much faster than in practice

### Single source shortest-path implementation: cost summary

|algorithm|restriction|typical case|worst case|extra space|
|---------|-----------|------------|----------|-----------|
|topological sort|no directed cycles|E + V|E + V|V|
|Dijkstra (binary heap)| no negative weights|E log V|E log V|V|
|Bellman-ford|no negative cycles| E V | E V | V
|Bellman-ford (queue-based) |no negative cycles| E + V | E V | V

* Remark 1. Directed cycles make the problem harder

* Remark 2. Negative weights make the problem harder

* Remark 3. Negative cycles make the problem intractable

### Finding a negative cycle

* Negative cycle. Add two method to the API for SP

``` java
boolean hasNegativeCycle()

Iterable<DirectedEdge> negativeCycle()
```

* Observation. If there is a negative cycle, Bellman-Forest gets stuck in loop, un-updating distTo[] and edgeTo[] entries of vertices in the cycle

* Proposition. If any vertex v is updated in phase V, there exist a negative cycle (and can trace back edgeTo[v] entries to find it)

    - In practice. Check for negative cycles more frequently

* Applications

    - Arbitrage detection

        + Problem. Given table of exchange rates, is there an arbitrage opportunity?

    - Ex. $1.000 &#8594; 741 Euros &#8594; 1,012.206 Canadian dollars &#8594; $1,007.14497

    - Currency exchange graph

        + Vertex = currency
        + Edge = transaction, with weight equal to exchange rate
        + Find a directed cycle whose product of edge weights is > 1

|Currency|USD|EUR|GBP|CHF|CAD|
|--------|---|---|---|---|---|
|USD|1|0.741|0.657|1.061|1.011|
|EUR|1.350|1|0.888|1.433|1.366
|GBP|1.521|1.126|1|1.614|1.538|
|CHF|0.943|0.698|0.620|1|0.953|
|CAD|0.995|0.732|0.650|1.049|1|

### Shortest paths summary

* Dijkstra's algorithm

    - Nearly linear-time when weights are nonnegative
    - Generalization en-compresses DFS, BFS and Prim

* Acyclic edge-weighted digraphs

    - Arise in applications
    - Faster than Dijkstra's algorithm
    - Negative weights are no problem

* Negative weights and negative cycles

    - Arise in applications
    - If no negative cycles, can find shortest paths via Bellman-Ford
    - If negative cycles, can find one via Bellman-Ford

* Shortest-paths is a broadly useful problem-solving model

---

# Maximum flow

* General problem solving model

## Mincut problem

* Input. An edge-weighted digraph, source vertex *s* and target vertex *t*

* Def. A `st-cut (cut)` is a partition of the vertices into two disjoint sets with *s* in one set *A* and *t* in the other set *B*

* Def. its capacity is the sum of the capacities of the edges from *A* to *B*

* Minimum st-cut (mincut) problem. Find a cut of minimum capcity

* Applications

    - Free world goal. Cut supplies (if cold war turns into real war)

    - Government-in-power's goal. Cut off communication of set of people

## Maxflow problem

* Input. An edge-weighted digraph, source vertex *s* and target *t*

* Every edge has a positve capcity

* Def. An st-flow (flow) is an assignment of values to the edges such that:

    - Capacity constraint: 0 <= edge's flow <= edge's capacity

    - Local equilibrium: inflow = outflow at every vertex (except s and t)

* Maximum st-flow (maxflow) problem. Find a flow of maximum value

### Ford-Fulkerson algorithm

* Steps

    - Initialization. Start with 0 flow
    - Augmenting path. Find an undirected path from s to t such that:

        + Can increase flow on forward edges  (not full)

        + Can decrease flow on backward edge (not empty)

    - Termination. All paths from s to t are blocked by either a:

        + Full forward edge
        + Empty backward edge

* Ford-Fulkerson algorithm

``` 
Start with 0 flow
While there exists an augmenting path

    - find an augmenting path
    - compute bottleneck capcity
    - increase flow on that path by bottleneck capacity

```

* Questions

    - How to compute a mincut? Easy
    - How to find an augmenting path? BFS works well
    - If FF terminates, does it always compute a maxflow? Yes
    - Does FF always terminate? If so, after how many augmentations?

### Running time analysis

* TODO this part

### Java code

* TODO this part

---

# Strings

* String. Sequence of characters

* Important fundamentals abstractions

    - Information processing
    - Genomic sequences
    - Communication systems (e.g email)
    - Programming systems (e.g java programs)

* C char data type

    - Typically an 8-bit integer
    - Supports 7-bit ASCII
    - Can represent only 256 characters

* Java char data type

    - Support 16-bit Unicode
    - Support 21-bit Unicode 3.0 (awkwardly)

* String data type

    - String data type in Java. Sequence of characters (immutable)

    - Length. Number of characters

    - Substring extraction. Get a contiguous subsequence of characters

    - String concatenation. Append one character to end of another string

 `Code`

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

    - Memory `40 + 2N` bytes for a virgin String of length of N

    - Remark. StringBuffer data type is similar, but thread safe (and slower)

    - String operations

|operation|guarantee|extra space|
|---------|---------|-----------|
|length()|1|1|
|charAt()|1|1|
|substring()|1|1|
|concat()|N|N|

* StringBuilder data type performance

    - Remark StringBuffer data type is similar, but thread safe (and slower)

    - StringBuilder operations

|operation|guarantee|extra space|
|---------|---------|-----------|
|length()|1|1|
|charAt()|1|1|
|substring()|N|N|
|concat()|1<sup>*</sup>|1<sup>*</sup>|

* String vs. StringBuilder

    - Q. How to efficiently reverse a string?

Quadratic time

``` java
public static String reverse(String s) {
    String rev = "";
    for (int i = s.length() - 1; i >= 0; i--) rev += s.charAt(i);

    return rev;
}
```

Linear time

``` java
public static String reverse(String s) {
    StringBuilder rev = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) rev.append(s.charAt(i));

    return rev.toString();
}
```

> Note: For `concat` string use `StringBuilder` , for `substring` use `String`

* Alphabets

    - Radix. Number of digits *R* in alphabet

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

## Key-indexed counting

* We stopped in sorting algorithm at Heap sort

    - Lower bound ~ N lg N compares required by any compared-based algorithm

    - Q. Can e do better (despite the lower bound)?  

        + A. Yes if e don't depend o key compares

* Frequency of operations = key compares

* Assumption about keys

    - Assumption. Keys are integers between 0 and R-1

    - Implication. Can use key as an array index

    - Applications

        01. Sort string by first letter
        02. Sort class roster by section
        03. Sort phone numbers by area code
        04. Subroutine in a sorting algorithm [stay tuned]

> Remark. keys may have associated data => can't just count up number of keys of each value

* Goal. Sort an array a[] of N integers between 0 and R-1

* Key-indexed counting demo

    - Count frequencies of each letter using key as index

    - Compute frequency cumulates which specify destination

    - Access cumulates using key as index to remove items

    - Copy back into original array

* Performance ~ `11 N + 4 R` and extra space `N + R`

    - R is Radix from table above

 `Code`

``` java
    public final static void sort(char[] a) {
        int N = a.length;
        int R = 256;
        int[] count = new int[R + 1];
        char[] aux = new char[N];

        // count frequencies
        for (int i = 0; i < N; i++)
            count[a[i] + 1]++; // offset by 1

        // compute cumulates
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];

        // move items
        for (int i = 0; i < N; i++)
            aux[count[a[i]]++] = a[i]; 

        // copy back
        for (int i = 0; i < N; i++)
            a[i] = aux[i];
    }
```

## LSD radix sort

* Least significant digit first string sort

    - Consider characters from right to left

    - Stably sort using *d<sup>th</sup>* character as the key (using key-indexed counting)

* Proposition. LSD sorts fixed-length strings in ascending order

    - Pf. [by induction on i]

        + After pass *i*, strings are sorted by last *i* characters

            . If two strings differ on sort key, key-indexed sort puts them in proper relative order

            . If two strings agree on sort key, stability keeps them in proper relative order

 `Code`

``` java
public static void sort(String[] a, int W) { 
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
```

* Problem. Sort one million 32-bit integers

    - Ex. Google interview

    - Which sorting method to use?
        01. Insertion sort
        02. Mergesort
        03. Quicksort
        04. Heapsort
        05. LSD string sort

* Summary of the performance of sorting algorithms

|algorithm|guarantee|random|extra space|stable?|operations on keys|
|---------|---------|------|-----------|-------|------------------|
|insertion sort|N<sup>2</sup>/2|N<sup>2</sup>/4|1|yes|compareTo()|
|mergesort|N lg N|N lg N|N |yes|compareTo()|
|quicksort|1.39 N lg N|1.39 N lg N|c lg N |no|compareTo()|
|heapsort|2 N lg N|2 N lg N|1|no|compareTo()|
|LSD<sup>*</sup>|2 W N |2 W N|N + R|yes|charAt()|

## MSD radix sort

* Most significant digit first string sort

* Steps

    - Partition array into R pieces according to first character (use key-indexed counting)

    - Recursively sort all strings that start ith each character (key-indexed counts delineate subarrays to sort)

* Variable-length strings

    - Treat strings as if they had an extra char at end (smaller than any char)

    - C strings. Have extra char '\0' at end &#8594; no extra work to do

 `Code`

``` java
  public final static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private final static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (hi <= lo)
            return;
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c + 2]++;
        }
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c + 1]++] = a[i];
        }
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

* Performance

    - Observation 1. Much too slow for small subarrays
        + Each function call needs its own count[] array
        + ASCII (256 counts) 100x slower than copy pass for N=2
        + Unicode (65,536 counts): 32.000x slower for N = 2

    - Observation 2. Huge number of small subarrays because of recursion

    - Improvement

        01. Cutoff to insertion sort for small subarrays

    - Number of characters examined

        + MSD examines just enough characters to sort the keys
        + Number of characters examined depends on keys
        + Can be sublinear in input size

* Disadvantages of MSD string sort

    - Access memory "randomly" (cache inefficient)
    - Inner loop has a lot of instructions
    - Extra space for count[]
    - Extra space for aux[]

* Disadvantages of quicksort

    - Linearithmic number of string compares (not linear)
    - Has to re-scan many characters in keys with long prefix matches

* Complexity

|algorithm|guarantee|random|extra space|stable?|operations on keys|
|---------|---------|------|-----------|-------|------------------|
|insertion sort|N<sup>2</sup>/2|N<sup>2</sup>/4|1|yes|compareTo()|
|mergesort|N lg N|N lg N|N |yes|compareTo()|
|quicksort|1.39 N lg N|1.39 N lg N|c lg N |no|compareTo()|
|heapsort|2 N lg N|2 N lg N|1|no|compareTo()|
|LSD<sup>*</sup>|2 W N|2 W N|N + R|yes|charAt()|
|MSD<sup>*</sup>|2 W N|N log<sub>2</sub>N|N + D R|yes|charAt()|

## 3-Way radix quicksort

* Combines benefits of Quicksort and MSD radix

* Overview. Do 3-way partitioning on the d<sup>th</sup> character

    - Less overhead than R-way partition in MSD string sort

    - Does not re-examine characters equal to the partition char (but does re-examine characters not equal to the partition char)

 `Code`

``` java
public final class MSDQuickSort {

    public final static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private final static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo)
            return;
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v)
                swap(a, lt++, i++);
            else if (t > v)
                swap(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt - 1, d);
        if (v >= 0)
            sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }

    private final static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = swamp;
    }
}
```

* Performance

    - Uses ~ 2 N ln N character compares on average for random string

### 3-way string quicksort vs. MSD string sort

* MSD string sort

    - Is cache-inefficient
    - Too much memory sortig count[]
    - Too much overhead reinitialiazing count[] and aux[]

* 3-way string quicksort

    - Has a short inner loop
    - Is cache-friendly
    - Is in-place

* Complexity

|algorithm|guarantee|random|extra space|stable?|operations on keys|
|---------|---------|------|-----------|-------|------------------|
|insertion sort|N<sup>2</sup>/2|N<sup>2</sup>/4|1|yes|compareTo()|
|mergesort|N lg N|N lg N|N |yes|compareTo()|
|quicksort|1.39 N lg N|1.39 N lg N|c lg N |no|compareTo()|
|heapsort|2 N lg N|2 N lg N|1|no|compareTo()|
|LSD<sup>+</sup>|2 W N|2 W N|N + R|yes|charAt()|
|MSD<sup>+</sup>|2 W N|N log<sub>2</sub>N|N + D R|yes|charAt()|
|3-way string quicksort|1.39 W N lg N|1.39 W N lg N|log N + W|no|charAt()|

## Suffix arrays

* Keyword-in-context search

    - Given a text of N characters, preprocess it to enable fast substring search (find all occurrence of query string context)

    - Applications
        + Grep
        + Linguistics
        + Databases
        + Web search
        + Word processing

    - Suffix sort
        + Take the input string and form suffixes
        + Sort suffixes to bring repeated substrings together
        + You can use Binary search

    - Suffix-sort soltion
        + Preprocess: suffix sort the text
        + Query: binary search for query, scan until mismatch

* Longest repeated substring

    - Given a string of *N* characters, find the longest repeated substring

    - Applications

        + Bioinformatics
        + Cryptanalysis
        + Data compression
        + Visualize repetitions in music

    - Brute-force algorithm

        + Try all indices *i* and *j* for start of position match
        + Compute longest common prefix (LCP) for each pair

        + The same solution before: Suffix-sort solution

 `Code`

``` java
public String lrs(String s) {
    int N = s.length();
    String[] suffixes = new String[N];
    for (int i = 0; i < N; i++) suffix[i] = s.substring(i, N);

    Arrays.sort(suffixes);

    String lrs = "";
    for (int i = 0; i < N-1; i++) {
        int len = lcp(suffix[i], suffix[i+1]);
        if (len > lrs.length()) lrs = suffixes[i].substring(0, len);
    }
    return lrs;
}
```

* Sorting challenge

    - Problem. Five scientists A, B, C, D, and E are looking for long repeated substring in a genome with over 1 billion nucleotides

        + A has a grad student do it by hand
        + B uses brute force (check all pairs)
        + C uses suffix sorting solution with insertion sort
        + D uses suffix sorting solution wit mergesort
        + &#10004; E uses suffix sorting solutio with 3-way string quicksort (but only if LRS is not long)

    - Q. Which one is more likely to lead to a cure for cancer?

    - Problem. Suffix sort an arbitrary string of length N

        + Q. What is the worst-case running time of best algorithm for problem?

            . &#10004; Linearithmic (Manber-Myers algorithm)

            . &#10004; Linear (suffix trees)

---

# Search in String

* Data structure for searching in String

* Complexity for previous searching algorithms

|algorithm|search|insert|delete|ordered operations|operations on keys|
|---------|------|------|------|------------------|------------------|
|red-black BST|lg N|lg N|lg N|yes|compareAt()|
|hash table|1<sup>+</sup>|1<sup>+</sup>|1<sup>+</sup>|no|equals() hashCode()|

* Q. Can we do better?  

    - A. yes, if we can avoid examining the entire key, as with string sorting 

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

## R-way Tries

* From re`trie`val, but pronounced "try", to distribute from binary search tree

    - For now store *characters* in nodes (not key)

    - Each node has *R* children, one for each possible character, where *R* is the possible of character

    - Store values in nodes corresponding to last characters in keys

* Search in a trie

    - Follow links corresponding to each character in the key

        + Search hit: node where search ends has a non-null value

        + Search miss: reach null link or node where search ends has null value

* Insertion into a trie

    - Follow links correspoinding to each character in the key

        + Encounter a null link: create new node

        + Encounter the last character of the key: set value in that node

* Delete in an R-way tries

    - Find the node corresponding to key and set value to null

    - If node has null value and all null links, remove that node (and recur)

* Trie performance

    - Search hit. Need to examine all *L* characters for equality

    - Search miss. 

        + Could have mismatch on 

    - first character

        + Typical case examine only a few characters

    - Space. *R* null links at each leaf. (but sub-linear space possible if many short strings share common prefixes)

    - Bottom line. Fast search hit and even faster search miss, but `wastes space`

* Goal. Design a data structure to perform efficient spell checking

    - Solution. Build a 26-way trie (key = word, value = bit), 26 English letters

 `Code`

``` java
public class TriesST<Value> {

    private final static int R = 256;

    private class Node {
        private Object val;
        private Node[] next = (Node[]) new Object[R];
    }

    private Node root;

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

* Challenge. Use less memory, e.g. 65,536-way trie for Unicode!

## Ternary search tries

* Store characters and values in nodes (not keys)

* Each node has 3 children: small(left), equal(middle), larger(right)

* Search in a TST

    - Follow links corresponding to each character in the key

        + If less take left link, if greater take right link
        + If equal take the middle link and move to the next key character

    - Search hit. Node where search ends has a non-nul value

    - Search miss. Reach a null link or node where search node ends has null value

* 26-way trie vs. TST

    - 26-way trie. 26 null links in each leaf

    - TST. 3 null links in each leaf

 `Code`

``` java
public class TernaryST<Value> {

    private class Node {
        Value val;
        char c;
        Node left, mid, right;
    }

    private Node root;

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node node, String key, Value val, int d) {
        char c = key.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c)
            node.left = put(node.left, key, val, d);
        else if (c > node.c)
            node.right = put(node.right, key, val, d);
        else if (d < key.length() - 1)
            node.mid = put(node.mid, key, val, d + 1);
        else
            node.val = val;
        return node;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null)
            return null;
        return node.val;
    }

    private Node get(Node node, String key, int d) {
        if (node == null)
            return null;
        char c = key.charAt(d);
        if (c < node.c)
            return get(node.left, key, d);
        else if (c > node.c)
            return get(node.right, key, d);
        else if (d < key.length() - 1)
            return get(node.mid, key, d + 1);
        else
            return node;
    }
}
```

* Comparison 

|algorithm|search|search miss|insert|space|
|---------|------|-----------|------|-----|
|red-black BST|L + c lg<sup>2</sup> N|c lg<sup>2</sup>N|c lg<sup>2</sup>N|4N|
|hash table (linear probing)|L|L|L|4N to 16N|
|R-way tries|L|log<sub>R</sub>N|L|(R+1)N|
|TST|L + ln N|ln N|L + ln N|4 N|

> Remark. can build balanced TST via rotations to achieve `L + Log N` worst-case guarantees

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

        01. Need to examine entire key
        02. Search hits and misses cost about the same
        03. Performance relies on hash function
        04. Does not support ordered symbol table operations

    - TSTs

        01. works only for strings \(or digital keys\)
        02. Only examines just enough key characters
        03. Search miss may involve only a fe characters
        04. Supports ordered symbol table operations \(plus others\)

* Bottom line. TSTs are:
    - Faster than hashing (especially for search misses)
    - More flexible than red-black BSTs [stay tuned]

## Character based operations

* The string symbol table API supports several useful character-based operations

* Prefix match. keys with prefix "sh": "she", "shells" and "shore"

* wildcard match. keys that match ".he": "she" and "the"

* Longest prefix. key that is the longest prefix of "shellsort": "shells"

* Prefix matches
    - Find all keys in a symbol table starting with a given prefix
    - Ex. Autocomplete in a cell phone, search bar (Google search), text editor or shell

        01. User types characters one at a time
        02. System reports all matching strings

* T9 texting
    - Goal. type text messages on a phone keypad
    - Multi-tap input. Enter a letter by repeatedly pressing a key until the desired
    - T9 text input

        01. Find all words that correspond to given sequence of numbers
        02. Press 0 to see all completion options

* Patricia trie
    - Remove one-way branching
    - Each node represents a sequence of characters

    - Implementation: one step beyond this course

    - Applications

        01. Database search
        02. P2P network search
        03. IP routing table: find longest prefix match
        04. Compressed quad-tree for N-body simulation
        05. Efficiently storing and query XML documents

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

---

# Substring search algorithms

* Goal. find pattern of length *M* in a text of length *N* (typically N>M)

* Applications
    - Find and replace

    

    - computer forensics. Search memory or disk for signatures, e.g. al URLs or RSA keys that the user has entered

    

    - Identify patterns indicative of spam

        01. Profits
        02. Lose weight
        03. herbal viagra
        04. there is no catch
        05. this is a one-time mailing
        06. this message is sent in compliance with spam regulations

    - Screen scraping. Extract relevant data from web page

        01. Ex. find string delimited by <b> and </b> after first occurrence of pattern last trade

## Brute-force substring search

* Check for pattern starting at each text position

* Worst case ~ *M N* char compares

* Brute-force algorithm can be slow if text and pattern are repetitive

 `Code`

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

    - The pattern could be so long

* Backup
    - In  many applications, we want to avoid `backup` in text stream

        01. Treat input as stream of data
        02. Abstract model: standard input

    - Approach 1. Maintain buffer of lat *M* characters

    - Approach 2. Stay tuned

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

## Knuth-Morris-Pratt (KMP)

* Coolest algorithm :)

* This is the algorithm when theoretical meets practices, this discovered by two theoreticians and a hacker

* Intuition. Suppose e are search in text for pattern BAAAAAAAAA

* KMP. Clever method to avoid backup in brute-force substring

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

    - If in state j and next char `c != pat.charAt(j)` , then the last `j-1` characters of input are pat[1..j-1] followed by c

* Proposition. KMP substring search access no more than `M + N` chars to search for a pattern of length M in a text of length N

  

    - Pf. each pattern char accessed once when constructing DFA, each text char accessed once (in the worst case) when simulating of the DFA

* Proposition. KMP constructs dfa[][] in time and space proportional to *R M*

    - Because we have all of those mismatches

 `Code`

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

## Boyer-Moore

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

 `Code`

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

## Rabin-Karp

* Basic idea = modular hashing

    - Computer a hash of pattern characters 0 to M-1
    - For each i, compute a hash of text characters i to M+i-1
    - If pattern hash = text substring hash check for a match

* Efficiently computing the hash function

    - Modular hash function. Using the notation *t<sub>i</sub>* for txt.charAt(i)

        + We wish to compute <i>x<sub>i</sub> = t<sub>i</sub> R<sup>M-1</sup>* + t<sub>i+1</sub> R<sup>M-2</sup>+...+t<sub>i+M-1</sub> R<sup>0</sup> (mod Q)</i>

    - Horner's method. Linear-time method to evaluate degree-M polynomial

 `Code`

``` java
    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }
```

* Complexity `7 N`

* Rabin-Karp search 

    - Advantages

        + Extends to 2d patterns
        + Extends to finding multiple patterns

    - disdvantages

        + Arithmetic ops slower than char compares
        + Las Vegas version require backup
        + Poor worst-case guarantee

 `Code`

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

---

# Regular expression

* Pattern matching

    - Substring search. Find a string iin text

    - Pattern matching. Find one of a specified set of strings in text

    - Ex. [genomics]

        + Fragile X syndrome is a common cause of metntal retardation
        + Human genome contains triplet repeats of CGG or AGG bracketed by GCC at the beginning and CTG at the end

        + Pattern GCG(GGC|AGG)*CTG

* Applicatons

    - Process natural language

    - Scan for virus signature

    - Specify a programming language

    - Access information in digital libraries

    - Search genome using PROSITE patterns

    - Filter text (spam, NetNanny, Carnivore, malware)

    - Validate data-entry fields (dates, email, URL, credit card)

    - Parse text files
        + Compile a Java program
        + Crawl and index the web
        + Read in data stored in ad hoc input file format
        + Create Java docmentation from Javadoc comments

* Regular expressions

    - Is a notation to specify a set of string `possible to infinite`

|operation|order|example RE|matches|does not match|
|---------|-----|----------|-------|--------------|
|concatenation|3|AABAAB|AABAAB|every other string|
|or|4|AA|BAAB|AA BAAB|every other string
|closure|2|AB*A|AA ABBBBBBBA|AB ABABA|
|parentheses|1|(AB)*A|A ABABABABA|AA ABBA|

## NFA

* Duality between REs and DFAs

    - RE. Concise way to describe a set of strings

    - DFA. Machine to recognize whether a given string is in a given set

    - Kleene's theorem

    

        + For any DFA, there exists a RE that describes the same set of strings

        + For any RE, there exists a DFA that recognizes the same set of strings

* Pattern matching implementation: basic plan (first attempt)

    - Overview is the same as for KMP

        + No backup in text input stream

        + Linear-time guarantee

    - Underlying abstraction. Deterministic finite state automata (DFA)

    - Basic plan. [apply Kleen's theorem]

        + Build DFA from RE

        

        + Simulate DFA with text as input

    - Bad news. Basic plan is infeasible (DFA may have exponential # of states)

* Pattern matching implementation: basic plan (revised)

    - Overview is the same as for KMP

        + No backup in text input stream

        + Quadratic-time guarantee (linear-time typical)

    - Underlying abstraction. Nondeterministic finite state automata (NFA)

    - Basic plan. [apply Kleen's theorem]

        + Build NFA from RE

        + Simulate NFA with text as input

* Nondeterministic finite-state automata

    - Regular expression matching NFA

        + RE enclosed in parantheses

        + One state per RE character (start = 0, accept = M)

        + Red e-transition (change state, but don't scan text)

        + Black mtach transition (change state and scan to next text char)

        + Accept if any sequence of transitions ends in accept state

### NFA simulation

* NFA representation

    - State names. Integer from 0 to M 

    - Match-transitions. Keep regular expression in array re[]

    - e-transitions. Store in digraph G

* Q. How to efficiently simulte an NFA?

    - A. Maintain set of all possible states that NFA could be in after reading the first *i* text characters

### NFA constuction

* Sates. Incluse a state for each symbol in the RE, plus an accept state

* Proposition. Building the NFA corresponding to an *M*-character RE takes time and space proportional to M

    - Pf. For each of the *M* characters in the RE, we add at most three e-transitions and execute at most two stack operations

 `Code`

``` java
public class NFA {

    private char[] re;
    private Digraph graph;
    private int M;
    private String regexp;

    public NFA(String regexp) {
        this.regexp = regexp;
        this.M = regexp.length();
        this.graph = buildEpsilonTransitionDigraph();
    }

    private Digraph buildEpsilonTransitionDigraph() {
        Digraph g = new Digraph(M + 1);
        Stack<Integer> ops = new ArrayStack<>();
        for (int i = 0; i < M; i++) {
            int lp = i;
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|')
                ops.push(i);
            else if (regexp.charAt(i) == ')') {
                int or = ops.pop();
                if (regexp.charAt(or) == '|') {
                    lp = ops.pop();
                    g.addEdge(lp, or + 1);
                    g.addEdge(or, i);
                } else
                    lp = or;
            }

            if (i < M - 1 && regexp.charAt(i + 1) == '*') {
                g.addEdge(lp, i + 1);
                g.addEdge(i + 1, lp);
            }
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')')
                g.addEdge(i, i + 1);
        }
        return g;
    }

    public boolean recognize(String txt) {
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(graph, 0);
        for (int v = 0; v < graph.getVertices(); v++) {
            if (dfs.visited(v))
                pc.add(v);
        }

        for (int i = 0; i < txt.length(); i++) {
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v == M)
                    continue;
                if ((re[v] == txt.charAt(i)) || re[v] == '.')
                    match.add(v + 1);
            }

            dfs = new DirectedDFS(graph, match);
            pc = new Bag<>();
            for (int v = 0; v < graph.getVertices(); v++) {
                if (dfs.visited(v))
                    pc.add(v);
            }
        }

        for (int v : pc)
            if (v == M)
                return true;
        return false;
    }
}
```

### Applications

* Grep. Take a RE as a command-line argument and print the lines from standard input having some substring that is matched by the RE

    - Bottom-line. Worst-case for grep (proportional to M N) is the same as for brute-force substring search

    - Typical grep application: Crossword puzzles

 `Code`

``` java
public class Grep {
    public static void main(String[] args) throws FileNotFoundException {
        String regexp = "(.*" + args[1] + ".*)";
        NFA nfa = new NFA(regexp);
        Scanner scanner = new Scanner(new File(args[0]));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (nfa.recognize(line))
                System.out.println(line);
        }
    }
}
```

* To complete the implementation

    - Add wildcard
    - Add multiway or
    - Handle metacharacters
    - Support character classes
    - Add capturing capabilities
    - Extend the closure operator
    - Error checking and recovery
    - Greedy vs. reluctant matching

* Broadly applicables programmer's tool

    - Originated in Unix in the 1970s
    - Many languages support extended regular expression
    - Built into grep, awk, emacs, Perl, PHP, Python, Javascript

### Context

* Abstract machines, languages, and nondeterminism

    - Basis of the theory of computation

    - Intensively studied since the 1930s

    - Basis of programming language

* Compiler. A program that translates a program to machine code

    - KMP string &#8594; DFA

    - grep RE &#8594; NFA

    - javac Java language &#8594; Java byte code

|operation|KMP|grep|Java|
|---------|---|----|----|
|Pattern|string|RE|program|
|compiler output|DFA|NFA|byte code|
|simulator|DFA simulator|NFA-simulator|JVM|
---

# Data compression

## Introduction

* Compression reduces size of a file

    - To save `space` when sorting it
    - To save `time` when transmitting it
    - Most files have lots of redundancy

* Who needs compressions?

    - Moore's law: # transistors on a chip doubles every 18-24 months

    - Parkinsons' law: data expands to fill space available

    - Text, image, sound, video, ....

* Applications

    - Generic file compression

        01. Files: GZIP, BZIP, 7z
        02. Archives: RKZIP
        03. File systems: NTFS, HFS+, ZFS

    - Multimedia

        01. Images: GIF, JPEG
        02. Sound: MP3
        03. Video: MPED, DivX, HDTV

    - Communication

        01. ITU-T T4 Group 3 fax
        02. Skype

    - Databases

        01. Google
        02. Facebook

* Lossless compression and expansion

    - Message. Binary data B we want to compress

    - Compress. Generates a "compressed" representation C(B)

    - Expand. Reconstructs original bit-stream B

    - Compression ration. Bits in `C(B) / bits in B`

        + Ex. 50-75% or better compression ration for natural language

* Food for thought

    - Data compression has been omnipresent since antiquilty

        + Number systems
        + Natural languages
        + Mathematical notation

    - has played a central role in communication technology

        + Grade 2 Braille
        + Morse code
        + Telephone system

    - And is part of modern life

        + MP3
        + MPEG

* Another application. Data representation: genomic code

    - Genome. String over the alphabet { A, C, T, G }

        + Goal. Encode an *N*-character genome: ATAGATGCATِG...

        + Standard ASCII encoding

            . 8 bits per chars

            . 8 N its

            . because they are 4 characters you can use 2 bits to store them

    - Fixed-length code. A-bit code support alphabet of size 2<sup>k</sup>

    - Amazing but true. Initial genomic databases in 1990s used ASCII

## Run length coding

* Simple type of redundancy in a bitstream. Long runs of repeated bits
    - This string 

    

 `0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1`

    - Representation. 4-bit counts to represent alternating runs of 0s and 1s: 15 0s, then7 1s, then 7 0s, then 11 1a

    

    - Q. How many bits to store the counts?

        + A. We'll use 8 (but 4 in the example above)

    - Q. What to do when run length exceeds max count?

        + A. if longer than 55, intersperse runs on length -

    - Applications. JPEG, ITU-T T$ Group 3 fax, ....

## Huffman compression

* Variable-length codes

* Use different number of bits to encode different chars

* Ex. Morse code: `... - - - . . .`

    - Issue. Ambiguity

        + SOS ?
        + V7 ?
        + IAMIE ?
        + EEWNI ?

    - In practice. Use a medium gap to separate codewords

* Q. How do we avoid ambiguity?

    - A. Ensure that no codeword is a `prefix` of another

        + Ex 1. Fixed-length code

        + Ex 2. General prefix-free code

        + Ex 3. General prefix-free code

* Q. How to represent the prefix-free code?

    - A. binary trie!
        + Chars in leaves
        + Codeword is path from root to leaf

* Compression

    - Method 1: start at leaf, follow path up to the root, print bits in reverse

    - Method 2: creates ST of key-value pairs

* Expansion

    - Start at root

    - Go left if bit is 0, go right if 1

    - If leaf node, print char and return to root

* Q. How to write the trie?

    - A. Write pre-order traversal of trie, mark leaf and internal nodes with a bit 

* How to find best prefix-free code?

    - Shannon-Fano algorithm

        + Partition symbols S into two subsets S0 and S1 of (roughly) equal freq

        + Codewords for symbols in S0 start with 0, for symbols in S1 start with 1

        + Recur in S0 and S1

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

            01. Count frequency freq\[i\] for each char i in input
            02. Start with one node corresponding to each char i \(with weight freq\[i\]\)
            03. Repeat until single trie formed

                Select two tries with min weight freq[i] and freq[j]  
                Merge into single trie with freq[i] + freq[j]

* Running time. Use a binary heap `N + R log R`

---

## LZW compression

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

    01. Create ST associating W-bit codewords with string keys
    02. Initialize ST with codewords for single-char keys
    03. Find longest string s in ST that is a prefix of un-scanned part of input
    04. Write the w-bit codeword associated with s
    05. Add s\+c to ST, where c is next char in the input

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

---

## Data compression summary

* Lossless compression
    - Represent fixed-length symbols with variable-length codes [huffman]
    - Represent variable-length symbols with fixed-length codes [LZW]

* Lossy compression [not covered in this course]

    - JPEG, MPEG, MP3
    - FFT, wavelets, fractals

---

# Overview: introduction to advanced topics

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

---

## Reductions

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

            01. Sort N items
            02. Return item in the middle

        . Cost of solving finding the median `N log N + 1`

    - Ex 2. [element distinctness reduces to sorting]

        . To solve elements distinctness on N times:

            01. Sort N items
            02. Check adjacent paris for equality

        . Cost of solving finding the median `N log N + 1`

---

## Design algorithms

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

---

## Establish lower bound

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

---

## Classify problems

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

[open-source-img]:https://badges.frapsoft.com/os/v1/open-source.svg?v=10
[alg-img]:https://img.shields.io/static/v1?label=Topic&message=Algorithms&color=orange&style=flat
[datastr-img]:https://img.shields.io/static/v1?label=Topic&message=Data-Structures&color=blue&style=flat
[rep-url]: https://github.com/ahmadmoawad/algorithms
