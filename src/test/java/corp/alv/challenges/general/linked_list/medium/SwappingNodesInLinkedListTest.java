package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwappingNodesInLinkedListTest {

    @Test
    void swapNodes() {
        SwappingNodesInLinkedList task = new SwappingNodesInLinkedList();

        ListNode node = ListNode.buildList(1, 5);
        assertEquals("{1,4,3,2,5}", task.swapNodes(node, 2).toString());

        node = ListNode.buildList(1, 10);
        assertEquals("{1,2,3,4,6,5,7,8,9,10}", task.swapNodes(node, 5).toString());
    }
}