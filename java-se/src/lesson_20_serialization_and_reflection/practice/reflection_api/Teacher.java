package lesson_20_serialization_and_reflection.practice.reflection_api;

public class Teacher {
    private String name;
    private String surname;
    private String phoneNumber;
    public String address;

    public Teacher() {
    }

    public Teacher(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    private String returnSth() {
        return "Hi";
    }
}
