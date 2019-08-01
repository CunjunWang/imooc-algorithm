package com.cunjunwang.algorithm.advanceddatastructure.map;

import lombok.Data;

/**
 * Created by CunjunWang on 2019-08-01.
 */
@Data
public class LinkedListMap<K, V> implements Map<K, V> {

    @Data
    private class Node {

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * map中键的数量
     *
     * @return 键的数量
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * map是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param key   键
     * @param value 值
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    /**
     * 删除键为key的元素
     *
     * @param key 键
     * @return 删除的元素值
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    /**
     * 是够包含键为Key的元素
     *
     * @param key 键
     * @return 是否包含
     */
    @Override
    public boolean contains(K key) {
        return this.getNode(key) != null;
    }

    /**
     * 根据键获取值
     *
     * @param key 键
     * @return 值
     */
    @Override
    public V get(K key) {
        Node node = this.getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 根据键设置值
     *
     * @param key   键
     * @param value 值
     */
    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist in the map!");
        } else {
            node.value = value;
        }
    }

    /**
     * 根据key获取node
     *
     * @param key key
     * @return node
     */
    private Node getNode(K key) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
