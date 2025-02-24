package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args){
        String[] y = {"1","2","15","-7","300"};
        Arrays.sort(y);
        for(int i=0;i<y.length;i++)
        System.out.println(y[i]);
        Consumer<List<String>> delete = (items)->{
            for(int i=0;i<items.size();i++){
                if(items.get(i).length()==0){
                    items.remove(i);
                }
            }
        };
        List<String> names= new ArrayList<>(Arrays.asList("rac","","meg"));
        delete.accept(names);
        System.out.println(names);

        System.out.println(hasned(Arrays.asList(-1,0,1)));
        System.out.println(hasned(Arrays.asList(0,1,2)));
        System.out.println(hasned(Arrays.asList(0,-1,-2)));


       // System.out.println(hasned(new ArrayList<>()));
       // occurances("Ive worked with Angular for three years solid so I have solid frontend experience. I haven’t used React in a live project yet, but I understand its concepts, like components and state management. I’ve explored it through personal learning, and I’m confident I can pick it up quickly if needed.\n","solid");
    }

    public static Boolean[] hasned(List<Integer> list){
        boolean haspos = false;
        boolean hasneg = false;
        for(int i=0;i<list.size();i++){
            haspos = list.get(i)>0;
            hasneg = list.get(i)<0;
        }
        return new Boolean[]{haspos,hasneg};
    }

    public static int next;
    public static void occurances(String str, String s){
        String[] strs = str.split(" ");
        int count=0;
        List<Integer> indexs = new ArrayList<>();
        int length=0;
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals(s)) {
                count++;
                indexs.add(length);
            }
            length+=strs[i].length()+1;
        }


        System.out.println("Number of Occurrences "+count);
        System.out.println("Indexes :");
        for (Integer i:
             indexs) {
            System.out.println(i);
        }
    }
}

// I’ve worked with Angular for three years, so I have solid frontend experience. I haven’t used React in a live project yet, but I understand its concepts, like components and state management. I’ve explored it through personal learning, and I’m confident I can pick it up quickly if needed.
