package Java8.MethodReference;

public class Square {

    public int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }


    public int getArea(Square s) {
        return s.sideLength * s.sideLength;
    }
}
