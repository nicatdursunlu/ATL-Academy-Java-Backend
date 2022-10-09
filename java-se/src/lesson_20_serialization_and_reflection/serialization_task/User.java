package lesson_20_serialization_and_reflection.serialization_task;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String surname;
    private String email;
    private double grade;

    public User() {
    }

    public User(String name, String surname, String email, double grade) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", grade=" + grade +
                '}';
    }
}
