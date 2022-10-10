package lesson_23_lambda_stream_api.lecture.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // create a list of strings
        List<String> names = Arrays.asList("Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> p = (s) -> s.startsWith("G");

        // Iterate through the list
        for (String name : names) {
            // call the test method
            if (p.test(name)) {
                System.out.println(name);
            }
        }
    }
}
