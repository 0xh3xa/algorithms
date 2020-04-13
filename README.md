# Algorithms :heart: :smile:
![Algorithms][alg-img]
![Open Source Love][Open-Source-img]
Algorithms and data structures implementations from The - `Algorithms 4th edition` book :book: :atom:

<p align="center">
  <img src="https://www.technocrazed.com/wp-content/uploads/2015/12/Brick-wallaper-For-Background-28.jpg" alt="alg_img" width="500" border="2"/>
<p>

## What's is this course?
- Intermediate level survey course
- Programming and problem solving with applications

## Definition
`Algorithms`: Method for solving a problem  
`Data structures`: Method to store information  
`Program = Algorithms + Data structures` 

## Topics

`Part I`  

1. Data types: stack, queue, bag, union find, priority queue  
2. Sorting: quicksort, mergesort, heapsort, radix sorts  
3. Searching: BST, red-black BST, hash table  

`Part II`  

4. Graphs: BFS, DFS, Prime, Kruskal, Dijkstra  
5. Strings: KMP, regular expresssion, TST, Huffman, LZW  
6. Advanced: B-tee, suffix array, maxflow  

## Why Algorithms is so important?
Algorithms all around us  
1. Internet: Web search, packet routing, distribute file sharing, ...  
2. Biology: Human genome project, protein folding, ...  
3. Computers: Circuit layout, file system, compilers, ...  
4. Computer graphics: Movies, Video games, virtual reality, ...  
5. Security: Cell phones, e-commerce, voting machines, ...  
6. Multimedia: MP3, JPG, Divx, HDTV, face recognition, ...  
7. Social networks: Recommendations, news feeds, advertisments, ...  
8. Physics: N-body simulation, particle collision simulation, ...  

## Steps for solving the problem
1. Model the problem  
2. Find an algorithm to solve it  
3. Fast enough? Fits in memory?  
4. If not, figure out why  
5. Find a way to address the problem  
6. Iterate until satisfied  

## The scientific method

## Mathematical analysis

## Properties
1. Reflexive: p is connected to q  
2. Symmetric: if p is connected to q, then q is connected to p  
3. Transitive: if p is connected to q and q is connected to r, then p is connected to r

## Dynamic connectivity
Application for this:
1. Pixels in a digital photo  
2. Computers in network  
3. Friends in a social network  
4. Transistors in a computer chip  
5. Elements in a mathematical set  
6. Variables names in Fortran program  
7. Metallic sites in a composite system  

### Quick find (Eager approach)
1. Data structure
- Integer array `id[]` of size N  
- Interpretation: p and q are conncted (iff) if and only if they have the same id  

| Initialize  | Union | Find |
| ----------- | ----- |------|
| N           | N     |1     |

`defect` 
- Find too expensive (Could be N array accesses)  
- If you have N union commands over N objects will be O(N<sup>2</sup>) quadratic  

`We can not accept Quadratic in big problems`

`Quardratic algorithms do not scale`

#### Rough standards (for now)
- 10<sup>9</sup> operations per second  
- 10<sup>9</sup> words of main memory  
- Touch all words in approximately 1 second

#### E.g Huge problem for quick find
- 10<sup>9</sup> union commands of 10<sup>9</sup> objects  
- Quick find takes more than 10<sup>18</sup> operations  
- 30+ years of computer time!

### Quick Union
Set the first element based on the root of the second element
| Initialize  | Union | Find |
| ----------- | ----- |------|
| N           | N'    |1     |

`Defect`
- Tree can get tall  
- Find too expensive (Could be N array accesses)

### Quick Union improvment

1. Weighted Quick union

- Modify the Quick union to avoid tall trees  
- Balance by linking root of smaller tree to root of larger tree
- Depth of any node x is at most `lgN`

| Initialize  | Union | Find |
| ----------- | ----- |------|
| N           | lgN'  |lgN   |


2. Quick union with path compression `N+ M lgN`  
3. Weighted Quick union with path compression `N+ M lg*N`  
`WQUPC reduce time from 30 years to 6 seconds`

### Union find Applications
1. Percolation
2. Games (Go, Hex)
3. Dynamic connectivity
4. Last common ancestor
5. Hoshen-kopelman algorithm in pyhsics

### Percolation
A model for many physical systems
- N-by-N grid of sites  
- Each site is open probability p (or blocked with probability 1-p)  
- System percolatres iff top and bottom are connected by open sites  
- Application in real life

| Model | System | Vacant site | Occupied site | Percolates |
| -------| -------|-------------|-------------|----------|
| electricity | material| conductor | insulated | conducts |
| fluid flow | material| empty | blocked | porous |
| social interaction | population | person | empty | communicates |

## Algorithms Analysis

`Note` Good practice to use abstraction between the outside world and internal implementation, In java we will use interface

## Stack
LIFO (last in first out), useful in many applications  
There are two implementation of stack using `Linkedlist` and `Array`
, And there is trad offs between two of them

1. Linkedlist: Use extra space for dealing with links
2. Array: resize/shrink the array takes some time

So if you need speed like dealing with internet packet use `Linkedlist` implementation  
, But if you take care of `memory` space use `Array` implementation  

### Application
1. Parsing in a compiler
2. Java virtual machine
3. Undo in word processor
4. Back button in a web browser
5. Implementation function calls in a compiler
6. Arithmetic expression evaluation
7. Reverse objects

`Resize When reach 100% full the array resize(arr.length*2)` and `Shrink when reach one quarter full to the half resize(arr.length/2)`


## Queue
FIFO (first in first out), useful in many applications  

## Elementry sorts
Rerrange array of N times into ascending/descending order based on a key

1. Selection sort
2. Insertion sort
3. Shell sort
4. Heap sort
5. Quick sort

`Imp` In java there is `Comparable` and `Comparator` interfaces we will them any of them in the implementation of the sort algorithms  
to allow sort any generic data types  
There are three return values: 1, 0, -1 and throw Exception if incompatable types or null
V less than W (return -1)  
V equal to W (return 0)  
V greater than W (return1)  

#### Total order
1. Antisymmetry: if v<=w and w<=v, then v=w
2. Transitivity: if v<=w and w<=x, then v<=x
3. Totality: either v<=w or w<=v or both

### Selection sort
Scan from left to right  
Find the index of `min` of smallest remaning entry, then swap `a[i]` and `a[min]`  `-->`
`Time Complexity O(N<sup>2</sup>)` and doesn't sensetive if the input is sorted  

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

### Insertion sort
Scan from left to right  
Swap `a[i]` with each larger enry to its left `<--`
`Time Complexity O(N<sup>2</sup>)` and has good performance over `partially sorted arrays`  

`Algorithm`

```java
    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    swap(arr, j, j - 1);
                } else
                    break;
            }
        }
    }
```

### Shell sort
Move entries more than one position at a time by `h-sorting` the array  
What's the `h value` Knuth says `3x+1`  

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

#### Why Shell sort uses insertion sort internally?  
1. Fast unless array size is huge
2. Tiny used in some embedded systems
3. Hardware sort prototype

### Elmentary sort algorithms

| Algorithm | Best | Average | Worst |
|-----------|------|---------|-------|
| Selectionsort| N<sup>2</sup> | N<sup>2</sup> | N<sup>2</sup> |
| Insertionsort| N | N<sup>2</sup> | N<sup>2</sup> |
| Shellsort (3x+1)| NlogN | ? | N<sup>3/2</sup> |

## Shuffle sort  
Generate a random real number for each array entry  
Sort array  

### Knuth shuffle  
Pick integer r between 0 and i uniformaly at random  
Swap `a[i]` and `a[r]`  

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



## Merge sort
- This sort based on the technique of `divide-and-conquer`
- The sort that java uses to sort objects  
- Steps:  
1. Divide array into two halves  
2. Recursively sort each half  
3. Merge two havles















































































































[Open-Source-img]: https://badges.frapsoft.com/os/v1/open-source.svg?v=103
[alg-img]: https://img.shields.io/static/v1?label=Data_Structure&message=Algorithms&color=blue&style=flat