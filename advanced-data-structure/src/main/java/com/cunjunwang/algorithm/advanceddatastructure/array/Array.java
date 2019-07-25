package com.cunjunwang.algorithm.advanceddatastructure.array;

/**
 * 自定义数组类, 基于java自带的静态数组实现动态数组
 * Created by CunjunWang on 2019-07-25.
 */
public class Array {

    private int[] data;

    private int size;

    /**
     * 构造函数
     * 传入数组的容量capacity构造Array
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认无参构造函数, capacity = 10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 向数组最后添加元素e
     *
     * @param e 添加元素
     */
    public void addLast(int e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed, array is already full");
//        }
//        // data[size++] = e;
//        data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * 向数组头添加元素e
     *
     * @param e 添加元素
     */
    public void addFirst(int e) {
        add(0, e);
    }


    /**
     * 向指定位置index最后添加元素e
     *
     * @param index 位置
     * @param e     添加元素
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed, array is already full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取索引为index的元素
     *
     * @param index 索引
     * @return 元素
     */
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        return data[index];
    }

    /**
     * 修改索引为index的元素为e
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        data[index] = e;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

}
