class Main {
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		System.out.println("Iter: ");
		System.out.println(fib.fibIter(20));
		System.out.println("Rec: ");
		System.out.println(fib.fibRec(20));
	}
}
