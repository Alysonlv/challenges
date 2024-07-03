package corp.alv.challenges.general.hashmap.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubarrayWithAtMostKFrequencyTest {

    @Test
    void maxSubarrayLength() {
        LengthOfLongestSubarrayWithAtMostKFrequency task = new LengthOfLongestSubarrayWithAtMostKFrequency();

        int[] arr = new int[] {1,2,3,1,2,3,1,2};
        int k = 2;
        assertEquals(6, task.maxSubarrayLength(arr, k));

        arr = new int[] {1,2,3,1,2,3,8,8,8};
        k = 2;
        assertEquals(8, task.maxSubarrayLength(arr, k));

        arr = new int[] {1,2,1,2,1,2,1,2};
        k = 1;
        assertEquals(2, task.maxSubarrayLength(arr, k));

        arr = new int[] {5,5,5,5,5,5,5};
        k = 4;
        assertEquals(4, task.maxSubarrayLength(arr, k));
    }
}