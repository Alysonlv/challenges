package corp.alv.challenges.general.binarytrees.search.medium;

import corp.alv.challenges.general.domains.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *   The pre-order traversal of a Binary Tree is a traversal technique that starts
 *   at the tree's root node and visits nodes in the following order:
 *
 *   Current node
 *   Left subtree
 *   Right subtree
 * 
 * 
 *   Given a non-empty array of integers representing the pre-order traversal of a
 *   Binary Search Tree (BST), write a function that creates the relevant BST and
 *   returns its root node.
 * 
 * 
 *   The input array will contain the values of BST nodes in the order in which
 *   these nodes would be visited with a pre-order traversal.
 * 
 * 
 *   Each BST node has an integer value, a
 *   left child node, and a right child node. A node is
 *   said to be a valid BST node if and only if it satisfies the BST
 *   property: its value is strictly greater than the values of every
 *   node to its left; its value is less than or equal to the values
 *   of every node to its right; and its children nodes are either valid
 *   BST nodes themselves or None / null.
 * 
 * Sample Input
 * preOrderTraversalValues = [10, 4, 2, 1, 5, 17, 19, 18]
 * 
 * Sample Output
 *         10 
 *       /    \
 *      4      17
 *    /   \      \
 *   2     5     19
 *  /           /
 * 1           18 
 * 
 * 
 */
public class ReconstructBST {

    private static class TreeInfo {
        public int rootIdx;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBSTFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    private BST reconstructBSTFromRange(int lower, int upper, List<Integer> preOrderTraversalValues, TreeInfo currentSubtreeInfo) {
        if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
            return null;
        }

        int rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);
        if (rootValue < lower || rootValue >= upper) {
            return null;
        }

        currentSubtreeInfo.rootIdx += 1;
        BST leftSubtree = reconstructBSTFromRange(lower, rootValue, preOrderTraversalValues, currentSubtreeInfo);
        BST rightSubtree = reconstructBSTFromRange(rootValue, upper, preOrderTraversalValues, currentSubtreeInfo);

        BST node = new BST(rootValue);
        node.left = leftSubtree;
        node.right = rightSubtree;

        return node;
    }


    public BST reconstructBst2(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }

        int currentValue = preOrderTraversalValues.get(0);
        int rightSubtreeRootIdx = preOrderTraversalValues.size();

        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            int value = preOrderTraversalValues.get(i);

            if (value >= currentValue) {
                rightSubtreeRootIdx = i;
                break;
            }
        }

        BST leftNode = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
        BST rightNode = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size()));

        BST node = new BST(currentValue);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
