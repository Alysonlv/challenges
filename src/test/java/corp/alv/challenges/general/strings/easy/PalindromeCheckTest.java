package corp.alv.challenges.general.strings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckTest {

    @Test
    void isPalindrome() {
        assertTrue(PalindromeCheck.isPalindrome("abcdefggfedcba"));
        assertFalse(PalindromeCheck.isPalindrome("abcdefgghedcba"));
    }
}