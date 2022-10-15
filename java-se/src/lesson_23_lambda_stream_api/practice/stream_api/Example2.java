package lesson_23_lambda_stream_api.practice.stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();

        Integer[] evenNumbers = stream
                .filter(i -> i % 2 == 0)
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(evenNumbers));
    }
}
