package lesson_23_lambda_stream_api.practice.lambda_expressions;

public class LambdaExample {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> System.out.println("Thread 1"));

        Thread thread2 = new Thread(() -> System.out.println("Thread 2"));

        // No parameter
        MyNumber myNumber = () -> 44.5;
        System.out.println("No parameters: " + myNumber.getValue());

        // With one parameter
        FactorialInterface factorial = (a) -> {
            int counter = 1;
            for (int i = 1; i <= a; i++) {
                counter *= i;
            }
            return counter;
        };

        System.out.println("With one parameter: " + factorial.getFactorial(6));

        // With two parameters
        FullName fullName = (name, surname) -> name + " " + surname;
        System.out.println("With two parameters: " + fullName.getFullName("Nijat", "Dursunlu"));
    }
}
