public class Main {
    public static void main(String[] args) {
        RBTree tree = new RBTree();

        int[] values = {
                10, 5, 15, 1, 7, 12, 20,
                0, 3, 6, 8, 11, 13, 18, 25,
        };

        for (int value : values) {
            tree.insert(value);
        }

        tree.preOrderEach(node -> System.out.printf("value=%d, height=%d, color=%c\n",
                node.value, node.height(), node.isBlack ? 'B' : 'R'));
    }
}