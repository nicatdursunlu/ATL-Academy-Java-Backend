package lesson_23_lambda_stream_api.practice.lambda_expressions;

@FunctionalInterface
public interface FactorialInterface {
    long getFactorial(int n);

    default int math() {
        return 3;
    }
}
