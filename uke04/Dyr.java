

abstract class Dyr {
	protected int alder;
	
	public void settAlder(int alder) {
		this.alder = alder;
	}
	
	public void info() {
		System.out.println("Jeg er et dyr. Jeg er " + alder + " år gammel.");
	}
}

class Elefant extends Dyr {

	public void tut() {
		System.out.println("Tuuuuuuuuuuuuuuuut");
	}

	public void info() {
		System.out.println("Jeg er en elefant. Jeg er " + alder + " år gammel.");
	}
}
