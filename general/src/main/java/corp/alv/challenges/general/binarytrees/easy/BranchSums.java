package corp.alv.challenges.general.binarytrees.easy;

import java.util.ArrayList;
import java.util.List;

/**
 ******* BINARY TREES
 *
 *
 *   Write a function that takes in a Binary Tree and returns a list of its branch
 *   sums ordered from leftmost branch sum to rightmost branch sum.
 *   A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
 *   branch is a path of nodes in a tree that starts at the root node and ends at
 *   any leaf node.

 *   Each BinaryTree node has an integer value, a
 *   left child node, and a right child node. Children
 *   nodes can either be BinaryTree nodes themselves or

 * Sample Input
 * tree =     1
 *         /     \
 *        2       3
 *      /   \    /  \
 *     4     5  6    7
 *   /   \  /
 *  8    9 10
 * Sample Output
 * [15, 16, 18, 10, 11]
 * // 15 == 1 + 2 + 4 + 8
 * // 16 == 1 + 2 + 4 + 9
 * // 18 == 1 + 2 + 5 + 10
 * // 10 == 1 + 3 + 6
 * // 11 == 1 + 3 + 7
 */
public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    public static void calculateBranchSums(final BinaryTree node, int runningSum, final List<Integer> sums) {
        if (node == null) { //identify the end of the branch and end the iteration
            return;
        }

        int currentRunningSum = runningSum + node.value;
        if (node.left == null && node.right == null) {//identify that the node doesn't have child nodes and end the iteration
            sums.add(currentRunningSum);
            return;
        }

        //The follow lines make sure that the order on the list will be respected. Calculating all lefts first.
        calculateBranchSums(node.left, currentRunningSum, sums);
        calculateBranchSums(node.right, currentRunningSum, sums);
    }

    public static void main(String[] args) {

    }
}
