# Using Priority Queues

A problem involving priority queues/heaps to maintain the largest elements in a set of data. Details below. 

K-Largest Values 

Finding the k-largest values in a set of data - Assume you are given a sequence of values. We do not know how many elements there are in this sequence. In fact, there could be infinitely many. Implement the class
```KBestCounter<T extends Comparable<? super T>> implements KBest<T>``` that keeps track of the k-largest elements seen so far in a set of data. The class should have two methods:

* ```public void count(T x)``` - process the next element in the set of data. This operation should run in the at worst O(log k) time.

* ```public List<T> kbest()``` - return a sorted (largest to smallest) list of the klargest elements. This should run in O(k log k) time. The method should restore the priority queue to its original state after retrieving the k largest elements. If you run this method twice in a row, it should return the same values.

Be aware that your KBestCounter.java class must implement the provided interface KBest.java. This is to ensure that your method declarations are correct at the time of submission. Under no circumstance should you edit the KBest.java file.

Use a Priority Queue to implement this functionality. We suggest using the built-in java.util.PriorityQueue, which implements a min-heap for you. You should NEVER have more than k elements inserted into the Priority Queue at any given time.

An example illustrates how KBestCounter could be used in this attached tester class: TestKBest.java.  We also include a skeleton for the KBestCounter class in the following file: KBestCounter.java.
