package corp.alv.challenges.general.graphs.medium;
/*
399. Evaluate Division
Medium
Topics
Companies
Hint
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.



Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]


Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivisionAsGraph {

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        // Step 1). build the graph from the equations
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];

            if (!graph.containsKey(dividend))
                graph.put(dividend, new HashMap<>());
            if (!graph.containsKey(divisor))
                graph.put(divisor, new HashMap<>());

            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        // Step 2). Evaluate each query via bactracking (DFS)
        // by verifying if there exists a path from dividend to divisor
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            } else if (dividend == divisor) {
                results[i] = 1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                results[i] = backtrackEvaluate(graph, dividend, divisor, 1, visited);
            }
        }

        return results;
    }

    private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph,
                                     String currNode,
                                     String targetNode,
                                     double accProduct,
                                     Set<String> visited) {

        // mark the visit
        visited.add(currNode);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(currNode);
        if (neighbors.containsKey(targetNode)) {
            ret = accProduct * neighbors.get(targetNode);
        } else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode)) {
                    continue;
                }
                ret = backtrackEvaluate(graph, nextNode, targetNode,
                        accProduct * pair.getValue(), visited);
                if (ret != -1.0) {
                    break;
                }
            }
        }

        // unmark the visit, for the next backtracking
        visited.remove(currNode);
        return ret;
    }

    public double[] calcEquation_02(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Set<WeightedNode>> edges = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            edges.computeIfAbsent(equation.get(0), k -> new HashSet<>())
                    .add(new WeightedNode(values[i], equation.get(1)));

            edges.computeIfAbsent(equation.get(1), k -> new HashSet<>())
                    .add(new WeightedNode(1 / values[i], equation.get(0)));
        }

        double[] result = new double[queries.size()];
        Arrays.fill(result, -1.0d);

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            Set<String> seen = new HashSet<>();

            if (!edges.containsKey(dividend) || !edges.containsKey(divisor)) {
                result[i] = -1d;
                continue;
            }

            if (dividend.equals(divisor)) {
                result[i] = 1d;
                continue;
            }

            Deque<WeightedNode> queue = new LinkedList<>();
            for (WeightedNode wn : edges.get(dividend)) {
                queue.addFirst(wn);
            }

            while (!queue.isEmpty()) {
                seen.add(dividend);
                WeightedNode wn = queue.removeLast();
                if (wn.node.equals(divisor)) {
                    result[i] = wn.factor;
                    break;
                }

                for (WeightedNode edg : edges.get(wn.node)) {
                    if (!edg.node.equals(dividend) && !seen.contains(edg.node)) {
                        queue.addFirst(new WeightedNode(wn.factor * edg.factor, edg.node));
                    }
                    seen.add(wn.node);
                }

            }

        }

        return result;
    }

    private class WeightedNode {
        private double factor;
        private String node;

        public WeightedNode(double factor, String node) {
            this.factor = factor;
            this.node = node;
        }
    }
}
