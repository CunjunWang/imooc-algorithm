package com.cunjunwang.algorithm.advanceddatastructure.segment_tree.Leetcode303;

import com.cunjunwang.algorithm.advanceddatastructure.segment_tree.SegmentTree;

/**
 * Created by CunjunWang on 2019-09-01.
 */
class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            this.segmentTree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
