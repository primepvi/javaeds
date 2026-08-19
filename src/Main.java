public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(10);
		list.prepend(5);
		list.append(15);
		list.prepend(0);
		list.append(20);

		LinkedListNode head = list.head();
		LinkedListNode tail = list.tail();
		LinkedListNode mid = list.get(list.length() / 2);

		System.out.printf("head: %d, tail: %d, mid: %d\n", head.value, tail.value, mid.value);
		System.out.println(list.toString());
	}
}
