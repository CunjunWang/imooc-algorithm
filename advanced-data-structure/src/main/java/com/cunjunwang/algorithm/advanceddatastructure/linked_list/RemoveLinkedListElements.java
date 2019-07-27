package com.cunjunwang.algorithm.advanceddatastructure.linked_list;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                // 这里不要prev = prev.next;
                // 因为下一个next可能依然要删除
                // 回到循环中让循环条件去判定
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    public ListNode removeElementsWithDummyHead(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElementsRecursion(head.next, val);
        } else {
            head.next = removeElementsRecursion(head.next, val);
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println("head = " + head);

        ListNode listNode1 = (new RemoveLinkedListElements()).removeElements(head, 6);
        System.out.println(listNode1);

        ListNode listNode2 = (new RemoveLinkedListElements()).removeElementsWithDummyHead(head, 6);
        System.out.println(listNode2);

        ListNode listNode3 = (new RemoveLinkedListElements()).removeElementsRecursion(head, 6);
        System.out.println(listNode3);
    }

}
