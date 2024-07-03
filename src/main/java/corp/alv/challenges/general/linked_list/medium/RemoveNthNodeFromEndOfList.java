package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;

/*
Remove Nth Node From End of List
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head.next;
        }

        ListNode nodeBeforeN = head;
        while (curr.next != null) {
            curr = curr.next;
            nodeBeforeN = nodeBeforeN.next;
        }

        nodeBeforeN.next = nodeBeforeN.next.next;

        return head;
    }
}
