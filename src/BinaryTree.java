import java.util.function.Consumer;

public class BinaryTree {
	private BinaryTreeNode root;

	public void insert(int value) {
		this.root = this.execInsert(this.root, value);
	}

	private BinaryTreeNode execInsert(BinaryTreeNode node, int value) {
		if (node == null)
			return new BinaryTreeNode(value);

		if (node.value > value) {
			node.left = this.execInsert(node.left, value);
		} else {
			node.right = this.execInsert(node.right, value);
		}

		return node;
	}

	public void centralEach(Consumer<BinaryTreeNode> callback) {
		this.execCentralEach(this.root, callback);
	}

	private void execCentralEach(BinaryTreeNode node, Consumer<BinaryTreeNode> callback) {
		if (node == null)
			return;

		this.execCentralEach(node.left, callback);
		callback.accept(node);
		this.execCentralEach(node.right, callback);
	}

	public void posOrderEach(Consumer<BinaryTreeNode> callback) {
		this.execPosOrderEach(this.root, callback);
	}

	private void execPosOrderEach(BinaryTreeNode node, Consumer<BinaryTreeNode> callback) {
		if (node == null)
			return;

		this.execPosOrderEach(node.left, callback);
		this.execPosOrderEach(node.right, callback);
		callback.accept(node);
	}

	public void preOrderEach(Consumer<BinaryTreeNode> callback) {
		this.execPreOrderEach(this.root, callback);
	}

	private void execPreOrderEach(BinaryTreeNode node, Consumer<BinaryTreeNode> callback) {
		if (node == null)
			return;

		callback.accept(node);
		this.execPreOrderEach(node.left, callback);
		this.execPreOrderEach(node.right, callback);
	}
}
