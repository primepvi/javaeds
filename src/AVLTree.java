public class AVLTree extends BinaryTree {
    @Override
    protected BinaryTreeNode execInsert(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }

        if (node.value > value) {
            node.left = this.execInsert(node.left, value);
        } else {
            node.right = this.execInsert(node.right, value);
        }

        return this.balanceNode(node);
    }

    private int calculateBalanceFactor(BinaryTreeNode node) {
        int leftHeight = node.left == null ? 0 : node.left.height() + 1;
        int rightHeight = node.right == null ? 0 : node.right.height() + 1;

        return rightHeight - leftHeight;
    }

    private BinaryTreeNode balanceNode(BinaryTreeNode root) {
        int balanceFactor = this.calculateBalanceFactor(root);
        if (balanceFactor < -1) {
            if (this.calculateBalanceFactor(root.left) > 0) {
                root.left = root.left.rotateLeft();
            }
            root = root.rotateRight();
        } else if (balanceFactor > 1) {
            if (this.calculateBalanceFactor(root.right) < 0) {
                root.right = root.right.rotateRight();
            }
            root = root.rotateLeft();
        }

        return root;
    }
}