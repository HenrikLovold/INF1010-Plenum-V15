import java.util.*;
import java.io.*;

public class Kontroll {
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public static Dokument hentDokument(String filnavn) {
		return new Dokument(filnavn);
	}

	public static void lagre(String filnavn, String innhold) {
		try {
			PrintWriter pw = new PrintWriter(new File(filnavn));
			
			pw.write(innhold);
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
