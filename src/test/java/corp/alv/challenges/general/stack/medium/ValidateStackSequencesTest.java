package corp.alv.challenges.general.stack.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateStackSequencesTest {

    @Test
    void validateStackSequences() {
        ValidateStackSequences t = new ValidateStackSequences();
        int[] pushed;
        int[] popped;
        //Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]

        pushed = new int[]{1, 2, 3, 4, 5};
        popped = new int[]{4, 5, 3, 2, 1};
        assertTrue(t.validateStackSequences(pushed, popped));

        pushed = new int[]{1, 2, 3, 4, 5};
        popped = new int[]{4, 3, 5, 1, 2};
        assertFalse(t.validateStackSequences(pushed, popped));

        pushed = new int[]{0, 2, 1};
        popped = new int[]{0, 1, 2};
        assertTrue(t.validateStackSequences(pushed, popped));
    }
}