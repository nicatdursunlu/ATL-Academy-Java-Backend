package lesson_23_lambda_stream_api.lecture.functional_interface;

public class Demo {
    public static void main(String[] args) {
        int a = 5;

        // lambda expression to define the calculate method
        Square s = (int x) -> x * x;
        // parameter passed and return type must be same as defined in the prototype
        int answer = s.calculate(a);
        System.out.println(answer);
    }
}
