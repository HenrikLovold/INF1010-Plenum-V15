import java.util.Iterator;

class Main {
	public static void main(String[] args) {
	
		Garasje g = new Garasje(10);
		
		for (int i = 0; i < 5; i++) {
			g.settInn(new Bil(i), i);
		}
		
		for (Bil b : g) {
			System.out.println(b);
		}
	}
}

class Garasje implements Iterable<Bil> {
	private Bil[] biler;
	
	Garasje(int antall) {
		biler = new Bil[antall];
	}
	
	public void settInn(Bil b, int i) {
		biler[i] = b;
	}
	
	public Iterator<Bil> iterator() {
		return new MinIterator();
	}
	
	class MinIterator implements Iterator<Bil> {
		int teller = 0;
		
		public boolean hasNext() {
			return teller < biler.length && biler[teller] != null;
		}
		
		public Bil next() {
			return biler[teller++];
		}
		
		public void remove() { }
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
