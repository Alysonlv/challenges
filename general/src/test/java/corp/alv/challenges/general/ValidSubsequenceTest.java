package corp.alv.challenges.general;

import corp.alv.challenges.general.arrays.ValidSubsequence;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidSubsequenceTest {

    @Test
    void isValidSubsequence() {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        assertTrue(ValidSubsequence.isValidSubsequence(array, sequence));

        array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        sequence = Arrays.asList(1, 6, -1, -1, 10);
        assertFalse(ValidSubsequence.isValidSubsequence(array, sequence));
    }
}
