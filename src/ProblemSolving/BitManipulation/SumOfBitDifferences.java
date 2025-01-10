package ProblemSolving.BitManipulation;

public class SumOfBitDifferences {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(sumOfBitDifferences(arr));
    }

    public static int sumOfBitDifferences(int[] arr){
        int sum=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if((arr[j] & (1 << i))!=0)
                    count++;
            }
            sum+=(count*(arr.length-count))*2;
        }
        return sum;
    }
}
