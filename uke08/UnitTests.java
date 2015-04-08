
public class UnitTests {

	public static void main(String[] args) {
		testTabell();
		testSortertEnkelListe();
		testEldsteForstReseptListe();
		testYngsteForstReseptListe();
	}
	
	
	public static boolean testTabell() {
		System.out.println("==== TESTER AV TABELL ====");
		
		Tabell<Lege> t = new Tabell<Lege>(10);
		
		Lege a = new Lege("Geir");
		Lege b = new Lege("Arne");
		Lege c = new Lege("Xing");
		
		checkExpected("settInnPaPlass 101:", t.settInnPaPlass(a, 101), false);
		checkExpected("settInnPaPlass 0:", t.settInnPaPlass(a, 0), true);
		checkExpected("settInnPaPlass 1:", t.settInnPaPlass(b, 1), true);
		checkExpected("settInnPaPlass 3:", t.settInnPaPlass(c, 3), true);
		
		checkExpected("hentObjekt 3:    ", t.hentObjekt(3)==c, true);
		
		boolean stat = true;
		for(Lege l : t) {
			if(l != a && l != b && l != c) {
				stat = false;
			}
		}
		
		checkExpected("Alle leger iterert:", stat, true);
		
		
		return true;
	}
	
	public static boolean testSortertEnkelListe() {
		System.out.println("==== TESTER AV SORTERT ENKEL LISTE ====");
		
		SortertEnkelListe<Lege> l = new SortertEnkelListe<Lege>();
		
		Lege a = new Lege("Geir");
		Lege b = new Lege("Arne");
		Lege c = new Lege("Xing");
		
		checkExpected("settInn(Legen geir)", l.settInn(a), true);
		l.settInn(b);
		l.settInn(c);
		
		checkExpected("finnElement(\"Geir)\"", l.finnElement("Geir")==a, true);
		checkExpected("finnElement(\"BJARTE)\"", l.finnElement("BJARTE-MANN")==a, false);
		
		boolean stat = true;
		for(Lege leg : l) {
			if(leg != a && leg != b && leg != c) {
				stat = false;
			}
		}
		
		checkExpected("Alle leger iterert:", stat, true);
		
		return true;
	}
	
	public static boolean testEldsteForstReseptListe() {
		System.out.println("==== TESTER AV ELDSTE FORST RESEPT LISTE ====");
		
		
		Lege a = new Lege("Geir");
		Lege b = new Lege("Arne");
		Lege c = new Lege("Xing");
		
		Legemiddel d = new APille("Morfin", 599, 40, 9001, 40, 10);
		Legemiddel e = new CPille("Ibux", 599, 40, 40, 10);
		Legemiddel f = new BMikstur("PlaceboSnabidaris", 599, 40, 1337, 40, 10);
		
		Resept g = new BlaResept(d, a, 323232, 77);
		Resept h = new HvitResept(e, b, 323252, 73);
		Resept j = new BlaResept(f, c, 321332, 42);
		
		EldsteForstReseptListe r = new EldsteForstReseptListe();
		
		checkExpected("settInn(en blaa resept)", r.settInn(g), true);
		r.settInn(h);
		r.settInn(j);
		
		checkExpected("finnResept(323232)", r.finnResept(323232)==g, true);
		
		boolean stat = true;
		
		for(Resept res : r) {
			if(res != g && res != h && res != j) {
				stat = false;
			}
		}
		
		checkExpected("Alle resepter iterert:", stat, true);
		
		return true;
	}
	
	public static boolean testYngsteForstReseptListe() {
		System.out.println("==== TESTER AV YNGSTE FORST RESEPT LISTE ====");
		
		Lege a = new Lege("Geir");
		Lege b = new Lege("Arne");
		Lege c = new Lege("Xing");
		
		Legemiddel d = new APille("Morfin", 599, 40, 9001, 40, 10);
		Legemiddel e = new CPille("Ibux", 599, 40, 40, 10);
		Legemiddel f = new BMikstur("PlaceboSnabidaris", 599, 40, 1337, 40, 10);
		
		Resept g = new BlaResept(d, a, 323232, 77);
		Resept h = new HvitResept(e, b, 323252, 73);
		Resept j = new BlaResept(f, c, 321332, 42);
		
		YngsteForstReseptListe r = new YngsteForstReseptListe();
		
		checkExpected("settInn(en blaa resept)", r.settInn(g), true);
		r.settInn(h);
		r.settInn(j);
		
		checkExpected("finnResept(323232)", r.finnResept(323232)==g, true);
		
		boolean stat = true;
		
		for(Resept res : r) {
			if(res != g && res != h && res != j) {
				stat = false;
			}
		}
		
		checkExpected("Alle resepter iterert:", stat, true);
		
		return true;
	}
	
	public static boolean checkExpected(String expl, boolean value, boolean status) {
		System.out.println(expl + "\t" + ((value==status)?"OK":"FAIL"));
		return value == status;
	}
}
