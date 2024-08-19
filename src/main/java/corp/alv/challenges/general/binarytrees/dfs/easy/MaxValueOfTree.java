package corp.alv.challenges.general.binarytrees.dfs.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

/*
Find the highest value of the a Tree
 */
public class MaxValueOfTree {
    private int maxValue = Integer.MIN_VALUE;

    public int maxValue(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        dfs(root);
        return maxValue;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            maxValue = Math.max(maxValue, node.val);

            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        MaxValueOfTree mvt = new MaxValueOfTree();
        TreeNode node = null;

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{1, 6, 11, 2, 3, null, 9, null, 5, 20});
        System.out.println(mvt.maxValue(node));
    }
}
