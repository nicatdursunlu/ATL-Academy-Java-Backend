package lesson_23_lambda_stream_api.examples.lambda_expression;

interface FuncInterface<T> {
    T func(T t);
}

public class GenericLambdaExpression {

    public static void main(String[] args) {

        FuncInterface<String> t;
        t = word -> word + " #8";
        System.out.println(t.func("Session"));
    }
}
