package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateTerminalOperations {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Reflection", "Collection", "Stream");

        String result = words
                .stream()
                .filter(s -> s.startsWith("C"))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid key"));
        System.out.println("StartsWith: " + result);

        int sum = words
                .stream()
                .mapToInt(String::length)
                .reduce(2, Integer::sum);
        System.out.println("Sum: " + sum);

        int multiplication = words
                .stream()
                .mapToInt(String::length)
                .reduce(2, (a, b) -> a * b);
        System.out.println("Multiplication: " + multiplication);

        List<List<String>> listOfWords = Arrays.asList(
                Arrays.asList("1-word-1", "1-word-2", "1-word-3"),
                Arrays.asList("2-word-1", "2-word-2", "2-word-3"),
                Arrays.asList("3-word-1", "3-word-2", "3-word-3")
        );

        List<List<Integer>> listOfList = listOfWords.stream()
                .map(l -> l.stream().map(String::length))
                .map(stream -> stream.collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(listOfList);

        List<Integer> list = listOfWords.stream()
                .flatMap(s -> s.stream().map(String::length))
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
