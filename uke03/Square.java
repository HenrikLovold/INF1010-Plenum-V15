class Square implements Polygon, Comparable<Square> {

	private double length;

	public Square(double length) {
			this.length = length;
	}

	public double circumference() {
		return 4*length;
	}

	public double area() {
		return length*length;
	}

	public int compareTo(Square s) {

			double compare = this.area() - s.area();

			if(compare > 0) {
					return -1;
			}
			else if(compare == 0) {
					return 0;
			} else {
					return 1;
			}

	}
}
