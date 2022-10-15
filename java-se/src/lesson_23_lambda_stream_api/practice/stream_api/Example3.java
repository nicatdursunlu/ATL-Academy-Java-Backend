package lesson_23_lambda_stream_api.practice.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("SAmir");
        names.add("Tural");
        names.add("Anar");
        names.add("Elnur");
        names.add("Famil");
        names.add("Tofig");
        names.add("Senan");

        System.out.println("Start with A:");
        names
                .stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

        System.out.println("Start with A and upper case:");
        names
                .stream()
                .filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("Sort and upper case:");
        names
                .stream()
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("Sort and upper case list:");
        List<String> uppercaseNames = names
                .stream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseNames);

        boolean matchedResult = names.stream().anyMatch(s -> s.startsWith("A"));
        System.out.println("Any Match: " + matchedResult);

        matchedResult = names.stream().allMatch(s -> s.startsWith("A"));
        System.out.println("All Match: " + matchedResult);

        matchedResult = names.stream().noneMatch(s -> s.startsWith("A"));
        System.out.println("None Match: " + matchedResult);

        long totalMatched = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("Total Matched: " + totalMatched);
    }
}
