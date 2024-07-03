package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndOfListTest {

    private RemoveNthNodeFromEndOfList task = new RemoveNthNodeFromEndOfList();

    @Test
    void removeNthFromEnd() {

        ListNode head = ListNode.buildList(1, 5);
        assertEquals("{1,2,3,5}", task.removeNthFromEnd(head, 2).toString());

        head = ListNode.buildList(1, 5);
        assertEquals("{2,3,4,5}", task.removeNthFromEnd(head, 5).toString());
    }
}