package ProblemSolving.Strings;

public class MetaStrings {
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "keegs";
        System.out.println(areMetaStrings(s1, s2));
        System.out.println(areMetaStrings("rsting", "string"));
        System.out.println(areMetaStrings("string", "string"));
        System.out.println(areMetaStrings("string", "strung"));
        System.out.println(areMetaStrings("string", "strin"));
        System.out.println(areMetaStrings("Converse", "Conserve"));
    }

    public static boolean areMetaStrings(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        int count = 0;
        int first = -1, second = -1;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(count==1)
                    first = i;
                if(count==2)
                    second = i;
            }
        }
        if(first==-1 || second==-1)
            return false;
        if(first==second)
            return false;
        if(count>2 || count==0)
            return false;
        return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}
