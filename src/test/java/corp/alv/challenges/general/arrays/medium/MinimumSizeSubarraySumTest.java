package corp.alv.challenges.general.arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSizeSubarraySumTest {

    private MinimumSizeSubarraySum task = new MinimumSizeSubarraySum();

    @Test
    void minSubArrayLen() {
        int[] arr = new int[] {2,3,1,2,4,3};
        int target = 7;
        int result = 2;
        assertEquals(result, task.minSubArrayLen(target, arr));

        arr = new int[] {1,4,4};
        target = 4;
        result = 1;
        assertEquals(result, task.minSubArrayLen(target, arr));

        arr = new int[] {1,1,1,1,1,1,1,1,1,1,};
        target = 11;
        result = 0;
        assertEquals(result, task.minSubArrayLen(target, arr));
    }
}