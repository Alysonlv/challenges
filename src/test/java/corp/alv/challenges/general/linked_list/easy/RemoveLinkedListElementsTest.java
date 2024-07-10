package corp.alv.challenges.general.linked_list.easy;

import corp.alv.challenges.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveLinkedListElementsTest {

    @Test
    void removeElements() {
        RemoveLinkedListElements t = new RemoveLinkedListElements();

        ListNode node = ListNode.buildList(new int[]{7, 7, 7, 7});
        assertEquals(null, t.removeElements(node, 7));

        node = ListNode.buildList(new int[]{7, 2, 4, 7});
        assertEquals("{2,4}", t.removeElements(node, 7).toString());
    }
}