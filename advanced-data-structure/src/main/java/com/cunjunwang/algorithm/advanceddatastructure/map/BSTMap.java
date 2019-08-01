package com.cunjunwang.algorithm.advanceddatastructure.map;

import lombok.Data;

/**
 * Created by CunjunWang on 2019-08-01.
 */
@Data
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    @Data
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
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
        root = add(root, key, value);
    }

    /**
     * 删除键为key的元素
     *
     * @param key 键
     * @return 删除的元素值
     */
    @Override
    public V remove(K key) {
        Node node = this.getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
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
        return this.getNode(root, key) != null;
    }

    /**
     * 根据键获取值
     *
     * @param key 键
     * @return 值
     */
    @Override
    public V get(K key) {
        Node node = this.getNode(root, key);
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
        Node node = this.getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " does not exist in the map");
        }
        node.value = value;
    }

    /**
     * 向以node为root的BST添加元素
     *
     * @param node  node
     * @param key   键
     * @param value 值
     * @return 插入新节点后bst的root
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    /**
     * 返回以node为根的bst中key所在的节点
     *
     * @param node node
     * @param key  key
     * @return node
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * 找到以node为根的bst中的最小元素
     *
     * @return 最小元素
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(root.left);
    }

    /**
     * 删除以node为根的bst的最小节点
     *
     * @param node 根
     * @return 删除节点后新的bst的根
     */
    private Node removeMinimum(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinimum(node.left);
        return node;
    }

    /**
     * 删除以node为根的bst中键为key的节点
     *
     * @param node 根
     * @param key  待删除的元素的键
     * @return 删除节点后新的bst的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMinimum(node.right);
            // size++;
            successor.left = node.left;
            node.left = node.right = null;
            // size--;
            return successor;
        }
    }

}