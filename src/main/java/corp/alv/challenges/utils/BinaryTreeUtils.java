package corp.alv.challenges.utils;

import com.sun.source.tree.Tree;
import corp.alv.challenges.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeUtils {

    public static void dpsPreOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.val).append(", ");
        dpsPreOrder(node.left, sb);
        dpsPreOrder(node.right, sb);

        sb.deleteCharAt(sb.length()).deleteCharAt(sb.length());
    }

    public static void dpsInOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        dpsInOrder(node, sb);
        sb.append(node.val);
        dpsInOrder(node, sb);

        sb.deleteCharAt(sb.length()).deleteCharAt(sb.length());
    }

    public static void dpsPosOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        dpsPosOrder(node, sb);
        dpsPosOrder(node, sb);
        sb.append(node.val);

        sb.deleteCharAt(sb.length()).deleteCharAt(sb.length());
    }

    public static int maxDepthPosOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepthPosOrder(root.left);
        int right = maxDepthPosOrder(root.right);
        return Math.max(left, right) + 1;
    }

    public static int maxDepthPosOrderIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>(); // Keep track of depths along with nodes

        stack.push(root);
        depths.push(1); // Initial depth for the root node is 1

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = depths.pop();

            maxDepth = Math.max(maxDepth, currentDepth);

            if (node.right != null) {
                stack.push(node.right);
                depths.push(currentDepth + 1); // Increment depth for child nodes
            }
            if (node.left != null) {
                stack.push(node.left);
                depths.push(currentDepth + 1); // Increment depth for child nodes
            }
        }

        return maxDepth;
    }

    public static TreeNode createBinaryTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (current == null) continue;

            // Set left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Set right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode node = createBinaryTree(new Integer[]{3, 1, 4, 3, null, 1, 5});
        printTree(node);
    }
}
