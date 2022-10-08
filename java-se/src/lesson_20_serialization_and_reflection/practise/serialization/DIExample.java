package lesson_20_serialization_and_reflection.practise.serialization;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DIExample {

    public static void printMessage(String message) {
        System.out.println("You invoked the message: " + message);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Invoke method by Name");

        DIExample obj = new DIExample();

        Class classObj = obj.getClass();
        Method printMessage = classObj.getDeclaredMethod("printMessage", String.class);

        try {
            printMessage.invoke(obj, "hello");
        } catch (InvocationTargetException e) {
            System.out.println(e.getCause());
        }
    }
}
