package corp.alv.challenges.general.graphs.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NearestExitFromEntranceInMazeTest {

    private NearestExitFromEntranceInMaze t;

    @BeforeEach
    void setUp() {
        t = new NearestExitFromEntranceInMaze();
    }

    @Test
    void nearestExit_Case001() {
        char[][] maze;
        int[] entrance;

        maze = new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        entrance = new int[]{1, 2};
        assertEquals(1, t.nearestExit(maze, entrance));
    }

    @Test
    void nearestExit_Case002() {
        char[][] maze;
        int[] entrance;

        maze = new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        entrance = new int[]{1, 0};
        assertEquals(2, t.nearestExit(maze, entrance));
    }

    @Test
    void nearestExit_Case003() {
        char[][] maze;
        int[] entrance;

        maze = new char[][]{{'.', '+'}};
        entrance = new int[]{0, 0};
        assertEquals(-1, t.nearestExit(maze, entrance));
    }

    @Test
    void nearestExit_Case004() {
        char[][] maze;
        int[] entrance;

        maze = new char[][]{{'.', '.'}};
        entrance = new int[]{0, 1};
        assertEquals(1, t.nearestExit(maze, entrance));
    }
}