package corp.alv.challenges.general.arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSubarrayMinimumsTest {

    @Test
    void sumSubarrayMins() {
        //Index of the minimum - left boundary * right boundary - Index of the minimum
        SumOfSubarrayMinimums t = new SumOfSubarrayMinimums();
        assertEquals(17, t.sumSubarrayMins(new int[]{3, 1, 2, 4}));
        assertEquals(444, t.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
    }
}