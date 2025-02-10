package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap {
    public static void main(String[] args){
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        List<List<Integer>> list = new ArrayList<>(List.of(list1, list2));
       // List<List<Integer>> lists=
        System.out.println(list.stream().map(l->l.stream().map(i->i*i).toList()).toList());
        System.out.println( list.stream().flatMap(l->l.stream().map(x->x*x)).collect(Collectors.toList()));

    }
}
