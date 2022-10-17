package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduction {
    public static void main(String[] args) {

        OptionalInt optionalTotal = IntStream.of(1, 2, 3, 4, 5, 6)
                .reduce(Integer::sum);
        System.out.println("Optional Total: " + optionalTotal.getAsInt());

        int total = IntStream.of(1, 2, 3, 4, 5, 6)
                .reduce(1, Integer::sum);
        System.out.println("Total: " + total);


        int length =
                Stream.of("Parallel", "streams", "are", "great")
                        .reduce(0,
                                (Integer accumInt, String str) -> accumInt + str.length(), //accumulator
                                Integer::sum);//combiner
        System.out.println("Length: " + length);

        int length2 =
                Stream.of("Parallel", "streams", "are", "great")
                        .mapToInt(String::length)
                        .reduce(0, Integer::sum);
        System.out.println("Length2: " + length2);

        int length3 = Stream.of("Parallel", "streams", "are", "great")
                .mapToInt(String::length)
                .sum();
        System.out.println("Length3: " + length3);
        System.out.println();

        List<Integer> list1 =
                Stream.of(1, 2, 3, 4, 5)
                        .collect(
                                () -> new ArrayList<>(),// Creating the container
                                (l, i) -> l.add(i), // Adding an element
                                (l1, l2) -> l1.addAll(l2) // Combining elements
                        );
        System.out.println("List 1: " + list1);

        List<Integer> list2 =
                Stream.of(1, 2, 3, 4, 5)
                        .collect(
                                ArrayList::new,
                                ArrayList::add,
                                ArrayList::addAll
                        );
        System.out.println("List 2: " + list2);


    }
}
