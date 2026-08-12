public class Main {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(4);
		tree.insert(6);

		tree.centralEach(Main::printNode);
		System.out.println();

		tree.posOrderEach(Main::printNode);
		System.out.println();

		tree.preOrderEach(Main::printNode);
		System.out.println();
	}

	private static void printNode(BinaryTreeNode node) {
		System.out.print(node.value);
		System.out.print(" ");
	}
}
