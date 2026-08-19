public class Main {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(15);
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);

		tree.preOrderEach(node -> System.out.println(node.value));
	}
}
