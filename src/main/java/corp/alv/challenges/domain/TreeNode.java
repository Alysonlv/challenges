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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + this.val);

        if (null != left) {
            left.print(prefix + (isTail ? "    " : "│   "), (null == right ? true : false));
        }

        if (null != right) {
            right.print(prefix + (isTail ? "    " : "│   "), true);
        }

    }
}
