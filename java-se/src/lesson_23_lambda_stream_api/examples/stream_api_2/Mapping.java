package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mapping {
    public static void main(String[] args) {
        Stream.of('a', 'b', 'c', 'd', 'e')
                .map(c -> (int) c)
                .forEach(i -> System.out.format("%d ", i));
        System.out.println();

        IntStream.of(100, 110, 120, 130, 140)
                .mapToDouble(i -> i / 3.0)
                .forEach(i -> System.out.format("%.2f ", i));
        System.out.println();

        List<Character> aToD = Arrays.asList('a', 'b', 'c', 'd');
        List<Character> eToG = Arrays.asList('e', 'f', 'g');
        Stream<List<Character>> stream = Stream.of(aToD, eToG);

        stream
                .flatMap(Collection::stream)
                .forEach(i -> System.out.format("%c ", i));
        System.out.println();

        Stream.of(aToD, eToG)
                .flatMap(Collection::stream)
                .peek(System.out::print)
                .map(c -> (int) c)
                .forEach(i -> System.out.format("-%d ", i));
    }
}
