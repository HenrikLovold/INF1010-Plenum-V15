class Bygning {
	
	Bygning(double bruttoAreal) {
		System.out.printf("Dette er en bygning med %.2f areal.\n", bruttoAreal);
	}
}

class Skyskraper extends Bygning {

	Skyskraper(double bruttoAreal, int antallEtasjer) {
		super(bruttoAreal);
		System.out.printf("Dette er en skyskraper med %d etasjer. \n", antallEtasjer);
	}
}

public class Oppgave {
	public static void main(String[] args) {
		Skyskraper s = new Skyskraper(1000, 30);
	}
}
