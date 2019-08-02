package com.cunjunwang.algorithm.advanceddatastructure.heap;

import java.util.*;
import java.util.PriorityQueue;

/**
 * Created by CunjunWang on 2019-08-02.
 */
public class TopKFrequent {

    private class Frequency {
//            implements Comparable<Frequency> {
        int e, frequency;

        public Frequency(int e, int frequency) {
            this.e = e;
            this.frequency = frequency;
        }

//        @Override
//        public int compareTo(Frequency another) {
//            if (this.frequency < another.frequency) {
//                return -1;
//            } else if (this.frequency == another.frequency) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
    }

    private class FreqComparator implements Comparator<Frequency> {
        @Override
        public int compare(Frequency a, Frequency b) {
            return a.frequency - b.frequency;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 先统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Frequency> priorityQueue = new PriorityQueue<>(new FreqComparator());
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Frequency(key, map.get(key)));
            } else if (map.get(key) > priorityQueue.peek().frequency) {
                priorityQueue.remove();
                priorityQueue.add(new Frequency(key, map.get(key)));
            }
        }
        List<Integer> result = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.remove().e);
        }
        return result;
    }
}
