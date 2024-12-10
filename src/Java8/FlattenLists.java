package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattenLists {
    public static void main(String[] args) {
        // Flatten a list of lists
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(listOfAllIntegers); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Flatten a list  of lists
        List<List<List<Integer>>> listOfListOfLists = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6),
                        Arrays.asList(7, 8, 9)
                ),
                Arrays.asList(
                        Arrays.asList(10, 11, 12),
                        Arrays.asList(13, 14, 15),
                        Arrays.asList(16, 17, 18)
                )
        );
        List<Integer> listOfAllIntegers2 = listOfListOfLists.stream()
                .flatMap(listOfLists2 -> listOfLists2.stream().flatMap(List::stream))
                .toList();
        System.out.println(listOfAllIntegers2); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]


        // flatten deeply nested lists
        List<List<List<List<Integer>>>> listOfListOfListOfLists = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(4, 5, 6),
                                Arrays.asList(7, 8, 9)
                        ),
                        Arrays.asList(
                                Arrays.asList(10, 11, 12),
                                Arrays.asList(13, 14, 15),
                                Arrays.asList(16, 17, 18)
                        )
                ),
                Arrays.asList(
                        Arrays.asList(
                                Arrays.asList(19, 20, 21),
                                Arrays.asList(22, 23, 24),
                                Arrays.asList(25, 26, 27)
                        ),
                        Arrays.asList(
                                Arrays.asList(28, 29, 30),
                                Arrays.asList(31, 32, 33),
                                Arrays.asList(34, 35, 36)
                        )
                )
        );
        List<Integer> listOfAll = listOfListOfListOfLists.stream()
                .flatMap(list->list.stream().flatMap(list1->list1.stream().flatMap(List::stream)))
                .collect(Collectors.toList());
        System.out.println(listOfAll);

        // a deeply nested list
        List<Object> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, Arrays.asList(4, 5, Arrays.asList(6))),
                7
        );
        List<Integer> result = flatten(nestedList);
        System.out.println(result);


        // A list with mixed types (list, string, integer)
        List<Object> mixedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, "hello", Arrays.asList(4, 5)),
                "world", 6
        );

        List<Object> getMixedList = flattenMixed(mixedList);
        System.out.println(getMixedList);
    }




    public static List<Object> flattenMixed(List<Object> mixedList){
        return mixedList.stream()
                .flatMap(item->item instanceof List ? flattenMixed((List<Object>) item).stream(): Stream.of((Object) item))
                .collect(Collectors.toList());
    }

    public static List<Integer> flatten(List<Object> nestedList){
        return nestedList.stream().flatMap(item -> item instanceof List ? flatten((List<Object>) item).stream(): Stream.of((Integer) item))
                .collect(Collectors.toList());
    }

}
