package az.atl.academy.lesson31.models;

import org.springframework.beans.factory.annotation.Value;

public class Student {

    @Value("${student.rollNo}")
    private int rollNo;

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private int age;

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
