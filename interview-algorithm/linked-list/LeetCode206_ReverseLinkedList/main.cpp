#include <iostream>
#include "ListNode.h"

class Solution {
public:
    ListNode *reverseList(ListNode *head) {
        if (!head) {
            return nullptr;
        }
        ListNode *pre = nullptr;
        ListNode *cur = head;
        while (cur) {
            ListNode *next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}