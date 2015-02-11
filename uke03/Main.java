public class Main {

    public static void main(String[] args) {

        Circle c1 = new Circle(3.0);
        Circle c2 = new Circle(4.0);

        PolygonTest<Circle> pt = new PolygonTest<Circle>();
        pt.test(c1, c2);
    }

}
