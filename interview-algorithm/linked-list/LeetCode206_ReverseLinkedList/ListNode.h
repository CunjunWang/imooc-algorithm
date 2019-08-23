//
// Created by 王存俊 on 2019-08-22.
//

#ifndef LEETCODE206_REVERSELINKEDLIST_LISTNODE_H
#define LEETCODE206_REVERSELINKEDLIST_LISTNODE_H

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

#endif //LEETCODE206_REVERSELINKEDLIST_LISTNODE_H
