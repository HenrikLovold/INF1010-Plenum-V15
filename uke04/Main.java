class Main {
	public static void main(String[] args) {
		//Dyr d = new Dyr();
		//d.settAlder(10);
		//d.info();
		
		Elefant f = new Elefant();
		f.settAlder(50);
		f.tut();
		//f.info();
		
		Dyr df = new Elefant();
		df.settAlder(10);
		df.tut();
		//df.info();
		
		Elefant[] elefanter = new Elefant[10];
		Dyr[] dyr = new Dyr[10];
	}
}
