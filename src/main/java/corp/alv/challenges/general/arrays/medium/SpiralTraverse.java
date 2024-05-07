package corp.alv.challenges.general.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    private final static String R = "RIGHT";
    private final static String L = "LEFT";
    private final static String D = "DOWN";
    private final static String U = "UP";

    public static List<Integer> spiralTraverse(int[][] array) {
        if (array.length == 0) return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<>();
        spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, list);
        return list;
    }

    private static void spiralFill(int[][] array, int startRow, int endRow, int startCol, int endCol, List<Integer> list) {
        if (startRow > endRow || startCol > endCol)
            return;

        for (int col = startCol; col <= endCol; col++) {
            list.add(array[startRow][col]);
        }

        for (int row = startRow + 1; row <= endRow; row++) {
            list.add(array[row][endCol]);
        }

        for (int col = endCol - 1; col >= startCol; col--) {
            if (startRow == endRow)
                break;
            list.add(array[endRow][col]);
        }

        for (int row = endRow - 1; row >= startRow + 1; row--) {
            if (startCol == endCol)
                break;
            list.add(array[row][startCol]);
        }

        spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol -1, list);
    }

    public static List<Integer> spiralTraverse2(int[][] array) {
        int maxY = array.length;
        int maxX = array[0].length;
        int minY = 0, minX = 0;

        int yControl = 0;
        int xControl = 0;

        String direction = R;

        List<Integer> list = new ArrayList<Integer>();
        int control = 0;
        while (control < array.length * array[0].length) {
            list.add(array[yControl][xControl]);
            if (direction.equals(R)) {
                xControl++;

                if (xControl == maxX) {
                    direction = D;
                    xControl--;
                    maxX--;
                    yControl++;
                }
            } else if (direction.equals(D)) {
                yControl++;

                if (yControl == maxY) {
                    direction = L;
                    yControl--;
                    maxY--;
                    xControl--;
                }
            } else if (direction.equals(L)) {
                xControl--;

                if (xControl < minX) {
                    direction = U;
                    xControl++;
                    yControl--;
                    minX++;
                    minY++;
                }
            } else if (direction.equals(U)) {
                yControl--;

                if (yControl < minY) {
                    direction = R;
                    yControl++;
                    xControl++;
                }
            }

            control++;
        }

        return list;
    }

    public static void main(String... args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {12,13,14,5},{11,16,15,6}, {10,9,8,7}};

        spiralTraverse(matrix).forEach(item -> System.out.print(item + ", "));
    }



}
