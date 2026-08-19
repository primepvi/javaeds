import java.util.Arrays;

public class Queue<T extends Object> {
	private Object[] values;

	private int capacity;
	private int length;
	private int start, end;

	public Queue(int capacity) {
		this.values = new Object[capacity];
		this.capacity = capacity;

		this.length = 0;
		this.start = 0;
		this.end = 0;
	}

	public int capacity() {
		return this.capacity;
	}

	public int length() {
		return this.length;
	}

	public int start() {
		return this.start;
	}

	public int end() {
		return this.end;
	}

	public void enqueue(T element) {
		if (this.isFull()) {
			this.capacity *= 2;
			this.values = Arrays.copyOf(this.values, this.capacity);
		}

		this.values[this.end] = element;
		this.end = (this.end + 1) % this.capacity;
		this.length++;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (this.isEmpty()) {
			return null;
		}

		T value = (T) this.values[this.start];
		this.values[this.start] = null;
		this.start = (this.start + 1) % this.capacity;
		this.length--;

		return value;
	}

	public boolean isEmpty() {
		return this.start == this.end;
	}

	public boolean isFull() {
		return (this.end + 1) % this.capacity == this.start;
	}

	public String toString() {
		String[] values = Arrays.stream(this.values)
				.map(x -> x == null ? "null" : x.toString())
				.toArray(String[]::new);

		return "[" + String.join(",", values) + "]";
	}
}
