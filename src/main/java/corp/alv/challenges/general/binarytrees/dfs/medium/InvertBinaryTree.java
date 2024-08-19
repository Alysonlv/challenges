package corp.alv.challenges.general.binarytrees.dfs.medium;

import corp.alv.challenges.domain.TreeNode;

/**
 * Write a function that takes in a Binary Tree and inverts it. In other words,
 * the function should swap every left node in the tree for its corresponding
 * right node.
 * <p>
 * Each BinaryTree node has an integer value, a
 * left child node, and a right child node. Children
 * nodes can either be BinaryTree nodes themselves or
 * None / null.
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
 * 1
 * /     \
 * 3       2
 * /   \   /   \
 * 7     6 5     4
 * /   \
 * 9     8
 */
public class InvertBinaryTree {

    public static void invertBinaryTree(TreeNode tree) {
        if (tree == null) {
            return;
        }

        TreeNode temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }
}
