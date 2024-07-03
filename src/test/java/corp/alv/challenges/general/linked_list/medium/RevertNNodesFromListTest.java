package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RevertNNodesFromListTest {

    RevertNNodesFromList task = new RevertNNodesFromList();

    @Test
    void reverse() {
        ListNode node = ListNode.buildList(1, 5);

        assertEquals("{3,2,1,4,5}", task.reverse(node, 3).toString());
    }
}