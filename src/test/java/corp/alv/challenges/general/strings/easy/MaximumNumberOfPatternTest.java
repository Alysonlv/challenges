package corp.alv.challenges.general.strings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfPatternTest {

    private MaximumNumberOfPattern task = new MaximumNumberOfPattern();

    @Test
    void maxNumberOfBallons() {
        String text = "nlaebolko";
        assertEquals(1, task.maxNumberOfBalloons(text));

        text = "loonbalxballpoon";
        assertEquals(2, task.maxNumberOfBalloons(text));

        text = "leetcode";
        assertEquals(0, task.maxNumberOfBalloons(text));
    }

    @Test
    void maxNumberOfPattern() {
        String pattern = "corinthians";
        String text = "acoaorojsgoicorinthiansiansiansians";
        assertEquals(1, task.maxNumberOfPattern(text, pattern));

        pattern = "stark";
        text = "qazwsxedcrfvtgbyhnujmikolp";
        assertEquals(1, task.maxNumberOfPattern(text, pattern));

        text = "leetcode";
        assertEquals(0, task.maxNumberOfPattern(text, pattern));

        pattern = "stark";
        text = "starkstarkstarkstark";
        assertEquals(4, task.maxNumberOfPattern(text, pattern));
        pattern = "stark";
        text = "starkstarkstarkstarkstar";
        assertEquals(4, task.maxNumberOfPattern(text, pattern));
    }
}