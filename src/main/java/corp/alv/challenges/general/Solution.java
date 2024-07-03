package corp.alv.challenges.general;

/*

### Write a pair of functions to serialize and deserialize a binary tree.

# For example,

#          3
#        /   \
#      1       2
#   /           \
#  4             5
#
#
3,1,2,4,null,null,5,null,null,null,null
##
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    StringBuilder sb;

    public Solution() {
        sb = new StringBuilder();
    }

    public StringBuilder buildString(Node root) {
        if (root == null) {

            return sb;
        }

        sb.append(root.value);
        sb.append(",");
        buildString(root.left);
        buildString(root.right);

        return sb;
    }



    public static void main(String[] args) {
        Node left = new Node(null, null, 1);
        Node right = new Node(null, null, 2);
        Node node = new Node(left, right, 3);

        Solution solution = new Solution();
        System.out.println(solution.buildString(node).toString());
    }
}

class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}