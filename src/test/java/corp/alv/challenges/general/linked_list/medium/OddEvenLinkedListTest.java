package corp.alv.challenges.general.linked_list.medium;

import corp.alv.challenges.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenLinkedListTest {

    @Test
    void oddEvenList() {
        OddEvenLinkedList t = new OddEvenLinkedList();

        ListNode node = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        System.out.println(t.oddEvenList(node));
    }
}