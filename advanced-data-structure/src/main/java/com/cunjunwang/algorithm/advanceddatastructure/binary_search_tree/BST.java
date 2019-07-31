package com.cunjunwang.algorithm.advanceddatastructure.binary_search_tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * 迭代前序遍历
     */
    public void preOrderIterative() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.e);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
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
     * 广度优先遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.e);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /**
     * 找到bst中的最小元素
     *
     * @return 最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    /**
     * 找到bst中的最大元素
     *
     * @return 最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 删除最小元素
     *
     * @return 最小元素
     */
    public E removeMinimum() {
        E ret = minimum();
        root = removeMinimum(root);
        return ret;
    }

    /**
     * 删除最大元素
     *
     * @return 最大元素
     */
    public E removeMaximum() {
        E ret = maximum();
        root = removeMaximum(root);
        return ret;
    }

    /**
     * 删除元素 - Hibbard deletion
     *
     * @param e 待删除的元素
     */
    public void remove(E e) {
        root = remove(root, e);
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
     * 找到以node为根的bst中的最大元素
     *
     * @return 最大元素
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(root.right);
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
     * 删除以node为根的bst的最大节点
     *
     * @param node 根
     * @return 删除节点后新的bst的根
     */
    private Node removeMaximum(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaximum(node.right);
        return node;
    }

    /**
     * 删除以node为根的bst中值为e的节点
     *
     * @param node 根
     * @param e    待删除的元素
     * @return 删除节点后新的bst的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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