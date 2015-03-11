class Square {
	private double length;
	
	Square(double length) {
		this.length = length;
	}
	
	public double circumference() {
		return 4*length;
	}
	
	public double area() {
		return length*length;
	}
}
