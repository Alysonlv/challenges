package corp.alv.challenges.general.binarytrees.dfs.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

public class MinValueOfTree {
    private int minValue = Integer.MAX_VALUE;

    public int getMinValue(TreeNode root) {
        minValue = Integer.MAX_VALUE;
        dfs(root);
        return minValue;
    }

    private void dfs(TreeNode node) {
        minValue = Math.min(minValue, node.val);

        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        MinValueOfTree mvt = new MinValueOfTree();
        TreeNode node = null;

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{4, 6, 11, 2, 3, null, 9, null, 5, 20});
        System.out.println(mvt.getMinValue(node));
    }
}
