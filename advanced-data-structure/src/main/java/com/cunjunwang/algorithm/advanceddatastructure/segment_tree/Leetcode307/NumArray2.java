package com.cunjunwang.algorithm.advanceddatastructure.segment_tree.Leetcode307;

import com.cunjunwang.algorithm.advanceddatastructure.segment_tree.Merger;
import com.cunjunwang.algorithm.advanceddatastructure.segment_tree.SegmentTree;

/**
 * Created by CunjunWang on 2019-09-01.
 */
public class NumArray2 {

    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        if (nums.length != 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 1; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }

    public void update(int i, int val) {
        segmentTree.set(i, val);
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */