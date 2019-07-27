package com.cunjunwang.algorithm.advanceddatastructure.linked_list;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * linked list with dummy head
 * Created by CunjunWang on 2019-07-27.
 */
public class LinkedList<E> {

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

    /**
     * 在指定索引处(0-based)获取
     *
     * @param index 索引
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    /**
     * 获取第一个元素
     *
     * @return 第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     *
     * @return 最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 在index位置设置元素
     *
     * @param index 位置
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    /**
     * 判断链表是否存在元素
     *
     * @param e 元素
     * @return 是否存在
     */
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * 在指定索引处(0-based)删除
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 删除头部元素
     *
     * @return 头部元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾部元素
     *
     * @return 尾部元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            result.append(current).append(" -> ");
            current = current.next;
        }
        result.append("NULL");
        return result.toString();
    }

}
