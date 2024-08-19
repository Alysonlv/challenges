package corp.alv.challenges.general.binarytrees.bfs.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class MinValueOfTreeBfs {

    public int findMinValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minValue = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.remove();

                minValue = Math.min(minValue, node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        MinValueOfTreeBfs mvtb = new MinValueOfTreeBfs();

        TreeNode node = null;

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{4, 6, 11, 2, 3, null, 9, null, 5, 20});
        System.out.println(mvtb.findMinValue(node));

        node.print("-", true);
    }
}
