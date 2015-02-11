class Circle implements Polygon, Comparable<Circle> {

	private double radius;

	public Circle(double radius) {
			this.radius = radius;
	}

	public double circumference() {
			return 2*Math.PI*radius;
	}

	public double area() {
			return Math.PI*radius*radius;
	}

	public int compareTo(Circle s) {

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
