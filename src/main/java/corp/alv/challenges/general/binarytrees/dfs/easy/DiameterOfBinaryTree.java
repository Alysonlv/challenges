package corp.alv.challenges.general.binarytrees.dfs.easy;
/*
543. Diameter of Binary Tree
Easy
Topics
Companies
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

public class DiameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    public int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = longestPath(node.left);
        int right = longestPath(node.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        DiameterOfBinaryTree t = new DiameterOfBinaryTree();
        TreeNode node = BinaryTreeUtils.createBinaryTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("Max = " + t.longestPath(node));
        System.out.println("Diameter = " + t.diameterOfBinaryTree(node));
    }
}
