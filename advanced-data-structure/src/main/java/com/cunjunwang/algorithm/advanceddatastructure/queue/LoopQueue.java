package com.cunjunwang.algorithm.advanceddatastructure.queue;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    // 队首
    private int front;

    // 队列最后一个元素的下一个位置
    private int tail;

    private int size;

    // front == tail 队列为空
    // tail + 1 == front 队列为满

    // 在循环队列中, 浪费了一个元素的空间, 实际可存放的元素为capacity+1个
    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获得容积
     * O(1)
     *
     * @return 容积
     */
    // 在循环队列中, 浪费了一个元素的空间, 实际可存放的元素为capacity+1个
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 队列大小
     * O(1)
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     * O(1)
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队
     * 均摊O(1)
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队
     * 均摊O(1)
     *
     * @return 队首元素
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    /**
     * 查看队首元素
     *
     * @return 队首原色
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return data[front];
    }

    /**
     * 容量变化
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Loop Queue: size = %d, capacity = %d\n", size, getCapacity()))
                .append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if ((i + 1) % data.length != tail) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }

}
