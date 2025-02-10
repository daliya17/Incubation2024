package ProblemSolving.Strings;

public class ZigZgString {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

//    public static String convert(String s, int numRows) {
//        StringBuilder result = new StringBuilder("");
//        int i = 0, j = 0;
//        int flag=1;
//        StringBuilder[] ans = new StringBuilder[numRows];
//        for (int k = 0; k < numRows; k++) {
//            ans[k] = new StringBuilder();
//        }
//        while (j < s.length()) {
//            if(i==-1)
//                i+=2;
//            if (flag==1) {
//                List<Integer> res1 = down(i, ans, s, j, numRows);
//                i = res1.get(0);
//                j = res1.get(1);
//                flag = res1.get(2);
//            }
//            else {
//                List<Integer> res2 = up(i, ans, s, j, numRows);
//                i = res2.get(0);
//                j = res2.get(1);
//                flag=res2.get(2);
//            }
//
//        }
//        for (StringBuilder row : ans) {
//            result.append(row);
//        }
//        return result.toString();
//    }
//
//    public static List<Integer> up(int row, StringBuilder[] ans , String s, int index, int rows) {
//        if(row==rows)
//            row-=2;
//        while (row >= 0 && index<s.length()) {
//            ans[row].append(s.charAt(index));
//            row--;
//            index++;
//        }
//        return new ArrayList<>(List.of(row, index,1));
//    }
//
//    public static List<Integer> down(int row,  StringBuilder[] ans , String s, int index, int rows) {
//        while (row < rows && index<s.length()) {
//            ans[row].append(s.charAt(index));
//            row++;
//            index++;
//        }
//        return new ArrayList<>(List.of(row, index,0));
//    }

    // easier approach
    public static String convert(String s, int numRows){
        if(numRows==1|| s.length()<=numRows)
            return s;
        StringBuilder[] ans = new StringBuilder[numRows];
        int currentRow=0;
        boolean goingDown=false;
        for(int i=0;i<numRows;i++)
            ans[i]=new StringBuilder();
        for(char c: s.toCharArray()){
            ans[currentRow].append(c);
            if(currentRow==0 || currentRow==numRows-1)
                goingDown=!goingDown;
            currentRow+=goingDown?1:-1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder row: ans){
            result.append(row);
        }
     return result.toString();
    }
}
