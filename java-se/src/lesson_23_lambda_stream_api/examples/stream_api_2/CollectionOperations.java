package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperations {

    public static void main(String[] args) {

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("hello", "hola", "hallo", "ciao");
        List<String> limit = words.stream().sorted().limit(2).collect(Collectors.toList());
        System.out.println(limit);

        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long n = IntStream.of(digits).count();
        System.out.println(IntStream.of(digits).findAny().getAsInt()); //
        System.out.println("Count: " + n);

        words.stream().sorted().forEach(System.out::println);

        List<String> wordsList = Arrays.asList("hello", null, "");
        wordsList.stream()
                .filter(Objects::nonNull) // ["hello", ""]
                .filter(t -> !t.isEmpty()) // ["hello"]
                .forEach(System.out::println);

        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        stream.findFirst()
                .ifPresent(System.out::println); // 1

        IntStream stream2 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        stream2.findAny()
                .ifPresent(System.out::println); // 1

    }
}
