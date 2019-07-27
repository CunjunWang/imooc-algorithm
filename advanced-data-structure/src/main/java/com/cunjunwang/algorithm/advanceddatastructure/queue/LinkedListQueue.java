package com.cunjunwang.algorithm.advanceddatastructure.queue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * use linked list with tail node pointer
 * to implement a queue.
 * <p>
 * Created by CunjunWang on 2019-07-27.
 */
public class LinkedListQueue<E> implements Queue<E> {

    @Data
    @AllArgsConstructor
    private class Node {
        public E e;
        public Node next;

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;

    private Node tail;

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 队列大小
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     * 从linked list尾部添加
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        // 如果tail == null
        // 那么linked list本身一定为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     * 从linked list头部出队
     *
     * @return 队首元素
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        // 如果链表只有一个元素
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    /**
     * 查看队首元素
     *
     * @return 队首原色
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return tail.e;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: front ");
        Node current = head;
        while(current != null) {
            result.append("current").append(" -> ");
            current = current.next;
        }
        result.append("NULL tail");
        return result.toString();
    }

}
