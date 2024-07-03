package corp.alv.challenges.general.linked_list.easy;

import corp.alv.challenges.domain.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next; // first, make sure we don't lose the next node
            curr.next = prev;              // reverse the direction of the pointer
            prev = curr;                   // set the current node to prev for the next node
            curr = nextNode;               // move on
        }

        return prev;
    }

    public static void main(String[] args) {
        //1,2,3,4,5
        ListNode node = new ListNode(1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(
                                                5
                                        )
                                )
                        )
                ));

        ReverseLinkedList task = new ReverseLinkedList();
        System.out.println(task.reverseList(node));

        System.out.println(task.reverseList(ListNode.buildList(1, 8, 1)));
    }
}
