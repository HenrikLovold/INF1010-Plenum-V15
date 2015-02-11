
public class PolygonTest<T extends Polygon & Comparable<T>> {

    public void test(T c1, T c2) {

        System.out.println("Areal c1: " + c1.area());
        System.out.println("Areal c2: " + c2.area());

        System.out.println("Omkrets c1: " + c1.circumference());
        System.out.println("Omkrets c2: " + c2.circumference());

        if(c1.compareTo(c2) > 0) {
            System.out.println("c1 er storst");
        } else {
            System.out.println("c2 er storst eller lik c1");
        }
    }
}
