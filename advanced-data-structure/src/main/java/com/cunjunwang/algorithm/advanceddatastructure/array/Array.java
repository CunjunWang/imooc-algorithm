package com.cunjunwang.algorithm.advanceddatastructure.array;

/**
 * 自定义数组类, 基于java自带的静态数组实现动态数组
 * Created by CunjunWang on 2019-07-25.
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * 构造函数
     * 传入数组的容量capacity构造Array
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        // java不支持直接new 泛型数组
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认无参构造函数, capacity = 10
     */
    public Array() {
        this(10);
    }

    /**
     * 使用传入的数组构造动态数组
     *
     * @param arr 传入数组
     */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
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
     * O(1)
     *
     * @param e 添加元素
     */
    public void addLast(E e) {
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
     * O(n)
     *
     * @param e 添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 向指定位置index最后添加元素e
     * 平均复杂度: O(n)
     *
     * @param index 位置
     * @param e     添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取索引为index的元素
     * O(1)
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * O(1)
     *
     * @return 元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     * O(1)
     *
     * @return 元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改索引为index的元素为e
     * O(1)
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否存在e
     * O(n)
     *
     * @param e 元素
     * @return 是否存在
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 找到e在数组中的索引
     * O(n)
     *
     * @param e 元素
     * @return 索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删掉index位置的元素
     * O(n)
     *
     * @param index 索引
     * @return 返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        E item = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak
        // 最开始为size <= data.length / 2,
        // 为了避免均摊复杂度震荡, 改为Lazy策略而不是Eager策略
        if (size <= data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return item;
    }

    /**
     * 删除第一个元素
     * O(n)
     *
     * @return 元素值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * O(1)
     *
     * @return 元素值
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素, 只删除一个
     * O(n)
     *
     * @param e 要删除的元素
     * @return 是否已删除
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 交换元素位置
     *
     * @param i i
     * @param j j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
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

    /**
     * 扩容、缩容
     * O(n)
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
