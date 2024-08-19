package corp.alv.challenges.general.binarytrees.searchtrees.easy;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

/*
938. Range Sum of BST
Easy
Topics
Companies
Given the root node of a binary search tree and two integers low and high,
return the sum of values of all nodes with a value in the inclusive range [low, high].



Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.


Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.
 */
public class RangeSumOfBST {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        binarySearchTree(root, low, high);
        return sum;
    }

    private void binarySearchTree(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }

        if (low <= node.val && node.val <= high) {
            sum += node.val;
        }

        if (node.val > low) {
            binarySearchTree(node.left, low, high);
        }
        if (node.val < high) {
            binarySearchTree(node.right, low, high);
        }
    }

    public static void main(String[] args) {
        RangeSumOfBST bst = new RangeSumOfBST();
        TreeNode node = null;

        node = BinaryTreeUtils.createBinaryTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
        System.out.println(bst.rangeSumBST(node, 7, 15));
    }

}
