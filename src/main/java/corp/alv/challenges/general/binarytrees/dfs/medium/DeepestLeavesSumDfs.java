package corp.alv.challenges.general.binarytrees.dfs.medium;

import com.sun.source.tree.Tree;
import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
public class DeepestLeavesSumDfs {

    private int deepestLevel = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {
        deepestLevel = 0;
        map = new HashMap<>();
        calculate(root, 0);
        return map.get(deepestLevel);
    }

    private void calculate(TreeNode node, int level) {
        level++;
        if (node.right == null && node.left == null) {
            deepestLevel = Math.max(deepestLevel, level);
            map.put(level, node.val + map.getOrDefault(level, 0));
        }

        deepestLevel = Math.max(deepestLevel, level);
        if (node.left != null) {
            calculate(node.left, level);
        }
        if (node.right != null) {
            calculate(node.right, level);
        }
    }

    public static void main(String[] args) {
        DeepestLeavesSumDfs d = new DeepestLeavesSumDfs();

        TreeNode root = null;

        root = BinaryTreeUtils.createBinaryTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        System.out.println(d.deepestLeavesSum(root));
    }
}
