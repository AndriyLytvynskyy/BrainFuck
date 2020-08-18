package com.study.leet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author andrii_lytvynskyi
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap();

        for (int i = 0; i < nums.length;i ++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

      // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(freqMap::get));


        for (int n: freqMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;

    }

}
