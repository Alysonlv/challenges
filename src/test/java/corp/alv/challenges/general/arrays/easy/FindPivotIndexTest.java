package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexTest {

    @Test
    void pivotIndex() {

        int[] arr = new int[] {1,7,3,6,5,6};
        int output = 3;
        assertEquals(output, FindPivotIndex.pivotIndex(arr));

        arr = new int[] {1,2,3};
        output = -1;
        assertEquals(output, FindPivotIndex.pivotIndex(arr));

        arr = new int[] {2,1,-1};
        output = 0;
        assertEquals(output, FindPivotIndex.pivotIndex(arr));

        arr = new int[] {-1,-1,0,1,1,0};
        output = 5;
        assertEquals(output, FindPivotIndex.pivotIndex(arr));

        arr = new int[] {1, 0};
        output = 0;
        assertEquals(output, FindPivotIndex.pivotIndex(arr));
    }
}