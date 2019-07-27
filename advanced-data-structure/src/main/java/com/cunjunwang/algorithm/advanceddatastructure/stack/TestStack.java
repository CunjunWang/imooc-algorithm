package com.cunjunwang.algorithm.advanceddatastructure.stack;

import java.util.Random;

/**
 * Created by CunjunWang on 2019-07-25.
 */
public class TestStack {

    /**
     * 测试使用stack运存operationCount这么多次操作需要的时间, 单位为秒
     *
     * @param stack          栈
     * @param operationCount 操作次数
     * @return 操作时间
     */
    private static double testStack(Stack<Integer> stack, int operationCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int operationCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, operationCount);
        System.out.println("Array Stack, time: " + time1 + " s.");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, operationCount);
        System.out.println("Linked List Stack, time: " + time2 + " s.");
    }

}
