package com.cunjunwang.algorithm.advanceddatastructure.segment_tree.Leetcode307;

/**
 * Created by CunjunWang on 2019-09-01.
 */
// TLE
public class NumArray {

    // 数据预处理
    // sum[i] 存储前i个元素的和
    // sum[i] 存储nums[0...i-1]的和
    private int[] sum;

    private int[] data;

    public NumArray(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int index = i + 1; index < sum.length; index++) {
            sum[index] = sum[index - 1] + data[index - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */