package corp.alv.challenges.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SherlockAndArrayTest {


    @Test
    void balancedSums() {
        List<Integer> arr = Arrays.asList(5, 6, 8, 11);
        assertEquals("YES", SherlockAndArray.balancedSums(arr));

        arr = Arrays.asList(1, 2, 3);
        assertEquals("NO", SherlockAndArray.balancedSums(arr));

        arr = Arrays.asList(1, 1, 4, 1, 1);
        assertEquals("YES", SherlockAndArray.balancedSums(arr));

        arr = Arrays.asList(2, 0, 0, 0);
        assertEquals("YES", SherlockAndArray.balancedSums(arr));

        arr = Arrays.asList(0, 0, 2, 0);
        assertEquals("YES", SherlockAndArray.balancedSums(arr));
    }
}