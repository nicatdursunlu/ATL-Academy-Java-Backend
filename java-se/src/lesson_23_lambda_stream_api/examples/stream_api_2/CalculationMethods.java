package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class CalculationMethods {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(57, 38, 37, 54, 2);
        System.out.println("Count: " + list.stream().count()); // 5

        List<String> strings =
                Arrays.asList("Stream", "Operations", "on", "Collections");
        strings.stream()
                .min(Comparator.comparing(String::length))
                .ifPresent(System.out::println); // on

        System.out.println("Sum: " + IntStream.of(28, 4, 91, 30).sum()); // 153
        System.out.println("Average: " + IntStream.of(28, 4, 91, 30).average()); // 38.25


    }
}
