package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;

public class RevertNNodesFromList {

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
}
