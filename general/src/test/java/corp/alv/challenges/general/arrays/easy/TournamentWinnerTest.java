package corp.alv.challenges.general.arrays.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentWinnerTest {

    @Test
    void solution() {
        List<List<String>> competitions = new ArrayList<>();
        competitions.add(Arrays.asList("HTML", "C"));
        competitions.add(Arrays.asList("C", "PYTHON"));
        competitions.add(Arrays.asList("PYTHON", "HTML"));
        List<Integer> results = Arrays.asList(0, 0, 1);

        assertEquals("PYTHON", TournamentWinner.solution(competitions, results));
        assertEquals("PYTHON", TournamentWinner.solution2(competitions, results));
    }
}