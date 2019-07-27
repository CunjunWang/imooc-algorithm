package com.cunjunwang.algorithm.advanceddatastructure.queue;

import java.util.Random;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class TestQueue {

    /**
     * 测试使用q运存operationCount这么多次操作需要的时间, 单位为秒
     *
     * @param q              队列
     * @param operationCount 操作次数
     * @return 操作时间
     */
    private static double testQueue(Queue<Integer> q, int operationCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        // Array Queue, time: 5.888052848 s.
        // Loop Queue, time: 0.030927702 s.
        // Linked List Queue, time: 0.022387221 s.
        // 差距主要在dequeue上, Array Queue为O(n)的dequeue操作

        int operationCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, operationCount);
        System.out.println("Array Queue, time: " + time1 + " s.");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, operationCount);
        System.out.println("Loop Queue, time: " + time2 + " s.");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, operationCount);
        System.out.println("Linked List Queue, time: " + time3 + " s.");
    }
}
