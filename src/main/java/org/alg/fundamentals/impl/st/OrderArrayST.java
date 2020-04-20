// package org.alg.fundamentals.st;

// import java.util.Arrays;
// import java.util.Iterator;

// import org.alg.base.SymbolTable;
// import org.alg.sort.impl.MergeSort;

// public class OrderArrayST<Key extends Comparable, Value> implements SymbolTable<Key, Value> {

//     private Key[] keys;
//     private Value[] values;
//     private int ptr;

//     public OrderArrayST(int cap) {
//         keys = (Key[]) new Comparable[cap];
//         values = (Value[]) new Object[cap];
//         ptr = 0;
//     }

//     @Override
//     public void put(Key key, Value val) {
//         keys[ptr] = key;
//         values[ptr++] = val;
//         if (ptr > 2)
//             MergeSort.sort(keys, (Key[]) new Comparable[ptr], 0, ptr);
//     }

//     @Override
//     public Value get(Key key) {
//         int index = rank(key);
//         if (index < ptr && keys[index].compareTo(key) == 0) {
//             return values[index];
//         } else
//             return null;
//     }

//     @Override
//     public void delete(Key key) {
//         int index = rank(key);
//         if (index >= 0 && keys[index].compareTo(key) == 0) {
//             keys[index] = null;
//             values[index] = null;
//             ptr--;
//         }
//     }

//     @Override
//     public boolean contains(Key key) {
//         int index = rank(key);
//         if (index >= 0 && keys[index].compareTo(key) == 0)
//             return true;
//         return false;
//     }

//     @Override
//     public boolean isEmpty() {
//         return ptr == 0;
//     }

//     @Override
//     public int size() {
//         return ptr;
//     }

//     @Override
//     public Iterable<Key> keys() {
//         return new Iterable<Key>() {
//             @Override
//             public Iterator<Key> iterator() {
//                 return new Iterator<Key>() {
//                     private int i = 0;
//                     private int size = keys.length;

//                     @Override
//                     public boolean hasNext() {
//                         return i < size;
//                     }

//                     @Override
//                     public Key next() {
//                         return keys[i++];
//                     }
//                 };
//             }
//         };
//     }

//     private int rank(Key key) {
//         int lo = 0, hi = ptr - 1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             int cmp = key.compareTo(keys[mid]);
//             if (cmp < 0)
//                 hi = mid - 1;
//             else if (cmp > 0)
//                 lo = mid + 1;
//             else
//                 return mid;
//         }
//         return -1;
//     }
// }