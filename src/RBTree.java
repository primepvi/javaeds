import java.util.function.Consumer;

public class RBTree {
    private RBTreeNode root;

    public RBTreeNode root() {
        return this.root;
    }

    public void insert(int value) {
        if (this.root == null) {
            this.root = new RBTreeNode(value, true);
        } else {
            this.root = this.execInsert(this.root, value);
            this.root.isBlack = true;
        }
    }

    private RBTreeNode execInsert(RBTreeNode node, int value) {
        if (node == null) {
            return new RBTreeNode(value, false);
        }

        if (node.value > value) {
            node.left = this.execInsert(node.left, value);
            node.left.parent = node;

            if (node.isBlack && !node.left.isBlack) {
                node = this.balance(node, true);
            }
        } else {
            node.right = this.execInsert(node.right, value);
            node.right.parent = node;

            if (node.isBlack && !node.right.isBlack) {
                node = this.balance(node, false);
            }
        }

        return node;
    }

    private RBTreeNode balance(RBTreeNode grandParent, boolean parentAtLeft) {
        RBTreeNode parent = parentAtLeft ? grandParent.left : grandParent.right;
        RBTreeNode uncle = parentAtLeft ? grandParent.right : grandParent.left;
        RBTreeNode child = null;

        if (parent.left != null && !parent.left.isBlack) {
            child = parent.left;
        } else if (parent.right != null && !parent.right.isBlack) {
            child = parent.right;
        }

        if (child == null) {
            return grandParent;
        }

        boolean childAtLeft = parent.value > child.value;

        if (uncle != null && !uncle.isBlack) {
            parent.isBlack = true;
            uncle.isBlack = true;
            grandParent.isBlack = false;
            return grandParent;
        }

        if (parentAtLeft) {
            if (!childAtLeft) {
                grandParent.left = parent.rotateLeft();
                parent = grandParent.left;
            }

            parent.isBlack = true;
            grandParent.isBlack = false;
            grandParent = grandParent.rotateRight();
        } else {
            if (childAtLeft) {
                grandParent.right = parent.rotateRight();
                parent = grandParent.right;
            }

            parent.isBlack = true;
            grandParent.isBlack = false;
            grandParent = grandParent.rotateLeft();
        }

        return grandParent;
    }

    public void centralEach(Consumer<RBTreeNode> callback) {
        this.execCentralEach(this.root, callback);
    }

    private void execCentralEach(RBTreeNode node, Consumer<RBTreeNode> callback) {
        if (node == null)
            return;

        this.execCentralEach(node.left, callback);
        callback.accept(node);
        this.execCentralEach(node.right, callback);
    }

    public void posOrderEach(Consumer<RBTreeNode> callback) {
        this.execPosOrderEach(this.root, callback);
    }

    private void execPosOrderEach(RBTreeNode node, Consumer<RBTreeNode> callback) {
        if (node == null)
            return;

        this.execPosOrderEach(node.left, callback);
        this.execPosOrderEach(node.right, callback);
        callback.accept(node);
    }

    public void preOrderEach(Consumer<RBTreeNode> callback) {
        this.execPreOrderEach(this.root, callback);
    }

    private void execPreOrderEach(RBTreeNode node, Consumer<RBTreeNode> callback) {
        if (node == null)
            return;

        callback.accept(node);
        this.execPreOrderEach(node.left, callback);
        this.execPreOrderEach(node.right, callback);
    }
}
