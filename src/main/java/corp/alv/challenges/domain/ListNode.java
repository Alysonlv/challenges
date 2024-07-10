package corp.alv.challenges.domain;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode curr = this;
        sb.append("{");
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(",");
            }
            curr = curr.next;
        }
        sb.append("}");

        return sb.toString();
    }

    // Builder method to create a linked list from start to end with a given increment
    public static ListNode buildList(int start, int end) {
        return buildList(start, end, 1);
    }

    public static ListNode buildList(int start, int end, int increment) {
        if (start > end || increment <= 0) {
            throw new IllegalArgumentException("Invalid arguments: start must be less than or equal to end, and increment must be positive");
        }

        ListNode head = new ListNode(start);
        ListNode current = head;

        for (int i = start + increment; i <= end; i += increment) {
            ListNode newNode = new ListNode(i);
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    public static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // Handle empty array case
        }

        ListNode head = new ListNode(arr[0]); // Create head node with first element
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            current.next = newNode;
            current = current.next;
        }

        return head;
    }
}
