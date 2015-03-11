
class Fibonacci {
	int counter = 0;
	
	public int fibIter(int n) {
		counter = 0;
		int[] fib = new int[n+1];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for (int i = 2; i < fib.length; i++) {
			System.out.println(counter++);
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		counter = 0;
		return fib[n];
	}
	
	public int fibRec(int n) {
		System.out.println(counter++);
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibRec(n-1) + fibRec(n-2);
		}
	}
}
