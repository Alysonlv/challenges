package corp.alv.challenges.general.strings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePrefixOfWordTest {

    ReversePrefixOfWord task = new ReversePrefixOfWord();

    @Test
    void reversePrefix() {
        String input = "abcdefd";
        char ch = 'd';
        String output = "dcbaefd";
        assertEquals(output, task.reversePrefix(input, ch));

        input = "xyxzxe";
        ch = 'z';
        output = "zxyxxe";
        assertEquals(output, task.reversePrefix(input, ch));

        input = "abcd";
        ch = 'z';
        output = "abcd";
        assertEquals(output, task.reversePrefix(input, ch));
    }
}