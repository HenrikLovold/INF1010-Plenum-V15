import java.util.Iterator;

class Main {
	public static void main(String[] args) {
	
		Garasje g = new Garasje();
		
		for (int i = 0; i < 5; i++) {
			g.settInn(new Bil(i));
		}
		
		for (Bil b : g) {
			System.out.println(b);
		}
	}
}

class Garasje implements Iterable<Bil> {

	private Node forste;
	
	Garasje() {
		
	}	
	
	public void settInn(Bil b) {
		if(forste == null) {
			forste = new Node(b);
		} else {
			Node tmp = forste;
			while(tmp.neste != null) {
				tmp = tmp.neste;
			}
			
			tmp.neste = new Node(b);
		}
	}
	
	public Iterator<Bil> iterator() {
		return new MinIterator();
	}
	
	class MinIterator implements Iterator<Bil> {
	
		Node tmp = forste;	
		
		public boolean hasNext() {
		
			return tmp != null;
			
		}
		
		public Bil next() {
		
			Bil denne = tmp.data;
			tmp = tmp.neste;
			
			return denne;
			
		}
		
		public void remove() { }
	}
	
	private class Node {
	
		Bil data;
		Node neste;
		
		public Node(Bil data) {
			this.data = data;
		}
		
	}
	
}


class Bil {
	int nr;
	
	Bil(int nr) {
		this.nr = nr;
	}
	
	public String toString() {
		return String.format("Bil nr. " + nr);
	}
}
