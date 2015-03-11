import java.util.Iterator;

public class RekursivListe<T> implements Iterable<T>{
	
	Node forste;
	
	public int settInn(T data) {
		if(forste == null) {
			forste = new Node(data);
			return 0;
		}
		
		return forste.settInn(data, 0);
	}
	
	public void skrivUtPrefix() {
		if(forste != null) {
			forste.skrivUtPrefix();
		}
	}
	
	public void skrivUtPostfix() {
		if(forste != null) {
			forste.skrivUtPostfix();
		}
	}
	
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	class ListIterator implements Iterator<T> {
		
		Node tmp = forste;
		
		public boolean hasNext() {
			return tmp != null;
		}
		
		public T next() {
			Node retNode = tmp;
			tmp = tmp.neste;
			return retNode.data;
		}
				
	}
	
	private class Node {
		T data;
		Node neste;
		
		Node(T data) {
			this.data = data;
		}
		
		public int settInn(T data, int index) {
			
			if(this.neste == null) {
				this.neste = new Node(data);
				return index+1;
			}
			
			return neste.settInn(data, index+1);
			
		}
		
		public void skrivUtPrefix() {
			System.out.println(data);
			if(neste != null) {
				neste.skrivUtPrefix();
			}
		}
		
		public void skrivUtPostfix() {
			if(neste != null) {
				neste.skrivUtPostfix();
			}
			System.out.println(data);
		}
		
	}
	

}
