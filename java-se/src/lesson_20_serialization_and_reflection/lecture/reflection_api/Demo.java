package lesson_20_serialization_and_reflection.lecture.reflection_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String args[]) throws Exception {
        Test obj = new Test();

        Class cls = obj.getClass();
        System.out.println("The name of class is " + cls.getName());

        Constructor constructor = cls.getConstructor();
        System.out.println("The name of constructor is " + constructor.getName());

        System.out.println("The public methods of class are ");
        Method[] methods = cls.getMethods();
        for (Method method : methods)
            System.out.println(method.getName());

        Method methodCall1 = cls.getDeclaredMethod("method2", int.class);
        methodCall1.invoke(obj, 19);

        Field field = cls.getDeclaredField("s");
        field.setAccessible(true);
        field.set(obj, "JAVA");

        Method methodCall2 = cls.getDeclaredMethod("method1");
        methodCall2.invoke(obj);

        Method methodCall3 = cls.getDeclaredMethod("method3");
        methodCall3.setAccessible(true);
        methodCall3.invoke(obj);
    }
}