package corp.alv.challenges.general.graphs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
1293. Shortest Path in a Grid with Obstacles Elimination
Hard
Topics
Companies
Hint
You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.



Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation:
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0
 */
public class ShortestPathInAGridWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        final int lastRow = rows - 1;
        final int lastCol = cols - 1;

        // Manhattan Optimization
        if (k >= rows + cols - 2) return rows + cols - 2;

        // Use BFS
        final Queue<int[]> queue = new LinkedList<>();

        // init case
        queue.offer(new int[]{0, 0, k});

        // for checking visited with highest k so far
        final Integer[][] maxK = new Integer[rows][cols];

        for (int steps = 0; !queue.isEmpty(); steps++) {
            for (int i = 0, n = queue.size(); i < n; i++) {

                final int[] curr = queue.poll();
                final int currRow = curr[0];
                final int currCol = curr[1];
                final int currK = curr[2];

                // return first found value
                if (currRow == lastRow && currCol == lastCol) return steps;

                // add right
                if (currCol < lastCol) {
                    final int newRow = currRow;
                    final int newCol = currCol + 1;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[]{newRow, newCol, newK});
                        maxK[newRow][newCol] = newK;
                    }
                }

                // add down
                if (currRow < lastRow) {
                    final int newRow = currRow + 1;
                    final int newCol = currCol;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[]{newRow, newCol, newK});
                        maxK[newRow][newCol] = newK;
                    }
                }

                // add left
                if (currCol > 0) {
                    final int newRow = currRow;
                    final int newCol = currCol - 1;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[]{newRow, newCol, newK});
                        maxK[newRow][newCol] = newK;
                    }
                }

                // add up
                if (currRow > 0) {
                    final int newRow = currRow - 1;
                    final int newCol = currCol;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[]{newRow, newCol, newK});
                        maxK[newRow][newCol] = newK;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInAGridWithObstaclesElimination t = new ShortestPathInAGridWithObstaclesElimination();
        int[][] grid = null;

        grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        System.out.println("6 = " + t.shortestPath(grid, 1));

        grid = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}};
        System.out.println("-1 = " + t.shortestPath(grid, 1));
    }
}
