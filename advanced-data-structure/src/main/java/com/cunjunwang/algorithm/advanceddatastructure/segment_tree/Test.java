package com.cunjunwang.algorithm.advanceddatastructure.segment_tree;

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
    }

}
