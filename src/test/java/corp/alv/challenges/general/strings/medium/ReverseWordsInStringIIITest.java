package corp.alv.challenges.general.strings.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInStringIIITest {

    private ReverseWordsInStringIII task = new ReverseWordsInStringIII();

    @Test
    void reverseWords() {
        /*
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"
         */

        String s = "Let's take LeetCode contest";
        assertEquals("s'teL ekat edoCteeL tsetnoc", task.reverseWords(s));

        s = "Mr Ding";
        assertEquals("rM gniD", task.reverseWords(s));

        s = "I love u";
        assertEquals("I evol u", task.reverseWords(s));
    }
}