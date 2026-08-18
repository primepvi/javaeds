public class Main {
    public static void main(String[] args) {
	Queue<Integer> queue = new Queue(2);
	queue.enqueue(10);
	printQueue(queue);

	queue.enqueue(20);
	printQueue(queue);
	
	System.out.println(queue.dequeue());
	printQueue(queue);

	queue.enqueue(30);
	printQueue(queue);

	System.out.println(queue.dequeue());
	printQueue(queue);
    }

    private static<T> void printQueue(Queue<T> queue) {
	System.out.printf("Start: %d | End: %d\n", queue.start(), queue.end());
	System.out.println(queue.toString());
    }
}
