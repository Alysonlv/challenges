package corp.alv.challenges.general.binarytrees.searchtrees.medium;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long smallest, long largest) {
        if (node == null) {
            return true;
        }

        if (smallest >= node.val || node.val >= largest) {
            return false;
        }

        boolean left = dfs(node.left, smallest, node.val);
        boolean right = dfs(node.right, node.val, largest);
        return left && right;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree t = new ValidateBinarySearchTree();
        TreeNode node = null;

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println("False = " + t.isValidBST(node));

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{2, 1, 3});
        System.out.println("True = " + t.isValidBST(node));

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{5, 4, 6, null, null, 3, 7});
        System.out.println("False = " + t.isValidBST(node));

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{3, 1, 5, 0, 2, 4, 6});
        System.out.println("True = " + t.isValidBST(node));
    }
}
