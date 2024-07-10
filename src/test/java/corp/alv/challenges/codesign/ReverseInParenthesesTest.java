package corp.alv.challenges.codesign;

import corp.alv.challenges.codesign.smothsailing.ReverseInParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseInParenthesesTest {

    @Test
    void solution() {
//        assertEquals("foobazrabblim", ReverseInParentheses.solution("foo(bar(baz))blim"));

        //   za
        //oibazrab
//        assertEquals("foooibazrabblim", ReverseInParentheses.solution("foo(bar(baz)io)blim"));
        assertEquals("rab", ReverseInParentheses.solution("(bar)"));
    }
}