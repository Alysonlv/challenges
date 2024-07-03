package corp.alv.challenges.general.arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters task = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void lengthOfLongestSubstring() {
        String s = "abcabcbb";
        int expected = 3;
        assertEquals(expected, task.lengthOfLongestSubstring(s));

        assertEquals(3, task.lengthOfLongestSubstring("pwwkew"));

        assertEquals(3, task.lengthOfLongestSubstring("dvdf"));
    }
}