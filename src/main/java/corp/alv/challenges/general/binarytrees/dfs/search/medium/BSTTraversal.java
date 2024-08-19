package corp.alv.challenges.general.binarytrees.dfs.search.medium;

import corp.alv.challenges.general.domains.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Write three functions that take in a Binary Search Tree (BST) and an empty
 * array, traverse the BST, add its trees' values to the input array, and return
 * that array. The three functions should traverse the BST using the in-order,
 * pre-order, and post-order tree-traversal techniques, respectively.
 * <p>
 * If you're unfamiliar with tree-traversal techniques, we recommend watching the
 * Conceptual Overview section of this question's video explanation before
 * starting to code.
 * <p>
 * Each BST tree has an integer value, a
 * left child tree, and a right child tree. A tree is
 * said to be a valid BST tree if and only if it satisfies the BST
 * property: its value is strictly greater than the values of every
 * tree to its left; its value is less than or equal to the values
 * of every tree to its right; and its children trees are either valid
 * BST trees themselves or None / null.
 * <p>
 * Sample Input
 * tree =   10
 * /     \
 * 5      15
 * /   \       \
 * 2     5       22
 * /
 * 1
 * array = []
 * <p>
 * Sample Output
 */
public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }

        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        array.add(tree.value);

        if (tree.left != null) {
            preOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            preOrderTraverse(tree.right, array);
        }

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            postOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            postOrderTraverse(tree.right, array);
        }
        array.add(tree.value);

        return array;
    }
}
