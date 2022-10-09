package lesson_20_serialization_and_reflection.practice.annotations;

import java.lang.reflect.Method;

class Mock {
    @SingleValueAnnotation(value = 20)
    public void getMessage() {
        System.out.println("Hello annotation!");
    }
}

public class AnnotationsExample {
    public static void main(String[] args) throws Exception {

        Mock mock = new Mock();
        mock.getMessage();

        Method method = mock.getClass().getMethod("getMessage");
        SingleValueAnnotation annotation = method.getAnnotation(SingleValueAnnotation.class);
        System.out.println("Value is " + annotation.value() );
    }
}
