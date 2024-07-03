package corp.alv.challenges.general.hashmap;

import corp.alv.challenges.general.hashmap.easy.SortCharactersByFrequency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortCharactersByFrequencyTest {

    @Test
    void frequencySort() {
        SortCharactersByFrequency task = new SortCharactersByFrequency();

        String input = "tree";
        String output = "eert";
        assertEquals(output, task.frequencySort(input));
        assertEquals(output, task.frequencySort_Better(input));

        input = "cccaaa";
        output = "aaaccc";
        assertEquals(output, task.frequencySort(input));
        assertEquals(output, task.frequencySort_Better(input));

        input = "Aabb";
        output = "bbAa";
        assertEquals(output, task.frequencySort(input));
        assertEquals(output, task.frequencySort_Better(input));
    }
}