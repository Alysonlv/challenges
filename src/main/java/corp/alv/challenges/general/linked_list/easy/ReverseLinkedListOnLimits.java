package corp.alv.challenges.general.linked_list.easy;

import corp.alv.challenges.domain.ListNode;

/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.



Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]


Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

 */
public class ReverseLinkedListOnLimits {

    private boolean stop;
    private ListNode prev;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.prev = head;
        this.stop = false;
        revert(head, left, right);
        return head;
    }

    private void revert(ListNode curr, int left, int right) {
        if (right == 1) {
            return;
        }

        curr = curr.next;
        if (left > 1) {
            this.prev = this.prev.next;
        }

        revert(curr, left - 1, right - 1);

        if (this.prev == curr || this.prev == curr.next) {
            this.stop = true;
        }

        if (!this.stop) {
            int t = this.prev.val;
            this.prev.val = curr.val;
            curr.val = t;

            this.prev = this.prev.next;
        }
    }
}
