package ProblemSolving.Strings;

public class PrintSubStrings {
    public static void main(String[] args) {
        printSubStrings("abc");
    }

    public static void printSubStrings(String s) {
        // Time complexity: O(n^3)
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                System.out.println(s.substring(i, j));
//            }
//        }
        // Time complexity: O(n^2)
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                System.out.println(sb);
            }
        }

    }
}
