package com.cunjunwang.algorithm.advanceddatastructure.segment_tree;

/**
 * Created by CunjunWang on 2019-09-01.
 */
public interface Merger<E> {

    E merge(E a, E b);

}
