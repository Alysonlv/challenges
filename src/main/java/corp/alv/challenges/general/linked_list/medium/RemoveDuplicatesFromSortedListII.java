package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;

import java.util.HashMap;
import java.util.Map;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.

 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // If it's a beginning of the duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // Move till the end of the duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // Skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }//-3-3-2-1-100

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII t = new RemoveDuplicatesFromSortedListII();
        /*
            Input: head = [1,2,3,3,4,4,5]
            Output: [1,2,5]
         */
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(
                                        3,
                                        new ListNode(4,
                                                new ListNode(4, new ListNode(5)))
                                ))));

        System.out.println(t.deleteDuplicates(head));

        head = new ListNode(1,
                new ListNode(1));

        System.out.println(t.deleteDuplicates(head));

        head = new ListNode(-3,
                new ListNode(-3,
                        new ListNode(-2,
                                new ListNode(-1,
                                        new ListNode(-1,
                                                new ListNode(0,
                                                        new ListNode(0)))))));

        System.out.println(t.deleteDuplicates(head));
    }
}
