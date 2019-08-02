package com.cunjunwang.algorithm.advanceddatastructure.heap;

import java.util.Random;

/**
 * Created by CunjunWang on 2019-08-02.
 */
public class TestHeap {

    private static void testHeap() {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error.");
            }
        }
        System.out.println("Test MaxHeap Completed.");
    }

    private static double testHeapify(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }
        long endTime = System.nanoTime();

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error.");
            }
        }
        System.out.println("Test MaxHeap Completed.");

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i ++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeapify(testData, false);
        System.out.println("Without Heapify: " + time1 + " s.");
        double time2 = testHeapify(testData, true);
        System.out.println("With Heapify: " + time2 + " s.");
    }
}
