import java.util.*;
import java.io.*;

public class Dokument {
	
	private String filnavn;
	private String innhold;
	
	public Dokument(String filnavn) {
		this.filnavn = filnavn;
		this.innhold = "";
		this.lesInnInnhold();
	}
	
	private void lesInnInnhold() {
		try {
			Scanner sc = new Scanner(new File(filnavn));
			
			while(sc.hasNextLine()) {
				innhold += sc.nextLine() + "\n";
			}
			
		} catch (IOException e) {
			System.err.println("Feil ved henting av dokument fra filen " + filnavn);
		}
	}

	public String hentInnhold() {
		return innhold;
	}
}
