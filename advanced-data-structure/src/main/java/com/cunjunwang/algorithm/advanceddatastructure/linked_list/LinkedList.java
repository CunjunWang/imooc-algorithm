package com.cunjunwang.algorithm.advanceddatastructure.linked_list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class LinkedList<E> {

    @Data
    @ToString
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
    }

    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在指定索引处(0-based)添加
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, illegal index");
        }
//        if (index == 0) {
//            addFirst(e);
//        } else {
//            Node prev = head;
//            for (int i = 0; i < index - 1; i++) {
//                prev = prev.next;
//            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
//            // elegant:
//            // prev.next = new Node(e, prev.next);
//            size++;
//        }
        // 引入dummyHead, 对head不用分类讨论;
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /**
     * 在链表头部添加
     *
     * @param e 元素
     */
    public void addFirst(E e) {
//        // elegant:
//        // head = new Node(e, head);
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        size++;
        add(0, e);
    }

    /**
     * 在链表末尾添加
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }


}
