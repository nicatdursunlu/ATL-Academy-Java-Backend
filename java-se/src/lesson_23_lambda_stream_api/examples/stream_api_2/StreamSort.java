package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.Arrays;
import java.util.List;

public class StreamSort {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(57, 38, 37, 54, 2);
        list.stream()
                .sorted()
                .forEach(System.out::println);

        List<String> strings =
                Arrays.asList("Stream", "Operations", "on", "Collections");
        strings.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .forEach(System.out::println);
    }
}
