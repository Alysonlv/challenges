package corp.alv.challenges.general.graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
542. 01 Matrix
Medium
Topics
Companies
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 */
public class FindNearestZeroForEachCellOnMatrix {
    int rows;
    int cols;

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        Queue<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new State(row, col, 1));
                    seen[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (valid(nextRow, nextCol, mat) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                    mat[nextRow][nextCol] = steps;
                }
            }
        }

        return mat;
    }

    public boolean valid(int row, int col, int[][] mat) {
        return 0 <= row && row < rows && 0 <= col && col < cols && mat[row][col] == 1;
    }

    private class State {
        int row;
        int col;
        int steps;

        State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        FindNearestZeroForEachCellOnMatrix t = new FindNearestZeroForEachCellOnMatrix();
        int[][] mat = null;

        mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        System.out.println(t.updateMatrix(mat));

        mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(t.updateMatrix(mat));
    }
}
