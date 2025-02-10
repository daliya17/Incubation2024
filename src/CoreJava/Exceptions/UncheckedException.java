package CoreJava.Exceptions;

public class UncheckedException {
    public static void main(String[] args){
        try{

//            String str = null;
//            str.toString();
//            Integer x = 3/0;
            String s="abs";
            int num = Integer.parseInt(s);

        }catch (NullPointerException | ArithmeticException e){
            System.out.println("Exception");
        }
        catch (NumberFormatException e){
            System.out.println("Number format Exception");
        }

// arrayindexoutofboundexception
    }
}
