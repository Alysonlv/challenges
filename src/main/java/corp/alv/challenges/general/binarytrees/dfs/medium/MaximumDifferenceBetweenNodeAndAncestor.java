package corp.alv.challenges.general.binarytrees.dfs.medium;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

/*
1026. Maximum Difference Between Node and Ancestor
Medium
Topics
Companies
Hint
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.



Example 1:


Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
Example 2:


Input: root = [1,null,2,null,0,3]
Output: 3


Constraints:

The number of nodes in the tree is in the range [2, 5000].
0 <= Node.val <= 105
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    private int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode node, int currentMax, int currentMin) {
        if (node == null) {
            return;
        }

        int possibleMax = Math.max(Math.abs(node.val - currentMax), Math.abs(node.val - currentMin));
        maxDiff = Math.max(maxDiff, possibleMax);
        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);
        dfs(node.left, currentMax, currentMin);
        dfs(node.right, currentMax, currentMin);
    }

    //8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13


    public static void main(String[] args) {
        MaximumDifferenceBetweenNodeAndAncestor t = new MaximumDifferenceBetweenNodeAndAncestor();
        System.out.println(t.maxAncestorDiff(BinaryTreeUtils.createBinaryTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13})));
        t = new MaximumDifferenceBetweenNodeAndAncestor();
//        System.out.println(t.maxAncestorDiff(BinaryTreeUtils.createBinaryTree(new Integer[]{2, null, 0, 1})));
        t = new MaximumDifferenceBetweenNodeAndAncestor();
//        System.out.println(t.maxAncestorDiff(BinaryTreeUtils.createBinaryTree(new Integer[]{1, null, 2, null, 0, 3})));
    }
}
