package corp.alv.challenges.general.strings.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    @Test
    void groupAnagrams01() {

        List<String> words = Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp");

        List<List<String>> list = GroupAnagrams.groupAnagrams01(words);
        assertEquals(4, list.size());
    }
}