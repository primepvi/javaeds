import java.util.Arrays;

public class Stack<T extends Object> {
	private Object[] values;

	private int capacity;
	private int length;

	public Stack(int capacity) {
		this.values = new Object[capacity];
		this.capacity = capacity;
		this.length = 0;

	}

	public int capacity() {
		return this.capacity;
	}

	public int length() {
		return this.length;
	}

	public void push(T element) {
		if (this.isFull()) {
			this.capacity *= 2;
			this.values = Arrays.copyOf(this.values, this.capacity);
		}

		this.values[this.length++] = element;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (this.isEmpty()) {
			return null;
		}

		return (T) this.values[--this.length];
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	public boolean isFull() {
		return this.length == this.capacity;
	}

	public String toString() {
		String[] values = Arrays.stream(this.values).map(Object::toString).toArray(String[]::new);
		return "[" + String.join(",", values) + "]";
	}
}
