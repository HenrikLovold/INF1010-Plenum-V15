public class SquareContainer {

    private Square square;

    public void put(Square square) {
        this.square = square;
    }

    public Square take() {
        return this.square;
    }
}
