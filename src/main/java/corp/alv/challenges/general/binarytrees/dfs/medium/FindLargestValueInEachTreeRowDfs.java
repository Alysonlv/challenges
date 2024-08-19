package corp.alv.challenges.general.binarytrees.dfs.medium;

import corp.alv.challenges.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*

Code
Testcase
Test Result
Test Result
515. Find Largest Value in Each Tree Row
Medium
Topics
Companies
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).



Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]


Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1
 */
public class FindLargestValueInEachTreeRowDfs {
    List<Integer> ans;

    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
