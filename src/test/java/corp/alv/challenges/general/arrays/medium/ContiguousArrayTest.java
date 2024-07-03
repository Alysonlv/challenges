package corp.alv.challenges.general.arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContiguousArrayTest {

    private ContiguousArray task = new ContiguousArray();

    @Test
    void findMaxLength() {
        int[] arr = new int[] {0,1,0};
        int expected = 2;
        assertEquals(expected, task.findMaxLength(arr));
                       //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17
        arr = new int[] {0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1};
        expected = 16;//-1 -2 -3 -2 -3 -4 -5 -6 -5 -4 -3 -2 -1 -2 -3 -2 -3 -2
        assertEquals(expected, task.findMaxLength(arr));
    }

}