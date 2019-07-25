package com.cunjunwang.algorithm.advanceddatastructure.stack;

import com.cunjunwang.algorithm.advanceddatastructure.array.Array;

/**
 * Created by CunjunWang on 2019-07-25.
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 返回栈中元素数量
     * O(1)
     *
     * @return 元素数量
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     * O(1)
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获得容积
     * O(1)
     *
     * @return 容积
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 入栈
     * 均摊O(1)
     *
     * @param e 入栈元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈
     * 均摊O(1)
     *
     * @return 出栈元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack: ").append("[");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1) {
                result.append(", ");
            }
        }
        result.append("] top");
        return result.toString();
    }

}
