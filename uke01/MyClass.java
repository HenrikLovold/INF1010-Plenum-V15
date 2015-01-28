class Test {
	public static void main (String[] args) {
		Myclass<String> m = new MyClass<String>();
		m.myMethod(42);
	}
}

class MyClass<T> {
	String s;
	T t;
	
	MyClass() {
		s = "I am a string";
	}

	public void myMethod(int i, T t) {
		System.out.println(i);
		System.out.println(t);
	}
}

class MyClass {
	String s;
	String t;
	
	MyClass() {
		s = "I am a string";
	}

	public void myMethod(int i, String t) {
		System.out.println(i);
		System.out.println(t);
	}
}
