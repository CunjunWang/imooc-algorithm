package com.cunjunwang.algorithm.advanceddatastructure.linked_list;

import lombok.Data;
import lombok.ToString;

/**
 * Created by CunjunWang on 2019-07-27.
 */
@Data
@ToString
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Arr can not be empty");
        }
        this.val = arr[0];
        ListNode current = this;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

}
