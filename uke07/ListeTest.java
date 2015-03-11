
public class ListeTest {

	public static void main(String[] args) {
		RekursivListe<String> liste = new RekursivListe<String>();
	
		System.out.println(liste.settInn("Ole"));
		System.out.println(liste.settInn("Dole"));
		System.out.println(liste.settInn("Doff"));
		
		System.out.println("\n=== PREFIX ===");
		liste.skrivUtPrefix();
		System.out.println("\n=== POSTFIX ===");
		liste.skrivUtPostfix();
		
		RekursivListe<Square> squareListe = new RekursivListe<Square>();
		
		for (int i = 0; i < 10; i++) {
			squareListe.settInn(new Square(i));
		}
		System.out.printf("\n Firkanter: \n");
		
		for (Square s : squareListe) {
			System.out.println(s.area());
		}
		
	}
}
