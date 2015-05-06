class Person {
	protected String navn;

	Person(String navn) {
		this.navn = navn;
	}

	public String id() {
		return navn;
	}

	public boolean equals(Object o) {
		return o instanceof Person && id().equals(((Person) o).id());
	}

	public String toString() {
		return "Person: " + navn;
	}

}

class Student extends Person {

	protected int studnr;

	Student(String navn, int studnr) {
		super(navn);
		this.studnr = studnr;
	}

	public boolean equals(Object o) {
		return o instanceof Student && studnr == ((Student) o).getStudnr();
	}

	public int getStudnr() {
		return studnr;
	}

	public String toString() {
		return "Student: " + navn + " studnr: " + studnr;
	}

}

abstract class Frukt {

	abstract public String id();

	public boolean equals(Frukt f) {
		return id().equals(f.id());
	}
	
	public String toString() {
		return id();
	}
}

class Eple extends Frukt {

	String id = "Eple";

	@Override
	public String id() {
		return id;
	}

}

class Banan extends Frukt {
	String id = "Banan";

	@Override
	public String id() {
		return id;
	}
}

class Kiwi extends Frukt {
	String id = "Kiwi";

	@Override
	public String id() {
		return id;
	}
}

interface Slettbar {
	
}

class Beholder {

	private Node første, iterator;
	private int antall = 0;

	private class Node {
		Object objekt;
		Node neste;

		Node(Object o) {
			if (o != null) {
				this.objekt = o;
			} else {
				System.out.println("FEIL: Prøver å sette inn ingenting!");
			}
		}
		
		Node fjernSlettbareNoderBakerst() {
			if(neste != null) {
				Node front = neste.fjernSlettbareNoderBakerst();
				if(front.objekt instanceof Slettbar) {
					this.neste = null;
				} else {
					if(this == første) {
						if(this instanceof Slettbar) {
							return null;
						} else {
							return this;
						}
					}
					return front;
				}
			}
			return this;
		}
	}
	
	boolean sjekkOmLike(Beholder inn) {
		if(this.antall != inn.antall) {
			return false;
		} else {
			for(int i = 0; i < this.antall; i++) {
				if(this.hent() != inn.hent()) {
					return false;
				}
			}
		}
		return true;
	}

	void fjern(Object o) {
		if (antall > 0) {
			if (første.objekt.equals(o)) {
				første = første.neste;
				antall--;
				iterator = første;
			} else {
				Node forrige = første;
				Node denne = første.neste;
				while (denne != null && !denne.objekt.equals(o)) {
					forrige = denne;
					denne = denne.neste;
				}
				if (denne != null && denne.objekt.equals(o)) {
					forrige.neste = denne.neste;
					antall--;
					iterator = første;
				}
			}
		}

		iterator = første;
	}

	void settInn(Object o) {
		if (o != null) {
			fjern(o);
		}
		Node n = new Node(o);
		n.neste = første;
		første = n;
		antall++;
		iterator = første;
	}

	Object hent() {
		if (første == null) {
			return null;
		} else {
			Node tmp = iterator;
			if (iterator != null) {
				iterator = iterator.neste;
				return tmp.objekt;
			} else {
				return null;
			}
		}

	}

	int antall() {
		return antall;
	}

	void ovfAlleFraBeholder(Beholder b) {
		while (b.antall() > 0) {
			Object o = b.hent();
			settInn(o);
			b.fjern(o);
		}
	}
}

public class Main {
	public static void main(String[] a) {
		new Test();
	}
}

class Test {
	Test() {
		Beholder b = new Beholder();

		Person p1 = new Person("Per");
		Person p2 = new Person("son");

		Student s1 = new Student("s1", 1);
		Student s2 = new Student("s1", 1);
		Student s3 = new Student("s3", 3);

		Eple e1 = new Eple();
		Eple e2 = new Eple();

		Kiwi k1 = new Kiwi();
		Kiwi k2 = new Kiwi();

		Banan b1 = new Banan();

		b.settInn(p1);
		b.settInn(p2);
		b.settInn(s1);
		b.settInn(s2);
		b.settInn(s3);
		b.settInn(e1);
		b.settInn(e2);
		b.settInn(k1);
		b.settInn(k2);
		b.settInn(b1);

		while (b.antall() > 0) {
			Object o = b.hent();
			System.out.println(o);
			b.fjern(o);
		}

		b.settInn(e2);
		b.settInn(e2);
		System.out.println(b.hent());
		System.out.println(b.hent());
	}
}
