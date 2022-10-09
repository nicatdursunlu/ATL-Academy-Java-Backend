package lesson_20_serialization_and_reflection.practice.reflection_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionApi {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher();

        Class obj = teacher.getClass();

        System.out.println("Simple name: " + obj.getSimpleName());
        System.out.println("Name: " + obj.getName());
        System.out.println("Package: " + obj.getPackage());
        System.out.println("-------------------------------");

        Field field = obj.getDeclaredField("name");
        System.out.println("Field: " + field.getName());
        System.out.println("-------------------------------");

        Constructor[] constructors = obj.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());
            System.out.println("Parameter counts: " + constructor.getParameterCount());
        }
        System.out.println("-------------------------------");

        // all fields = public + private
        Field[] fields = obj.getDeclaredFields();
        for (Field field1 : fields) {
            System.out.println("Private fields: " + field1.getName());
        }
        System.out.println("-------------------------------");

        // public fields
        Field[] fields2 = obj.getFields();
        for (Field field1 : fields2) {
            System.out.println("Fields: " + field1.getName());
        }
        System.out.println("-------------------------------");

        Method[] methods = obj.getMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            System.out.println("Access modifier: " + Modifier.toString(method.getModifiers()));
        }
        System.out.println("-------------------------------");

        Method[] methods2 = obj.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println("Method: " + method.getName());
            System.out.println("Access modifier: " + Modifier.toString(method.getModifiers()));
        }
        System.out.println("-------------------------------");
    }
}
