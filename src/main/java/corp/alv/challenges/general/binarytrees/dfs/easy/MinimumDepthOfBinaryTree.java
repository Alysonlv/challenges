package corp.alv.challenges.general.binarytrees.dfs.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 */
public class MinimumDepthOfBinaryTree {
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If only one of child is non-null, then go into that recursion.
        if (root.left == null) {
            return 1 + dfs(root.right);
        } else if (root.right == null) {
            return 1 + dfs(root.left);
        }

        // Both children are non-null, hence call for both children.
        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }

    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree t = new MinimumDepthOfBinaryTree();
        System.out.println(t.minDepth(BinaryTreeUtils.createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(t.minDepth(BinaryTreeUtils.createBinaryTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
    }
}
