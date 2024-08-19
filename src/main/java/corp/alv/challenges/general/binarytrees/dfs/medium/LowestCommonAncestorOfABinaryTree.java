package corp.alv.challenges.general.binarytrees.dfs.medium;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree t = new LowestCommonAncestorOfABinaryTree();
        TreeNode root = BinaryTreeUtils.createBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode node = t.lowestCommonAncestor(root, new TreeNode(6), new TreeNode(8));
        System.out.println(node);
    }
}
