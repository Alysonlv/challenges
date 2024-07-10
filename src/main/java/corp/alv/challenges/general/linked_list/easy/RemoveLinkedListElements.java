package corp.alv.challenges.general.linked_list.easy;

import corp.alv.challenges.domain.ListNode;

/*
203. Remove Linked List Elements
Easy
Topics
Companies
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.



Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []


Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1, head);
        ListNode prev = sentinel;
        ListNode curr = sentinel.next;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return sentinel.next;
    }
}
/*
-1,7,1,2,7

Sentinel = -1,7,1,2,7



 */