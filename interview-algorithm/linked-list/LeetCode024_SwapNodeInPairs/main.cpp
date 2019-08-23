#include <iostream>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        ListNode *dummyHead = new ListNode(0);
        dummyHead->next = head;

        ListNode *p = dummyHead;
        while (p->next && p->next->next) {
            ListNode *node1 = p->next;
            ListNode *node2 = node1->next;
            ListNode *next = node2->next;

            node2->next = node1;
            node1->next = next;
            p->next = node2;

            p = node1;
        }

        ListNode *retNode = dummyHead->next;
        delete dummyHead;
        return retNode;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}