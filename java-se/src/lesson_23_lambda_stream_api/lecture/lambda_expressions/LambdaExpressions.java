package lesson_23_lambda_stream_api.lecture.lambda_expressions;

import java.util.ArrayList;

public class LambdaExpressions {
    public static void main(String[] args) {
        // Create an ArrayList with elements
        // {1, 2, 3, 4}
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Using lambda expression to print all elements of list
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Using lambda expression to print even elements of list
        System.out.println("Even elements");
        list.forEach(n -> {
            if (n % 2 == 0) System.out.print(n + " ");
        });
    }
}
