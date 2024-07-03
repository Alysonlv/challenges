package corp.alv.challenges.general.linked_list.easy;

import corp.alv.challenges.domain.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        /*
         * Using slow and fast pointer we revert in place the first half
         * On the case the original head is 1,2,2,1 after reverse we will have 2,1,2,1
         * However, we don't do a full reverse, so our "prev" will have just 2,1
         * and the slow will have the remaining 2,1
         */
        while (fast != null && fast.next != null) {//for checking reverse
            fast = fast.next.next;
            ListNode nextSlow = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextSlow;
        }

        //We move slow to next one if fast isn't null, because it means the length is odd,
        //so the middle node is immutable for us
        if (fast != null) {
            slow = slow.next;
        }

        while (prev != null && slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

    public boolean isPalindrome_(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();

        //1,2,2,1
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));
        System.out.println(p.isPalindrome(head));

        //1,1,2,1
        head = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(1))));
        System.out.println(p.isPalindrome(head));
    }
}
