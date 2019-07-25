package com.cunjunwang.algorithm.advanceddatastructure.stack;

/**
 * 栈的实现
 * Created by CunjunWang on 2019-07-25.
 */
public interface Stack<E> {

    /**
     * 返回栈中元素数量
     *
     * @return 元素数量
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e 入栈元素
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return 出栈元素
     */
    E pop();

    /**
     * 查看栈顶
     *
     * @return 栈顶元素
     */
    E peek();


}
