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

}
