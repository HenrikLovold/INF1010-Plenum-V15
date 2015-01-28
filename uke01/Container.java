public class Container<E> {

    private E object;

    public void put(E object) {
        this.object = object;
    }

    public E take() {
        return this.object;
    }
}
