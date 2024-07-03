package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    private MoveZeroes task = new MoveZeroes();
    @Test
    void moveZeroes() {
        int[] arr = new int[] {0,1,0,3,12};
        task.moveZeroes(arr);
        assertArrayEquals(new int[] {1,3,12,0,0}, arr);

        arr = new int[] {1,0,1};
        task.moveZeroes(arr);
        assertArrayEquals(new int[] {1,1,0}, arr);

        arr = new int[] {4,2,4,0,0,3,0,5,1,0};
        task.moveZeroes(arr);
        assertArrayEquals(new int[] {4,2,4,3,5,1,0,0,0,0}, arr);

        arr = new int[] {45192,0,-659,-52359,-99225,-75991,0,-15155,27382,59818,0,-30645,-17025,81209,887,64648};
        task.moveZeroes(arr);
        assertArrayEquals(new int[] {45192,-659,-52359,-99225,-75991,-15155,27382,59818,-30645,-17025,81209,887,64648,0,0,0}, arr);
    }
}