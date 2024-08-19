package corp.alv.challenges.general.binarytrees.dfs.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

/*
Maximum Depth of Binary Tree
Easy
Topics
Companies
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.left);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree t = new MaximumDepthOfBinaryTree();
        TreeNode node = BinaryTreeUtils.createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(t.maxDepth(node));

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{3, 1, null, null, 2});
        System.out.println(t.maxDepth(node.left) + t.maxDepth(node.right) + 1);//3,1,null,null,2
    }
}
