package corp.alv.challenges.general.graphs.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameIIITest {

    private JumpGameIII jpg3 = new JumpGameIII();

    @Test
    void canReach_Case01() {
        int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        int start = 5;

        assertTrue(jpg3.canReach(arr, start));
    }

    @Test
    void canReach_Case02() {
        int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        int start = 0;

        assertTrue(jpg3.canReach(arr, start));
    }

    @Test
    void canReach_Case03() {
        int[] arr = new int[]{3, 0, 2, 1, 2};
        int start = 2;

        assertFalse(jpg3.canReach(arr, start));
    }
}