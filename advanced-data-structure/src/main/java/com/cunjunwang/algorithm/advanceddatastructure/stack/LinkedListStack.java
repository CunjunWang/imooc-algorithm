package com.cunjunwang.algorithm.advanceddatastructure.stack;

import com.cunjunwang.algorithm.advanceddatastructure.linked_list.LinkedList;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    /**
     * 返回栈中元素数量
     *
     * @return 元素数量
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入栈
     *
     * @param e 入栈元素
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * 出栈
     *
     * @return 出栈元素
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * 查看栈顶
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("LinkedList Stack: top ");
        result.append(list);
        return result.toString();
    }

}
