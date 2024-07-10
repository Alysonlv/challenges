package corp.alv.challenges.general;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HackerRank {

    public static String gridChallenge(List<String> grid) {
        List<char[]> matrix = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            char[] c = grid.get(i).toCharArray();
            Arrays.sort(c);
            matrix.add(c);
        }

        int colSize = matrix.size();
        int rowSize = matrix.get(0).length;

        char[] row = matrix.get(0);

        for (int r = 0; r < rowSize; r++) {
            char first = row[r];

            for (int c = 1; c < colSize; c++) {
                char curr = matrix.get(c)[r];
                if (first > curr) {
                    return "NO";
                }
            }
        }

        return "YES";

    }

    public static void main(String[] args) {
        System.out.println(HackerRank.gridChallenge(Arrays.asList("mpxz", "abcd", "wlmf")));
        LinkedList<Integer> l = null;

        ArrayDeque<Integer> d = null;
        d.descendingIterator();
    }
}
