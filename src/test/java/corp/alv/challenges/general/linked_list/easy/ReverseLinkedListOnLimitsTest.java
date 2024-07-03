package corp.alv.challenges.general.linked_list.easy;

import corp.alv.challenges.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListOnLimitsTest {

    private ReverseLinkedListOnLimits task = new ReverseLinkedListOnLimits();

    @Test
    void reverseBetween() {
        ListNode head = ListNode.buildList(1, 5, 1);

        assertEquals("{1,4,3,2,5}", task.reverseBetween(head, 2, 4).toString());

        head = ListNode.buildList(1, 8, 1);
        assertEquals("{1,5,4,3,2,6,7,8}", task.reverseBetween(head, 2, 5).toString());
    }
}