package corp.alv.challenges.general.binarytrees.dfs.search.medium;

import corp.alv.challenges.general.domains.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes in a Binary Search Tree (BST) and a positive
 * integer k and returns the kth largest integer contained in the
 * BST.
 * <p>
 * You can assume that there will only be integer values in the BST and that
 * k is less than or equal to the number of nodes in the tree.
 * <p>
 * Also, for the purpose of this question, duplicate integers will be treated as
 * distinct values. In other words, the second largest value in a BST containing
 * values {5, 7, 7} will be 7—not 5.
 * <p>
 * Each BST node has an integer value, a
 * left child node, and a right child node. A node is
 * said to be a valid BST node if and only if it satisfies the BST
 * property: its value is strictly greater than the values of every
 * node to its left; its value is less than or equal to the values
 * of every node to its right; and its children nodes are either valid
 * BST nodes themselves or None / null.
 * <p>
 * Sample Input
 * tree =   15
 * /     \
 * 5      20
 * /   \   /   \
 * 2     5 17   22
 * /   \
 * 1     3
 * k = 3
 * <p>
 * Sample Output
 * 17
 */
public class FindKthLargestValueInBST {

    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        return -1;
    }

    private int findKthLargestValueInBstSolution(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(tree, k, treeInfo);
        return treeInfo.latestVisitedNodeValue;
    }

    private void reverseInOrderTraverse(BST node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.numberOfNodesVisited >= k) {
            return;
        }

        reverseInOrderTraverse(node.right, k, treeInfo);
        if (treeInfo.numberOfNodesVisited < k) {
            treeInfo.numberOfNodesVisited += 1;
            treeInfo.latestVisitedNodeValue = node.value;
            reverseInOrderTraverse(node.left, k, treeInfo);
        }
    }

    private int findKthLargestValueInBstSolution2(BST tree, int k) {
        List<Integer> list = decreasingTraverse(tree, new ArrayList<>(), k);
        return list.get(k - 1);
    }

    private static List<Integer> decreasingTraverse(BST tree, List<Integer> array, int k) {
        if (array.size() == k) {
            return array;
        }
        if (tree.right != null) {
            decreasingTraverse(tree.right, array, k);
        }
        array.add(tree.value);
        if (tree.left != null) {
            decreasingTraverse(tree.left, array, k);
        }

        return array;
    }

    static class TreeInfo {
        public int numberOfNodesVisited;
        public int latestVisitedNodeValue;

        public TreeInfo(int numberOfNodesVisited, int latestVisitedNodeValue) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.latestVisitedNodeValue = latestVisitedNodeValue;
        }
    }
}
