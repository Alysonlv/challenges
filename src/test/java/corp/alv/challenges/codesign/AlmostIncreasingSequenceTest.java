package corp.alv.challenges.codesign;

import corp.alv.challenges.codesign.edgeoftheoceon.AlmostIncreasingSequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlmostIncreasingSequenceTest {

    @Test
    void almostIncreasingSequence() {
        assertFalse(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{1, 3, 2, 1}));
        assertTrue(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{1, 3, 2}));
        assertFalse(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{1, 2, 1, 2}));
        assertFalse(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{3, 6, 5, 8, 10, 20, 15}));
        assertFalse(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{1, 1, 2, 3, 4, 4}));
        assertFalse(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{1, 4, 10, 4, 2}));
        assertTrue(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{10, 1, 2, 3, 4, 5}));
        assertFalse(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{1, 1, 1, 2, 3}));
        assertTrue(AlmostIncreasingSequence.almostIncreasingSequence(new int[]{0, -2, 5, 6}));
    }
}