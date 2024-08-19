package corp.alv.challenges.general.binarytrees.dfs.search.easy;

import corp.alv.challenges.general.domains.BST;

/**
 * Find the Closest Value in Binary Search Tree
 * <p>
 * Write a function that takes in a Binary Search Tree (BST) and a target integer
 * value and returns the closest value to that target value contained in the BST.
 * <p>
 * You can assume that there will only be one closest value.
 * <p>
 * Each <span>BST node has an integer <span>value, a
 * <span>left child node, and a <span>right child node. A node is
 * said to be a valid <span>BST node if and only if it satisfies the BST
 * property: its <span>value is strictly greater than the values of every
 * node to its left; its <span>value is less than or equal to the values
 * of every node to its right; and its children nodes are either valid
 * <span>BST nodes themselves or <span>None / <span>null.
 * <p>
 * Sample Input
 * tree =   10
 * /     \
 * 5      15
 * /   \   /   \
 * 2     5 13   22
 * /           \
 * 1            14
 * target = 12
 * <p>
 * Sample Output 13
 */
public class FindClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        return checkNode(tree, target, tree.value);
    }

    public static int checkNode(BST node, int target, int current) {
        if (Math.abs(target - current) > Math.abs(target - node.value)) {
            current = node.value;
        }

        if (target < node.value && node.left != null) {
            return checkNode(node.left, target, current);
        } else if (target > node.value && node.right != null) {
            return checkNode(node.right, target, current);
        } else {
            return current;
        }
    }

}
