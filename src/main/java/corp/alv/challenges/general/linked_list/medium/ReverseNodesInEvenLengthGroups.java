package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;

/*
2074. Reverse Nodes in Even Length Groups
Medium
Topics
Companies
Hint
You are given the head of a linked list.

The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it. In other words,

The 1st node is assigned to the first group.
The 2nd and the 3rd nodes are assigned to the second group.
The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.

Reverse the nodes in each group with an even length, and return the head of the modified linked list.



Example 1:
Input: head = [5,2,6,3,9,1,7,3,8,4]
Output: [5,6,2,3,9,1,4,8,3,7]
Explanation:
- The length of the first group is 1, which is odd, hence no reversal occurs.
- The length of the second group is 2, which is even, hence the nodes are reversed.
- The length of the third group is 3, which is odd, hence no reversal occurs.
- The length of the last group is 4, which is even, hence the nodes are reversed.

Example 2:
Input: head = [1,1,0,6]
Output: [1,0,1,6]
Explanation:
- The length of the first group is 1. No reversal occurs.
- The length of the second group is 2. The nodes are reversed.
- The length of the last group is 1. No reversal occurs.

Example 3:
Input: head = [1,1,0,6,5]
Output: [1,0,1,5,6]
Explanation:
- The length of the first group is 1. No reversal occurs.
- The length of the second group is 2. The nodes are reversed.
- The length of the last group is 2. The nodes are reversed.


Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 105
 */
public class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode original = head;
        ListNode curr = head.next;
        int index = 2;
        int nextGroupStart = 2;
        int i = 2;

        while (curr != null) {
            if (index == nextGroupStart) {
                nextGroupStart += i;
                if (getLengthUntil(curr, i) % 2 == 0) {
                    curr = reverse(curr, index);
                }
                i++;
            }
            index++;
            head.next = curr;
            head = head.next;
            curr = curr.next;
        }

        return original;
    }

    public ListNode reverse(ListNode head, int count) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null && count > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            // EXTRA CASE ADDS UP...
            count--;
        }
        head.next = next;
        return prev;
    }

    private int getLengthUntil(ListNode node, int size) {
        int length = 0;
        ListNode curr = node;
        while (curr != null && size > 0) {
            length++;
            size--;
            curr = curr.next;
        }

        return length;
    }

    public static void main(String[] args) {
        ReverseNodesInEvenLengthGroups t = new ReverseNodesInEvenLengthGroups();

        ListNode node = new ListNode(5,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(9,
                                                new ListNode(1,
                                                        new ListNode(7,
                                                                new ListNode(3,
                                                                        new ListNode(8,
                                                                                new ListNode(4))))))))));

        System.out.println(node);
        System.out.println(t.reverseEvenLengthGroups(node));

        //1,1,0,6,5
        node = new ListNode(1,
                new ListNode(1,
                        new ListNode(0,
                                new ListNode(6,
                                        new ListNode(5)))));
        System.out.println(node);
        System.out.println(t.reverseEvenLengthGroups(node));
    }
}
