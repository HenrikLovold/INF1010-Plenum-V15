public class MinStakk {

	private Node topp;

	public void push(Pannekake ny) {
		if(topp == null){
			topp = new Node(ny);
		} else {
			topp = topp.leggPaa(ny);
		}
	}
	
	public Pannekake pop() {
	
		Pannekake toppen = topp.min;
		topp = topp.forrige;
		topp.neste = null;
		
		return toppen;
		
	}
	
	public boolean isEmpty() {
		return topp == null;
	}
	
	
	private class Node {
		Node neste;
		Node forrige;
		Pannekake min;
		
		Node(Pannekake min){
			this.min = min;
		}
		
		public Node leggPaa(Pannekake ny) {
			this.neste = new Node(ny);
			this.neste.forrige = this;
			return this.neste;
		}
		
		
	}
	
}
