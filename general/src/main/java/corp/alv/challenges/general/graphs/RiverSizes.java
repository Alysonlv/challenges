package corp.alv.challenges.general.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * You're given a matrix (two dimensional array) of potential unequal height and width containing only 0s and 1s.
 * Eah 0 represent land and each 1 represent part of a river. A river consists of any number of 1s that are either
 *  horizontally or vertically adjacent (not diagonally). The number of adjacent 1s forming a river determine its size.
 *
 * @author @AlgoExpert Solution https://www.algoexpert.io/ (with a minor change)
 */
public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        //Iterate each node of our matrix and check the surroundings nodes
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (visited[y][x]) {
                    continue;
                }

                traverseNode(y, x, matrix, visited, sizes);
            }
        }

        return sizes;
    }

    private static void traverseNode(int y, int x, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;

        /*
         * Stack is a linear LIFO (Last-In-First-Out) collection, so we can quickly get the next node to explore
         * Starting with [0,0], every node will be added to the stack and removed in the right time
         */
        Stack<Integer[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new Integer[] {y, x});

        //Will start with just one node
        while (!nodesToExplore.empty()) {
            Integer[] currentNode = nodesToExplore.pop();
            y = currentNode[0];
            x = currentNode[1];

            if (visited[y][x]) {
                continue;
            }

            //At this moment we add the current node to the viseted matrix so we don't have to process it anymore (previous condition)
            visited[y][x] = true;

            //If it a 0, we skip
            if (matrix[y][x] == 0) {
                continue;
            }

            //At this point we have a 1 so we increase our river size
            currentRiverSize++;

            //Now we get ready to explore the surrounding nodes.
            List<Integer[]> unvisitedNodes = getUnvisitedNodes(y, x, matrix, visited);
            //Feed the nodesToExplore stack with the surroundings (unvisited) nodes of the current one
            nodesToExplore.addAll(unvisitedNodes);
        }

        if (currentRiverSize > 0) {
            sizes.add(currentRiverSize);
        }
    }

    /**
     *
     * It will look to all directions looking for nodes that weren't visited and are adjacent of the current
     *
     * @param y the current depth (the y on the matrix)
     * @param x the current breadth (the x on the matrix)
     * @param matrix the complete matrix
     * @param visited which nodes we have visited before
     * @return the unvisited nodes
     */
    private static List<Integer[]> getUnvisitedNodes(int y, int x, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNodes = new ArrayList<>();

        /*
         * Check the limits - up, down, left and right - and the already visited nodes
         */

        //If y is greater than 0 means we have to look up as well, we are not at the first row
        if (y > 0 && !visited[y -1][x]) {
            unvisitedNodes.add(new Integer[]{y -1, x});
        }

        //If y is lesser than matrix.length means we have to look down as well, we are not at the bottom
        if (y < matrix.length - 1 && !visited[y + 1][x]) {
            unvisitedNodes.add(new Integer[]{y + 1, x});
        }

        //If x greater than 0 means we should look to the left, we are not at the start of the row
        if (x > 0 && !visited[y][x - 1]) {
            unvisitedNodes.add(new Integer[]{y, x -1});
        }

        //If x lesser than the row length means we should look to the right, we are not at the end of the row
        if (x < matrix[0].length - 1 && !visited[y][x +1]) {
            unvisitedNodes.add(new Integer[]{y, x + 1});
        }

        return unvisitedNodes;
    }

}
