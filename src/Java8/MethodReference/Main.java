package Java8.MethodReference;

public class Main {
//    Method reference is used to refer method of functional interface.
//    It is compact and easy form of lamda expression.
//    Each time when you are using lamda expression to just referring a method, you can replace your lamda expression with method reference.

    public static void main(String[] args) {
        Square square = new Square(5);
        Shapes shape = new Shapes() {
            @Override
            public int getArea(Square s) {
                return s.getArea(s);
            }
        };
        System.out.println(shape.getArea(square));

        // using lamda expression
        Shapes shape1 = (s)->{
            return s.getArea(s);
        };
        System.out.println(shape1.getArea(square));

        // using method reference
        Shapes shape2 = square::getArea;
        System.out.println(shape2.getArea(square));
    }
}
