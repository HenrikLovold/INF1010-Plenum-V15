
public class Fakultet {
	
	public static void main(String[] args) {
	
		System.out.println(fakRekursiv(5));
	
	}
	
	public static int fakIter(int n) {
		
		int tmp = 1;
		
		for(int i = n; i > 0; i--) {
			tmp = tmp * i;
		}
		
		return tmp;
	}
	
	public static int fakRekursiv(int n) {
		
		if(n > 0) {
			return n*fakRekursiv(n-1);
		}
		return 1;
		
		
	}
}











