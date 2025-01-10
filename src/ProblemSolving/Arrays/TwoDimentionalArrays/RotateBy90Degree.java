package ProblemSolving.Arrays.TwoDimentionalArrays;

public class RotateBy90Degree {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printArray(arr);
        rotateBy90Degree(arr);
        printArray(arr);
        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printArray(arr1);
        rotateBy90Degree(arr1);
        printArray(arr1);
    }

    public static void rotateBy90Degree(int[][] arr){
        // reverse the rows
        for(int i=0;i<arr.length;i++){
            int j=0,k=arr.length-1;
            while (j<k){
               int temp=arr[i][j];
                arr[i][j]=arr[i][k];
                arr[i][k]=temp;
                j++;
                k--;
            }
        }
        // transpose the matrix
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){ // j=i+1 to avoid swapping the diagonal elements
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }

    public static void printArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
