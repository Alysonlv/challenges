package corp.alv.challenges.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    Let's say you are trying to install certain packages for a product
    and each package needs its dependencies installed beforehand.
    Given a JSON as follows, lets assume there are 3 packages"

    {
        "a": ["b"],
        "b": [],
        "c": ["a","b"]
    }

    In this case, package "a" depends on "b" i.e. package "b" must be installend before package "a".
    Subsequently, package "b" does not need any other packages pre-installed, and package "c" needs
    pacakges "a" and "b".
    Determine the order of package to be installed. In the example above, the expected output would be: ["b","a","c"]

 */
public class InstallPackagesInOrderOfDependencies {

    public static List<Character> installDependencies(Map<Character, HashSet<Character>> dependencyTree) {
        // Track installed dependencies
        Set<Character> installed = new HashSet<>();

        // Topological sort using DFS (Depth-First Search)
        List<Character> sortedDependencies = new ArrayList<>();
        for (Character root : dependencyTree.keySet()) {
            if (!installed.contains(root)) {
                dfs(dependencyTree, root, installed, sortedDependencies);
            }
        }

        // Return the sorted list of dependencies
        return sortedDependencies;
    }

    private static void dfs(Map<Character, HashSet<Character>> dependencyTree,
                            Character node,
                            Set<Character> installed,
                            List<Character> sortedDependencies) {
        // Mark the current node as installed
        installed.add(node);

        // Recursively explore dependencies
        for (Character dependency : dependencyTree.getOrDefault(node, new HashSet<>())) {
            if (!installed.contains(dependency)) {
                dfs(dependencyTree, dependency, installed, sortedDependencies);
            }
        }

        // Add the current node to the sorted list after exploring dependencies
        sortedDependencies.add(node);
    }

    public static void main(String[] args) {
        Map<Character, HashSet<Character>> dependencyTree = new HashMap<>();

/*
{
    "d": [],
    "a": ["b"],
    "e": ["a","b", "c"],
    "b": [],
    "c": ["a","b"]
}
 */

        HashSet<Character> dependencies = new HashSet<>();
        dependencies.add('a');
        dependencies.add('b');
        dependencies.add('c');
        dependencies.add('d');
        dependencyTree.put('E', dependencies);

        dependencies = new HashSet<>();
        dependencies.add('a');
        dependencies.add('b');
        dependencyTree.put('c', dependencies);

        dependencies = new HashSet<>();
        dependencies.add('b');
        dependencyTree.put('a', dependencies);

        dependencyTree.put('b', new HashSet<>());
        dependencyTree.put('d', new HashSet<>());

        List<Character> res = InstallPackagesInOrderOfDependencies.installDependencies(dependencyTree);
        System.out.println(res);
    }
}
