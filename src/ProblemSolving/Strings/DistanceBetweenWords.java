package ProblemSolving.Strings;

public class DistanceBetweenWords {
    public static void main(String[] args) {
        String str = "geeks for geeks contribute practice";
        String word1 = "geeks";
        String word2 = "practice";
      //  System.out.println(distanceBetweenWords(str, word1, word2));
        System.out.println(distanceBetweenWords("the quick the brown quick brown the frog","quick","frog"));
    }

    public static int distanceBetweenWords(String str, String word1, String word2){
        String word3 = new String("quick");
        System.out.println(word1==word3); // cheecks refernce
        System.out.println(word1.equals(word3));// only content
        String[] words = str.split(" ");
        int index1=-1,index2=-1,min=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1))
                index1=i;
            if(words[i].equals(word2))
                index2=i;
            if(index2!=-1 && index2!=-1)
                min=Math.min(min, Math.abs(index1-index2));
        }

        return min;
    }
}
