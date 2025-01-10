package ProblemSolving.Arithmetic;

public class ModularExponentiation {
    public static void main(String[] args) {
        System.out.println(modularExponentiation(2, 5, 13));
    }

    public static int modularExponentiation(int x, int y, int p){
       if(x==0)
           return 0;
    // recursive
       if(y==0)
           return 1;
       int temp = modularExponentiation(x,y/2,p);
       temp = (temp*temp)%p;
       if(y%2==0)
           return temp;
       else
           return (x*temp)%p;
       
    }
}
