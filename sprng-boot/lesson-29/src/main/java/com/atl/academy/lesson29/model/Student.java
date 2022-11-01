package com.atl.academy.lesson29.model;

import org.springframework.stereotype.Component;

@Component("studentBean")
public class Student {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private double grade;

    public Student() {

    }

    public Student(int id, String name, String surname, String email, String phoneNumber, double grade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Student name is " + name + " " + surname + " and Roll Number is " + id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", grade=" + grade +
                '}';
    }
}
