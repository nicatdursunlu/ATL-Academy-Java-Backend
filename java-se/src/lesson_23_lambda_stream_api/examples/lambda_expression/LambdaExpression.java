package lesson_23_lambda_stream_api.examples.lambda_expression;

import lesson_23_lambda_stream_api.examples.functional_interface.NameInterface;
import lesson_23_lambda_stream_api.examples.functional_interface.NumberInterface;
import lesson_23_lambda_stream_api.examples.functional_interface.SimpleInterface;

public class LambdaExpression {

    public static void main(String[] args) {

        SimpleInterface s = () -> "Hi there";
        NumberInterface a = n -> 10 * n;
        NameInterface n = ((firstName, lastName) -> firstName + " " + lastName);

        System.out.println(s.say());
        System.out.println(a.getNumber(9));
        System.out.println(n.getFullName("Nijat", "Dursunlu"));
    }
}
