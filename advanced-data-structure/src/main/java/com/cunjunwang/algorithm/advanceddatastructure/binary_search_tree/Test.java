package com.cunjunwang.algorithm.advanceddatastructure.binary_search_tree;

/**
 * Created by CunjunWang on 2019-07-30.
 */
public class Test {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.preOrderIterative();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.levelOrder();
        System.out.println();
    }

}