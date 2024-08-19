package corp.alv.challenges.general.binarytrees.dfs.easy;

/**
 * ****** BINARY TREES
 * <p>
 * Node Depths
 * <p>
 * The distance between a node in a Binary Tree and the tree's root is called the
 * node's depth.
 * <p>
 * Write a function that takes in a Binary Tree and returns the sum of its nodes'
 * depths.
 * <p>
 * Each <span>BinaryTree node has an integer <span>value, a
 * <span>left child node, and a <span>right child node. Children
 * nodes can either be <span>BinaryTree nodes themselves or
 * <span>None / <span>null.
 * <p>
 * Sample Input
 * tree =    1
 * /     \
 * 2       3
 * /   \   /   \
 * 4     5 6     7
 * /   \
 * 8     9
 * <p>
 * Sample Output
 * 16
 * // The depth of the node with value 2 is 1.
 * // The depth of the node with value 3 is 1.
 * // The depth of the node with value 4 is 2.
 * // The depth of the node with value 5 is 2.
 * // Etc...
 * // Summing all of these depths yields 16.
 */
public class NodeDepths {
    public static int nodeDepths(BinaryTree root) {
        return calculateSumOfNodeDepths(root, 0);
    }

    public static int calculateSumOfNodeDepths(final BinaryTree node, int currentDepth) {
        if (node == null) {
            return 0;
        }

        return currentDepth +
                calculateSumOfNodeDepths(node.left, currentDepth + 1) +
                calculateSumOfNodeDepths(node.right, currentDepth + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
