package corp.alv.challenges.general.graphs.medium;

import corp.alv.challenges.domain.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Snakes and Ladders
Medium
Topics
Companies
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.



Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation:
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1


Constraints:

n == board.length == board[i].length
2 <= n <= 20
board[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 do not have any ladders or snakes.
 */
public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].getKey(), column = cells[next].getValue();
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }

    public int snakesAndLadders2(int[][] board) {
        int n = board.length;
        int col = 0;
        int row = n - 1;
        int label = 1;
        int x = 1;
        Map<Integer, int[]> coordinates = new HashMap<>();

        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];

        for (int i = 1; i <= n * n; i++) {
            coordinates.put(label, new int[]{row, col});
            col++;
            label += x;

            if (col == n) {
                label = label + n - x;
                col = 0;
                row--;
                x *= -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n - 1, 0, 1});
        int output = -1;

        while (!queue.isEmpty()) {
            int[] currCoordinate = queue.poll();
            int currentValue = board[currCoordinate[0]][currCoordinate[1]];
            int boardValue = currCoordinate[2];

            // if it is not a snake or ladder (aka not -1) jumps to the label, getting its coordinate (x,y) on the map
            if (currentValue != -1) {
                int[] c = coordinates.get(currentValue);
                queue.add(new int[]{c[0], c[1], currentValue});
            } else {
                // run for every other in the range until
                int[] range = defineRange(n, boardValue);
                for (int i = range[0]; i <= range[1]; i++) {
                    int[] nextCoordinate = coordinates.get(i);

                    output++;
                    if (nextCoordinate[0] == 0 && nextCoordinate[1] == 0) {
                        return output;
                    }

                    int nextValue = board[nextCoordinate[0]][nextCoordinate[1]];
                    if (nextValue != -1) {
                        int[] c = coordinates.get(nextValue);
                        queue.add(new int[]{c[0], c[1], nextValue});
                        break;
                    }
                }
            }
        }

        return -1;
    }

    private static int[] defineRange(int n, int curr) {
        return new int[]{curr + 1, Math.min(curr + 6, n * n)};
    }
}
