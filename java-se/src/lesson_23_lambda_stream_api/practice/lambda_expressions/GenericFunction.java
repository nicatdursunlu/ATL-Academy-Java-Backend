package lesson_23_lambda_stream_api.practice.lambda_expressions;

public class GenericFunction {

    public static void main(String[] args) {

        GenericInterface<String> f = message -> "Hello, " + message + ".";
        System.out.println(f.getMessage("Lambda Expressions"));

        GenericInterface<Integer> k = i -> i * 10;
        System.out.println(k.getMessage(15));
    }
}
