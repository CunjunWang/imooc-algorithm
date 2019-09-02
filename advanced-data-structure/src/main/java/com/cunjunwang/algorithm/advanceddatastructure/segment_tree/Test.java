package com.cunjunwang.algorithm.advanceddatastructure.segment_tree;

import com.cunjunwang.algorithm.advanceddatastructure.segment_tree.Leetcode307.NumArray2;

/**
 * Created by CunjunWang on 2019-09-01.
 */
public class Test {

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree.toString());

        Integer result = segmentTree.query(0, 2);
        System.out.println(result);
        result = segmentTree.query(2, 5);
        System.out.println(result);
        result = segmentTree.query(0, 5);
        System.out.println(result);

        segmentTree.set(1, 5);
        System.out.println(segmentTree.toString());
        result = segmentTree.query(0, 2);
        System.out.println(result);

        int[] n = {1, 3, 5};
        NumArray2 numArray2 = new NumArray2(n);
        numArray2.sumRange(0, 2);
        numArray2.update(1, 2);
        numArray2.sumRange(0, 2);

    }
}