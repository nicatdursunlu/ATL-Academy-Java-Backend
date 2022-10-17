package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {

        String aSimpleString = Stream.of("a", "simple", "string")
                .collect(Collectors.joining()); // "asimplestring"
        System.out.println("A simple string: " + aSimpleString);

        String separatorString = Stream.of("a", "simple", "string")
                .collect(Collectors.joining("-"));  // " a simple string"
        System.out.println("Separate A simple string: " + separatorString);

        String prefixSuffixString = Stream.of("a", "simple", "string")
                .collect(
                        Collectors.joining(" ", "This is ", ".")
                ); // "This is a simple string."
        System.out.println("Prefix and Suffix String: " + prefixSuffixString);


        double avg = Stream.of(1, 2, 3)
                .collect(Collectors.averagingInt(i -> i * 2)); // 4.0
        System.out.println("Average: " + avg);

        long count = Stream.of(1, 2, 3)
                .collect(Collectors.counting()); // 3
        System.out.println("Count: " + count);

        Stream.of(1, 2, 3)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(x -> System.out.println("Max: " + x)); // 3

        Integer sum = Stream.of(1, 2, 3)
                .collect(Collectors.summingInt(i -> i)); // 6
        System.out.println("Sum: " + sum);


        Map<Integer, List<Integer>> map =
                Stream.of(2, 6, 34, 54, 23, 33, 20, 8, 59, 11, 19, 37)
                        .collect(Collectors.groupingBy(i -> i / 10 * 10));
        System.out.println(map);


        List<Integer> stream =
                Arrays.asList(2, 34, 54, 23, 33, 20, 59, 11, 19, 37);
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (Integer i : stream) {
            int key = i / 10 * 10;
            List<Integer> list = map2.get(key);

            if (list == null) {
                list = new ArrayList<>();
                map2.put(key, list);
            }
            list.add(i);
        }
        System.out.println(map2);
    }
}
