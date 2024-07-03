package corp.alv.challenges.general.hashmap.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySubarraysWithSumTest {

    @Test
    void numSubarraysWithSum() {
        BinarySubarraysWithSum task = new BinarySubarraysWithSum();
        int[] arr;
        int goal;
        int expected;

        arr = new int[]{1, 0, 1, 0, 1};
        goal = 2;
        expected = 4;
        assertEquals(expected, task.numSubarraysWithSum(arr, goal));

        arr = new int[]{0, 0, 0, 0, 0};
        goal = 0;
        expected = 15;
        assertEquals(expected, task.numSubarraysWithSum(arr, goal));

    }
}