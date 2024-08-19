package corp.alv.challenges.general.binarytrees.searchtrees.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

/*
Closest Binary Search Tree Value

Solution
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.



Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
 */
public class FindClosestValue {
    TreeNode closest;

    public int closestValue(TreeNode root, double target) {
        closest = root;
        bst(root, target);
        return closest.val;
    }

    private void bst(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        double diff = Math.abs(target - node.val);
        double currDiff = Math.abs(target - closest.val);

        if (diff < currDiff || diff == currDiff && node.val < closest.val) {
            closest = node;
        }

        bst(node.left, target);
        bst(node.right, target);
    }

    public static void main(String[] args) {
        FindClosestValue f = new FindClosestValue();

        TreeNode node = null;

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{4, 2, 5, 1, 3});
        System.out.println("4 = " + f.closestValue(node, 3.714286));

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{1});
        System.out.println("1 = " + f.closestValue(node, 3.714286));

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{3});
        System.out.println("3 = " + f.closestValue(node, 3.714286));
    }
}
