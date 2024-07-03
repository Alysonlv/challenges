package corp.alv.challenges.general.arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfVowelsInSubstringOfGivenLengthTest {

    @Test
    void maxVowels() {
        String s = "abciiidef";
        int target = 3;
        int output = 3;
        assertEquals(output, MaximumNumberOfVowelsInSubstringOfGivenLength.maxVowels(s, target));

        s = "aeiou";
        target = 2;
        output = 2;
        assertEquals(output, MaximumNumberOfVowelsInSubstringOfGivenLength.maxVowels(s, target));

        s = "leetcode";
        target = 3;
        output = 2;
        assertEquals(output, MaximumNumberOfVowelsInSubstringOfGivenLength.maxVowels(s, target));
    }
}