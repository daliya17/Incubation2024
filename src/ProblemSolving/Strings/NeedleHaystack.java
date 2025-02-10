package ProblemSolving.Strings;

public class NeedleHaystack {
    public static void main(String[] args){
//        System.out.println(strStr("Leetcode","Leeto"));
//        System.out.println(strStr("sadbutsad","sad"));
      //  System.out.println(strStr("mississippi","issipi"));
        System.out.println(strStr("abc","c"));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())
            return -1;
        int ans=-1;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=i,k=0;
                while(k<needle.length()&&j<haystack.length()){
                    if(haystack.charAt(j)!=needle.charAt(k)) {
                        ans=-1;
                        break;
                    }
                    if(k==needle.length()-1)
                        ans=i;
                    j++;k++;
                }
                if(ans!=-1)
                    return ans;
            }
        }
        return ans;
    }
}
