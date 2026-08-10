public class Main {
	public static void main(String[] args) {
	    Stack<Integer> numbers = new Stack<Integer>(10);
	    for (int i = 0; i < 10; i++) {
		numbers.push(i);
	    }

	    System.out.println(numbers);
	    
	    while (!numbers.isEmpty()) {
		Integer curr = numbers.pop();
		System.out.println(curr);
	    }
	}
}
