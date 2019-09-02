package com.cunjunwang.algorithm.advanceddatastructure.segment_tree;

/**
 * Created by CunjunWang on 2019-09-01.
 */
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    /**
     * 在treeIndex位置创建表示区间[l...r]的线段树
     *
     * @param treeIndex 线段树的root位置
     * @param l         区间左端点
     * @param r         区间右端点
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        // 端点值由业务决定, 综合左右两个信息
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 在[queryL...queryR]区间中查询
     *
     * @param queryL 查询区间左端点
     * @param queryR 查询区间右端点
     * @return 值
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 递归查询函数, 从treeIndex出发, 这个节点表示的区间是[l...r]
     * 要查询区间[queryL, queryR]
     *
     * @param treeIndex 当前线段树的root
     * @param l         该root表示的区间左端点
     * @param r         该root表示的区间右端点
     * @param queryL    查询区间左端点
     * @param queryR    查询区间右端点
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // 查询区间完全在右边
        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }
        // 查询区间完全在左边
        else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        // 查询区间分在左右两边
        else {
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }
    }

    /**
     * 返回完全二叉树的数组表示中, 左孩子的索引
     *
     * @param index 当前索引
     * @return 左孩子索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中, 右孩子的索引
     *
     * @param index 当前索引
     * @return 右孩子索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
