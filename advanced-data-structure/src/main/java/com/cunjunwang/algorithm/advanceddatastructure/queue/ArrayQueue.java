package com.cunjunwang.algorithm.advanceddatastructure.queue;

import com.cunjunwang.algorithm.advanceddatastructure.array.Array;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 队列大小
     * O(1)
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 是否为空
     * O(1)
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获得容积
     * O(1)
     *
     * @return 容积
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 入队
     * 均摊O(1)
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队
     * O(n) 拿出第一个元素后, 后面每一个元素都要前移
     *
     * @return 队首元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队首元素
     *
     * @return 队首原色
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: ").append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }

}
