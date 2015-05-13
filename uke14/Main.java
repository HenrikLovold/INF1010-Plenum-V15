public class Main {
	public static void main(String[] args) {
		String[] navn = new String[] { "a", "b", "b", "b", "c", "c", "d" };
		Frekvens<String> frekvens = new Frekvens<String>(navn);
		System.out.println(frekvens);
		frekvens.likeSammen();
		System.out.println(frekvens);
		System.out.println(frekvens.hentFlestAntallet());
		System.out.println(frekvens.hentFlestObjektet());
	}
}

class Frekvens<T> {
	
	private T[] objekter;
	private Node første;
	private T flestObjekt;
	private int flestAntall;
	private int[] antall;

	Frekvens(T[] objekter) {
		this.objekter = objekter;
		if (objekter != null) {
			første = new Node(objekter[0]);
			Node tmp = første;
			for (int i = 1; i < objekter.length; i++) {
				tmp.neste = new Node(objekter[i]);
				tmp = tmp.neste;
			}
		}
	}
	
	public void lagAlleAntall() {
		antall = new int[flestAntall-1];
		
		Node tmp = første;
		while((tmp = tmp.neste) != null) {
			antall[tmp.antall-1]++;
		}
	}
	
	public int hentAntall(int ant) {
		if(ant > 0 && ant < flestAntall) {
			return antall[ant];
		}
		return 0;
	}
	
	public String toString() {
		String s = "";
		Node tmp = første;
		while (tmp != null) {
			s += tmp.objekt + ": " + tmp.antall + "\n";
		}
		return s;
	}
	
	public void likeSammen() {
		flestAntall = 1;
		flestObjekt = første.objekt;
		Node tmp = første;
		for (int i = 0; i < objekter.length - 1; i++) {
			if (tmp.objekt.equals(tmp.neste.objekt)) {
				tmp.antall++;
				if (tmp.antall > flestAntall) {
					flestAntall = tmp.antall;
					flestObjekt = tmp.objekt;
				}
				tmp.neste = tmp.neste.neste;
				
			} else {
				tmp = tmp.neste;
			}
		}
	}
	
	public T hentFlestObjektet() {
		return flestObjekt;
	}
	
	public int hentFlestAntallet() {
		return flestAntall;
	}
	
	
	class Node {
		Node neste;
		T objekt;
		int antall;
		
		Node(T objekt) {
			this.objekt = objekt;
			this.antall = 1;
		}
	}
}

abstract class Emballasje {
	int volum;
	String id;

	Emballasje(int volum, String id) {
		this.volum = volum;
		this.id = id;
	}
}

abstract class Plastemballasje extends Emballasje {
	public Plastemballasje(int volum, String id) {
		super(volum, id);
	}
}

abstract class Pappemballasje extends Emballasje {
	int vekt;

	public Pappemballasje(int volum, String id, int vekt) {
		super(volum, id);
		this.vekt = vekt;
	}

}

interface Nedbrytbar {
	public int getTid();
}

interface Pant {
	public int getPant();

	public String getTekst();
}

abstract class PlastPant extends Plastemballasje implements Pant {

	private int pant;
	private String tekst;
	
	public PlastPant(int volum, String id, int pant, String tekst) {
		super(volum, id);
		this.pant = pant;
		this.tekst = tekst;
	}

	public int getPant() {
		return pant;
	}

	public String getTekst() {
		return tekst;
	}

}

class LitenPlastPant extends PlastPant {
	public LitenPlastPant(int volum, String id, int pant, String tekst) {
		super(volum, id, 100, tekst);
	}
}

class LitenNedbrytbarPlastPant extends LitenPlastPant implements Nedbrytbar {

	private int tid;
	
	public LitenNedbrytbarPlastPant(int volum, String id, int pant, String tekst, int tid) {
		super(volum, id, 100, tekst);
		this.tid = tid;
	}

	public int getTid() {
		return tid;
	}

}

class StorNedbrytbarPappPant extends Pappemballasje implements Nedbrytbar, Pant {

	private int pant;
	private String tekst;
	private int tid;
	
	public StorNedbrytbarPappPant(int volum, String id, int pant, String tekst, int tid, int vekt) {
		super(volum, id, vekt);
		this.pant = pant;
		this.tekst = tekst;
		this.tid = tid;
	}

	public int getPant() {
		return pant;
	}

	public String getTekst() {
		return tekst;
	}

	public int getTid() {
		return tid;
	}
}