package lesson_20_serialization_and_reflection.theory.serialization;

import java.io.Serializable;

public class Demo implements Serializable {
    public int a;
    public String b;

    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}
