package corp.alv.challenges.general.graphs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReorderRoutes {

    private int reorders = 0;

    private Set<Integer> seen;

    //[[0,1},{1,3},{2,3},{4,0},{4,5]]
    public int minReorder(int n, int[][] connections) {
        reorders = 0;
        // contains a list of pairs of integers such that adj[node] contains all the neighbors of node in the form of (neighbor, sign)
        // where neighbor is the neighboring node of node and sign denotes the direction of the edge i.e., whether its an "original" or "artificial" edge.
        Map<Integer, List<List<Integer>>> adjacency = new HashMap<>();

        for (int[] connection : connections) {
            adjacency.computeIfAbsent(connection[0], k -> new ArrayList<>())
                    .add(Arrays.asList(connection[1], 1));
            adjacency.computeIfAbsent(connection[1], k -> new ArrayList<>())
                    .add(Arrays.asList(connection[0], 0));
        }

        dfs(0, -1, adjacency);

        return reorders;
    }

    private void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if (!adj.containsKey(node)) {
            return;
        }

        for (List<Integer> nei : adj.get(node)) {
            int neighbor = nei.get(0);
            int sign = nei.get(1);

            if (neighbor != parent) {
                reorders += sign;
                dfs(neighbor, node, adj);
            }
        }
    }

    public static void main(String[] args) {
        ReorderRoutes rr = new ReorderRoutes();
        int[][] routes = null;

        //[[0,1},{1,3},{2,3},{4,0},{4,5]]
        routes = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(rr.minReorder(6, routes));

    }
}
