public class TestPlass {
	public static void main(String[] args){
	
		Bil b = new Bil("AB12345", 5);
		Motorsykkel m = new Motorsykkel("AS31311", 500);
		
		Parkeringsplass<Bil> p1 = new Parkeringsplass<Bil>();
		p1.parker(b);
		
		Parkeringsplass<Motorsykkel> p2 = new Parkeringsplass<Motorsykkel>();
		p2.parker(m);
		
		
		
		
	}
	
}
