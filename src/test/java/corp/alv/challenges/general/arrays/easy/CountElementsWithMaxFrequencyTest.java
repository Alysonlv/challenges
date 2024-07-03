package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountElementsWithMaxFrequencyTest {

    @Test
    void maxFrequencyElements() {
        CountElementsWithMaxFrequency task = new CountElementsWithMaxFrequency();

        int[] nums = new int[] {1,2,2,3,1,4};
        assertEquals(4, task.maxFrequencyElements(nums));
    }
}