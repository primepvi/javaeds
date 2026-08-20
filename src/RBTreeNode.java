public class RBTreeNode {
    public int value;
    public boolean isBlack;
    public RBTreeNode left, right, parent;

    public RBTreeNode(int value, boolean isBlack) {
        this.value = value;
        this.isBlack = isBlack;

        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int height() {
        if (this.left == null && this.right == null) {
            return 0;
        }

        int leftHeight = this.left == null ? 0 : this.left.height();
        int rightHeight = this.right == null ? 0 : this.right.height();

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public RBTreeNode rotateLeft() {
        RBTreeNode root = this.right;
        this.right = root.left;
        root.left = this;

        return root;
    }

    public RBTreeNode rotateRight() {
        RBTreeNode root = this.left;
        this.left = root.right;
        root.right = this;

        return root;
    }
}
