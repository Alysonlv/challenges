package corp.alv.challenges.general.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Equal Row and Column Pairs
Medium
Topics
Companies
Hint
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).



Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]


Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105
 */
public class EqualsRowsAndColumnPairs {

    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        // Add up the frequency of each column in map.
        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
    public int equalPairs_Best(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        int[][] transpose = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int y = 0; y < n; y++) {
                transpose[i][y] = grid[y][i];
            }
        }
        for (int[] row : grid) {
            for (int[] column : transpose) {
                if (Arrays.equals(row, column)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EqualsRowsAndColumnPairs task = new EqualsRowsAndColumnPairs();

        int[][] matrix = new int[][] {{3,2,1}, {1,7,6},{2,7,7}};
        System.out.println(task.equalPairs(matrix));

        matrix = new int[][] {{13,13}, {13,13}};
        System.out.println(task.equalPairs(matrix));
    }
}
