package corp.alv.challenges.general.arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPlayersWithZeroOrOneLossesTest {

    FindPlayersWithZeroOrOneLosses task = new FindPlayersWithZeroOrOneLosses();
    @Test
    void findWinners() {
        int[][] input = new int[][] {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};

        List<List<Integer>> result = task.findWinners(input);
//[[1,2,10],[4,5,7,8]]

        int[] winners = result.get(0).stream().mapToInt(i -> i).toArray();
        assertArrayEquals(new int[] {1,2,10}, winners);

        int[] losers = result.get(1).stream().mapToInt(i -> i).toArray();
        assertArrayEquals(new int[] {4,5,7,8}, losers);
    }
}