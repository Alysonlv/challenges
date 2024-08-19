package corp.alv.challenges.general.binarytrees.bfs.medium;

import corp.alv.challenges.domain.TreeNode;
import corp.alv.challenges.utils.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        q.addLast(null);

        LinkedList<Integer> levelList = new LinkedList<>();
        boolean orderLeft = true;

        while (q.size() > 0) {
            TreeNode node = q.pollFirst();

            if (node != null) {
                if (orderLeft) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }

                if (node.left != null) {
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    q.addLast(node.right);
                }
            } else {
                // we finish the scan of one level
                results.add(levelList);
                levelList = new LinkedList<>();
                // prepare for the next level
                if (q.size() > 0) {
                    q.addLast(null);
                }
                orderLeft = !orderLeft;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal t = new BinaryTreeZigzagLevelOrderTraversal();

        TreeNode root = null;

        //        root = BinaryTreeUtils.createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
//        System.out.println(t.zigzagLevelOrder(root));

        root = BinaryTreeUtils.createBinaryTree(new Integer[]{1, 2, 3, 4, null, null, 5});
        System.out.println(t.zigzagLevelOrder(root));
    }
}
