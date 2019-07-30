package com.cunjunwang.algorithm.advanceddatastructure.binary_search_tree;

import lombok.Data;

/**
 * Created by CunjunWang on 2019-07-29.
 */
@Data
public class BST<E extends Comparable<E>> {

    @Data
    private class Node {

        public E e;

        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获取元素数量
     *
     * @return 元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向BST添加元素
     *
     * @param e 元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * BST是否包含e
     *
     * @param e 元素
     * @return 是否包含
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 向以node为root的BST添加元素
     *
     * @param node node
     * @param e    元素
     * @return 插入新节点后bst的root
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 以node为根的BST是否包含e
     *
     * @param node 节点
     * @param e    元素
     * @return 是否包含
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 从node开始前序遍历
     *
     * @param node 节点
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 从node开始中序遍历
     *
     * @param node 节点
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 从node开始后序遍历
     *
     * @param node 节点
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBstString(root, 0, result);
        return result.toString();
    }

    /**
     * 生成bst字符串
     *
     * @param node
     * @param depth
     * @param result
     */
    private void generateBstString(Node node, int depth, StringBuilder result) {
        if (node == null) {
            result.append(generateDepthString(depth) + "null\n");
            return;
        }
        result.append(generateDepthString(depth) + node.e + "\n");
        generateBstString(node.left, depth + 1, result);
        generateBstString(node.right, depth + 1, result);
    }

    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append("--");
        }
        return result.toString();
    }

}