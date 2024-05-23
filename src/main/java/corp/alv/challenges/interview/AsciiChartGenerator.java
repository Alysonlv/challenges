package corp.alv.challenges.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsciiChartGenerator {

    public static void generateAsciiChart(List<int[]> data, int maxX, int maxY) {
        char[][] chart = new char[maxY + 3][maxX + 3];  // Create a matrix for the chart

        // Initialize chart with spaces
        for (char[] row : chart) {
            Arrays.fill(row, '.');
        }

        // Place the data points on the chart
        for (int[] point : data) {
            int x = point[0];
            int y = point[1];
            chart[maxY - y + 1][x + 1] = '*';
        }

        // Print the chart
        for (int i = 0; i < maxY + 3; i++) {
            StringBuilder row = new StringBuilder();
            for (char c : chart[i]) {
                row.append(c);
            }
            System.out.println(row.toString());
        }
        System.out.println("\n   max x = " + maxX);
        System.out.println("   max y = " + maxY);
    }

    public static void main(String[] args) {
        List<int[]> data = new ArrayList<>();
        data.add(new int[]{1, 2});
        data.add(new int[]{2, 3});
        data.add(new int[]{3, 1});
        data.add(new int[]{4, 6});
        data.add(new int[]{5, 8});
        int maxX = 5;
        int maxY = 8;
        generateAsciiChart(data, maxX, maxY);
        int[][] graph = new int[][] {{1, 2}};
    }
}
