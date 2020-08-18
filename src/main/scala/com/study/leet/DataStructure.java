package com.study.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
 *
 * https://blog.csdn.net/u012926924/article/details/47955035
 *
 */
public class DataStructure {
    java.util.List<Integer> arr;

    // A hash where keys are array elements and values are
    // indexes in arr[]
    Map<Integer, Integer> hash;
    Random rand = new Random();

    public DataStructure() {
        this.arr = new ArrayList<>();
        this.hash = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hash.get(val) != null) {
            return false;
        }
        // Else put element at the end of arr[]

        hash.put(val, arr.size());
        arr.add(val);
        // And put in hash also
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = hash.get(val);
        if (index == null) {
            return false;
        }
        // If present, then remove element from hash
        arr.set(hash.get(val), arr.get(arr.size() - 1));
        hash.put(arr.get(arr.size() - 1), hash.get(val));
        // Swap element with last element so that remove from
        // arr[] can be done in O(1) time

        // Remove last element (This is O(1))
        hash.remove(val);
        // Update hash table for new index of last element
        arr.remove(arr.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // Find a random index from 0 to size - 1
        // Return element at randomly picked index
        if (arr.size() == 0) {
            return 0;
        }
        return arr.get(rand.nextInt(arr.size()));

    }
    // Returns index of element if element is present, otherwise null
    Integer search(int x) {

        return hash.get(x);
    }

    public static void main(String[] args) {
        DataStructure ds = new DataStructure();
        ds.getRandom();
        ds.remove(0);
        ds.remove(0);
        ds.insert(0);
        ds.getRandom();
        ds.remove(0);
        ds.insert(0);


    }
}



