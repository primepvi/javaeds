public class BinaryTreeNode {
	public int value;
	public BinaryTreeNode left, right;

	public BinaryTreeNode(int value) {
		this.value = value;

		this.left = null;
		this.right = null;
	}

	public int height() {
		if (this.left == null && this.right == null) {
			return 0;
		}

		int leftHeight = this.left == null ? 0 : this.left.height();
		int rightHeight = this.right == null ? 0 : this.right.height();

		return 1 + Math.max(leftHeight, rightHeight);
	}

	public BinaryTreeNode rotateLeft() {
		BinaryTreeNode root = this.right;
		this.right = root.left;
		root.left = this;

		return root;
	}

	public BinaryTreeNode rotateRight() {
		BinaryTreeNode root = this.left;
		this.left = root.right;
		root.right = this;

		return root;
	}
}
