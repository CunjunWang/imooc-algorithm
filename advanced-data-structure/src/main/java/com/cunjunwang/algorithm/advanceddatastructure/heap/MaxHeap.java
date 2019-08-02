package com.cunjunwang.algorithm.advanceddatastructure.heap;

import com.cunjunwang.algorithm.advanceddatastructure.array.Array;

/**
 * Created by CunjunWang on 2019-08-02.
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 向堆中添加元素
     *
     * @param e 待添加的元素
     */
    public void add(E e) {
        data.addLast(e);
        this.shiftUp(data.getSize() - 1);
    }

    /**
     * 查看堆中的最大元素
     *
     * @return 最大元素
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Heap is currently empty");
        }
        return data.get(0);
    }

    /**
     * 从堆中取出元素
     *
     * @return e 最大元素
     */
    public E extractMax() {
        E ret = findMax();
        // 删除最大元素
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        // 维护最大堆性质
        this.shiftDown(0);
        return ret;
    }

    /**
     * heap元素上浮
     *
     * @param k index
     */
    private void shiftUp(int k) {
        // k的parent元素比k的元素还要大的话, 要进行上浮
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * heap元素下沉
     *
     * @param k index
     */
    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            // 如果k有right child, 而且right child值比left child大
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                // 那么j赋值为right child的索引
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            } else {
                data.swap(k, j);
                k = j;
            }
        }
    }

    /**
     * 返回index的parent
     *
     * @param index index
     * @return parent
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have a parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回index的left child
     *
     * @param index index
     * @return left child
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回index的right child
     *
     * @param index index
     * @return right child
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }


}
