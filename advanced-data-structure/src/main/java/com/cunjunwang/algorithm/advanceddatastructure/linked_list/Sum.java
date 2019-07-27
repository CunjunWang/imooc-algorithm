package com.cunjunwang.algorithm.advanceddatastructure.linked_list;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class Sum {

    /**
     * find sum of arr with recursion
     *
     * @param arr arr
     * @return sum
     */
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * find sum of arr from arr[l...n)
     *
     * @param arr array
     * @param l   left limit
     * @return sum
     */
    // 所有recursion都可以拆成两部分
    private static int sum(int[] arr, int l) {
        // part1: 求解最基本的问题, 也就是递归结束条件
        if (l == arr.length) {
            return 0;
        }
        // part2: 把原问题转化成更小的同一个问题
        // 要根据更小的问题的答案构建出原问题的答案
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 2, 5, 4, 6, 6, 4, 8, 3, 2, 5, 8, 5};
        int sum = sum(nums);
        System.out.println("sum = " + sum);
    }

}
