package corp.alv.challenges.general.stack.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSubarrayRangesTest {

    @Test
    void subArrayRanges() {
        SumOfSubarrayRanges t = new SumOfSubarrayRanges();

        assertEquals(4, t.subArrayRanges(new int[]{1, 2, 3}));
        assertEquals(4, t.subArrayRanges(new int[]{1, 3, 3}));
        assertEquals(59, t.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }
}