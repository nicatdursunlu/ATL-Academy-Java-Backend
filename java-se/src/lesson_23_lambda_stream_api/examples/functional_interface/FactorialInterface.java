package lesson_23_lambda_stream_api.examples.functional_interface;

@FunctionalInterface
public interface FactorialInterface {

    int factorial(int a);

    default String getName() {
        return "";
    }

    default String getSurname() {
        return "";
    }
}
