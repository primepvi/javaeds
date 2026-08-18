public class LinkedList {
    private LinkedListNode head, tail;
    private int length;

    public LinkedList() {
	this.head = null;
	this.tail = null;
	this.length = 0;
    }

    public void prepend(int value) {
	if (this.head == null) {
	    this.head = new LinkedListNode(value);
	    this.tail = this.head;
	    return;
	}

	LinkedListNode newHead = new LinkedListNode(value);
	newHead.next = this.head;
	this.head.prev = newHead;
	this.head = newHead;
	this.length++;
    }

    public void append(int value) {
	if (this.tail == null) {
	    this.tail = new LinkedListNode(value);
	    this.head = this.tail;
	    return;
	}

	LinkedListNode newTail = new LinkedListNode(value);
	newTail.prev = this.tail;
	this.tail.next = newTail;
	this.tail = newTail;
	this.length++;
    }

    public LinkedListNode get(int index) {
	if (this.isEmpty() || index >= this.length || index < 0) {
	    return null;
	}
	
	int cursor = 0;
	LinkedListNode current = this.head;
	
	while (current.next != null && cursor != index) {
	    current = current.next;
	    cursor++;
	}

	return cursor == index ? current : null;
    }
	       

    public boolean isEmpty() {
	return this.head == null && this.tail == null;
    }

    public int length() {
	return this.length;
    }

    public LinkedListNode head() {
	return this.head;
    }

    public LinkedListNode tail() {
	return this.tail;
    }

    public String toString() {
	StringBuilder result = new StringBuilder("[");	
	LinkedListNode current = this.head;
	
	while (current != null) {
	    result.append(Integer.toString(current.value));
	    current = current.next;

	    if (current != null) {
		result.append(", ");
	    }
	}

	result.append("]");
	return result.toString();
    }
}
