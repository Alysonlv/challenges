package corp.alv.challenges.general.binarytrees.searchtrees.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/*
530. Minimum Absolute Difference in BST
Easy
Topics
Companies
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.



Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
 */
public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> nodes = new ArrayList<>();

        findMinAbsDiff(root, nodes);

        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size() - 1; i++) {
            minAbsDiff = Math.min(minAbsDiff, Math.abs(nodes.get(i) - nodes.get(i + 1)));
        }

        return minAbsDiff;
    }

    private void findMinAbsDiff(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }

        findMinAbsDiff(node.left, nodes);
        nodes.add(node.val);
        findMinAbsDiff(node.right, nodes);
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST t = new MinimumAbsoluteDifferenceInBST();

        TreeNode node = null;

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{4, 2, 6, 1, 3});
        System.out.println(t.getMinimumDifference(node));
    }
}
