package corp.alv.challenges.general.graphs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.

Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.

Note that node 0 will not be a restricted node.



Example 1:


Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
Output: 4
Explanation: The diagram above shows the tree.
We have that [0,1,2,3] are the only nodes that can be reached from node 0 without visiting a restricted node.
Example 2:


Input: n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
Output: 3
Explanation: The diagram above shows the tree.
We have that [0,5,6] are the only nodes that can be reached from node 0 without visiting a restricted node.


Constraints:

2 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges represents a valid tree.
1 <= restricted.length < n
1 <= restricted[i] < n
All the values of restricted are unique.
 */
public class ReachableNodesWithRestrictions {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //Store all edges in 'neighbors'.
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            neighbors.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            neighbors.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        // Mark the nodes in 'restricted' as visited.
        Set<Integer> seen = new HashSet<>();
        for (int node : restricted) {
            seen.add(node);
        }

        // Store all the nodes to be visited in 'queue'.
        int reachable = 0;
        seen.add(0);
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(0));

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            reachable++;

            // For all the neighbors of the current node, if we haven't visit it before,
            // add it to 'queue' and mark it as visited.
            for (int nextNode : neighbors.get(currNode)) {
                if (!seen.contains(nextNode)) {
                    seen.add(nextNode);
                    queue.offer(nextNode);
                }
            }
        }

        return reachable;
    }


    public static void main(String[] args) {
        ReachableNodesWithRestrictions t = new ReachableNodesWithRestrictions();

        int[][] edges = null;
        int[] restricted = null;

        edges = new int[][]{{8, 2}, {2, 5}, {5, 0}, {2, 7}, {1, 7}, {3, 8}, {0, 4}, {3, 9}, {1, 6}};
        restricted = new int[]{9, 8, 4, 5, 3, 1};
        System.out.println("1 = " + t.reachableNodes(10, edges, restricted));

        edges = new int[][]{{0, 1}};
        restricted = new int[]{1};
        System.out.println("1 = " + t.reachableNodes(2, edges, restricted));
    }
}
