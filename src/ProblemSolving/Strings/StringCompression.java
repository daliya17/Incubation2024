package ProblemSolving.Strings;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String s){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i=0;i<s.length();i++){
            countConsecutive++;
            if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)){
                compressed.append(s.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < s.length() ? compressed.toString() : s;
    }
}
