package lesson_20_serialization_and_reflection.theory.reflection_api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Atl {
    public void printMessage(String message) {
        System.out.println("You invoked me the message: " + message);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Invoke method by Name in Java using Reflection!");
        Atl obj = new Atl();

        Class<?> classObj = obj.getClass();
        Method printMessage = classObj.getDeclaredMethod("printMessage", String.class);

        try {
            printMessage.invoke(obj, "Hello");
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
