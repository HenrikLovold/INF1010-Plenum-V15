import java.util.Iterator;

public class RecursiveList<T> implements Iterable<T> {
	Node first;

	public void insert(T t) {
		System.out.println("Setter inn: " + t);
		Node n = new Node(t);
		if (first == null) {
			first = n;
		} else {
			Node tmp = first;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = n;
		}
	}

	public void insertRecursive(T t) {
		System.out.println("Setter inn rekursivt: " + t);
		if (first == null) {
			first = new Node(t);
		} else {
			first.insertRecursive(t);
		}
	}

	public void print() {
		if (first == null) {
			System.out.println("Tom liste");
		} else {
			Node tmp = first;
			System.out.println(first.data);
			while (tmp.next != null) {
				tmp = tmp.next;
				System.out.println(tmp.data);
			}
		}
	}

	public void printRecursive() {
		if (first == null) {
			System.out.println("Tom liste");
		} else {
			first.printRecursive();
		}
	}

	class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
		}

		public void printRecursive() {
			System.out.println(data);
			if (next != null) {
				next.printRecursive();
			}
		}

		public void insertRecursive(T t) {
			if (next == null) {
				next = new Node(t);
			} else {
				next.insertRecursive(t);
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	class MyIterator implements Iterator<T> {
		Node tmp = first;

		@Override
		public boolean hasNext() {
			return tmp != null;
		}

		@Override
		public T next() {
			Node returnNode = tmp;
			tmp = tmp.next;
			return returnNode.data;
		}
	}
}
