package corp.alv.challenges.general.binarytrees.searchtrees.medium;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public void dfs(TreeNode node, int val) {
        TreeNode temp = null;
        if (node.left == null && node.right == null) {
            temp = new TreeNode(val);
            if (node.val > val) {
                node.left = temp;
            } else {
                node.right = temp;
            }
            return;
        }
        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                dfs(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                dfs(node.right, val);
            }
        }
    }

    public static void main(String[] args) {
        InsertIntoBST bst = new InsertIntoBST();

        TreeNode node = null;

//        node = BinaryTreeUtils.createBinaryTree(new Integer[]{4, 2, 7, 1, 3});
//        System.out.println(bst.insertIntoBST(node, 5));
        node = BinaryTreeUtils.createBinaryTree(new Integer[]{5, null, 14, 10, 77, null, null, null, 95, null, null});
        System.out.println(bst.insertIntoBST(node, 4));
        //
    }
}
