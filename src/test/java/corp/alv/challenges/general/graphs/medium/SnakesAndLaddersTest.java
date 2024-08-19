package corp.alv.challenges.general.graphs.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakesAndLaddersTest {

    private SnakesAndLadders t = new SnakesAndLadders();

    @Test
    void snakesAndLadders_Case01() {
        int[][] board = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        assertEquals(4, t.snakesAndLadders(board));
    }

    @Test
    void snakesAndLadders_Case02() {
        int[][] board = new int[][]{
                {-1, -1},
                {-1, 3}
        };
        assertEquals(1, t.snakesAndLadders(board));
    }
}