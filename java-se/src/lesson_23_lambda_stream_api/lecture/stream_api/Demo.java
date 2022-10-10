package lesson_23_lambda_stream_api.lecture.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        // Create an ArrayList with elements
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
        System.out.println("Numbers:" + numbers);

        // demonstration of map method
        List<Integer> square = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("Square " + square);

        // create a list of String
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        System.out.println("Names: " + names);

        // demonstration of filter method
        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println("Filter: " + result);

        // demonstration of sorted method
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);

        // collect returns a set
        Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println("Square Set: " + squareSet);

        // demonstration of forEach method
        System.out.println("Squares with forEach method: ");
        numbers.stream().map(x -> x * x).forEach(y -> System.out.print(y + " "));
        System.out.println();

        // demonstration of reduce method
        int even = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        System.out.println("Sum of even numbers: " + even);
    }
}
