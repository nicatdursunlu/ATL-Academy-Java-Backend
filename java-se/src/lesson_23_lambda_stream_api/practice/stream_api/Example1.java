package lesson_23_lambda_stream_api.practice.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example1 {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list = list
                .stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(list);

        Stream<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100));
        randomNumbers.limit(20).forEach(e -> System.out.print(e + " "));
        System.out.println();

        IntStream integerStream = "123456_abcdefgh".chars();
        integerStream.forEach(p -> System.out.print(p + " "));
        System.out.println();

        Stream<String> stringStream = Stream.of("A$B$C".split("\\$"));
        stringStream.forEach(p -> System.out.print(p + " "));
    }
}
