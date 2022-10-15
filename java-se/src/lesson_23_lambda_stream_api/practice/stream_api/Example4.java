package lesson_23_lambda_stream_api.practice.stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Example4 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("SAmir");
        names.add("Tural");
        names.add("Anar");
        names.add("Elnur");
        names.add("Famil");
        names.add("Ef");
        names.add("Tofig");
        names.add("Senan");

        Optional<String> min = names
                .stream()
                .min(Comparator.comparingInt(str -> str.charAt(str.length() - 1)));
        System.out.println("Minimum length: " + min.get());

        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
        Integer minValue = list.stream().min(Integer::compareTo).get();
        System.out.println("Minimum value: " + minValue);
    }
}
