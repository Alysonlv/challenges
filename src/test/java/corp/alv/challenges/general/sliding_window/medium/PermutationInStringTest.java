package corp.alv.challenges.general.sliding_window.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void checkInclusion() {
        PermutationInString task = new PermutationInString();

        String s1;
        String s2;

        s1 = "ab";
        s2 = "eidbaooo";
        assertTrue(task.checkInclusion(s1, s2));

        s1 = "ab";
        s2 = "eidboaoo";
        assertFalse(task.checkInclusion(s1, s2));

        s1 = "ab";
        s2 = "eidbcxoba";
        assertTrue(task.checkInclusion_B(s1, s2));
    }
}