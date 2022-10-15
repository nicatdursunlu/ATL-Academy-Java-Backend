package lesson_23_lambda_stream_api.practice.lambda_expressions;

@FunctionalInterface
public interface GenericInterface<T> {

    T getMessage(T message);
}
