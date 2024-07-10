package corp.alv.challenges.domain;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
