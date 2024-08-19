package corp.alv.challenges.general.binarytrees.bfs.medium;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/*
Deepest Leaves Sum

Solution
Given the root of a binary tree, return the sum of values of its deepest leaves.


Example 1:
            1
          /   \
        2       3
      /   \       \
    4       5       6
  /                   \
7                       8
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19


Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int sumOfDeepestLeaves = 0;
        if (root == null) {
            return sumOfDeepestLeaves;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            boolean isLastLevel = true;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.remove();
                isLastLevel = isLastLevel && node.left == null && node.right == null;

                sumOfDeepestLeaves += node.val;

                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
            if (!isLastLevel) {
                sumOfDeepestLeaves = 0;
            }
        }

        return sumOfDeepestLeaves;
    }

    public static void main(String[] args) {
        DeepestLeavesSum d = new DeepestLeavesSum();
        TreeNode root = null;

        root = BinaryTreeUtils.createBinaryTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        System.out.println(d.deepestLeavesSum(root));
    }
}
