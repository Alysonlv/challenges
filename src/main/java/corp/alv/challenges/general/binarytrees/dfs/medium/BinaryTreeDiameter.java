package corp.alv.challenges.general.binarytrees.dfs.medium;

import corp.alv.challenges.domain.TreeNode;

/**
 * Write a function that takes in a Binary Tree and returns its diameter. The
 * diameter of a binary tree is defined as the length of its longest path, even
 * if that path doesn't pass through the root of the tree.
 * <p>
 * <p>
 * A path is a collection of connected nodes in a tree, where no node is
 * connected to more than two other nodes. The length of a path is the number of
 * edges between the path's first node and its last node.
 * <p>
 * <p>
 * Each BinaryTree node has an integer value, a
 * left child node, and a right child node. Children
 * nodes can either be BinaryTree nodes themselves or
 * None / null.
 * <p>
 * Sample Input
 * tree =        1
 * /   \
 * 3     2
 * /   \
 * 7     4
 * /       \
 * 8         5
 * /           \
 * 9             6
 * <p>
 * Sample Output
 * 6 // 9 ->; 8 ->; 7 ->; 3 ->; 4 ->; 5 ->; 6
 * // There are 6 edges between the
 * // first node and the last node
 * // of this tree's longest path.
 */
public class BinaryTreeDiameter {

    public int binaryTreeDiameter(TreeNode tree) {
        // Write your code here.
        return getTreeInfo(tree).diameter;
    }

    private TreeInfo getTreeInfo(TreeNode tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max((leftTreeInfo.height), rightTreeInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }

    private static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
