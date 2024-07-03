package corp.alv.challenges.general.strings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseOnlyLettersTest {

    private ReverseOnlyLetters task = new ReverseOnlyLetters();

    @Test
    void reverseOnlyLetters() {
/*
Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */

        String input = "ab-cd";
        String output = "dc-ba";
        assertEquals(output, task.reverseOnlyLetters(input));

        input = "a-bC-dEf-ghIj";
        output = "j-Ih-gfE-dCba";
        assertEquals(output, task.reverseOnlyLetters(input));

        input = "Test1ng-Leet=code-Q!";
        output = "Qedo1ct-eeLg=ntse-T!";
        assertEquals(output, task.reverseOnlyLetters(input));
    }

}