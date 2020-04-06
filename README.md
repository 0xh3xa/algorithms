# Algorithms :heart: :smile:
![Algorithms][alg-img]
![Open Source Love][Open-Source-img]
Algorithms and data structures implementations from The `Algorithms 4th edition` book :book: :atom:

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
- Integer array id[] of size N  
- Interpretation: p and q are conncted (iff) if and only if they have the same id  

| Initialize  | Union | Find |
| ----------- | ----- |------|
| N           | N     |1     |

`defect` 
- Find too expensive (Could be N array accesses)  
- If you have N union commands over N objects will be O(N^2) quadratic  

`We can not accept Quadratic in big problems`

## Quardratic algorithms do not scale

#### Rough standards (for now)
- 10^9 operations per second  
- 10^9 words of main memory  
- Touch all words in approximately 1 second

#### E.g Huge problem for quick find
- 10^9 union commands of 10^9 objects  
- Quick find takes more than 10^18 operations  
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


































[Open-Source-img]: https://badges.frapsoft.com/os/v1/open-source.svg?v=103
[alg-img]: https://img.shields.io/static/v1?label=Data_Structure&message=Algorithms&color=blue&style=flat
