package corp.alv.challenges.general.graphs.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAreaOfIslandTest {

    @Test
    void maxAreaOfIsland() {
        MaxAreaOfIsland t = new MaxAreaOfIsland();
        int[][] grid = null;
        //Input: grid = [[],[],[],[],[],[],[],[]]
        grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        assertEquals(6, t.maxAreaOfIsland(grid));

        grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        assertEquals(0, t.maxAreaOfIsland(grid));
    }
}