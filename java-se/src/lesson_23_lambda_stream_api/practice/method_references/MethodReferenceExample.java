package lesson_23_lambda_stream_api.practice.method_references;

@FunctionalInterface
interface Test {
    int lengthOfString(String input);
}

@FunctionalInterface
interface Test2 {
    void printMessage(String string);
}

public class MethodReferenceExample {

    static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        // Test result = (s) -> s.length();
        // method reference
        Test result = String::length;
        System.out.println(result.lengthOfString("Hello World!"));

        // Test2 result2 = (s) -> System.out.println(s);
        Test2 result2 = System.out::println;
        result2.printMessage("Hello World!");

        // StringFunction stringFunction = str -> MethodReferenceExample.reverseString(str);
        StringFunction stringFunction = MethodReferenceExample::reverseString;
        System.out.println(stringFunction.function("Hello World!"));
    }
}
