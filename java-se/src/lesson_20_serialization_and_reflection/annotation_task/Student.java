package lesson_20_serialization_and_reflection.annotation_task;

import lesson_20_serialization_and_reflection.annotation_task.annotation.XmlFields;

public class Student {
    @XmlFields(value = "NAME")
    private String name;

    @XmlFields(value = "SURNAME")
    private String surname;

    @XmlFields(value = "ADDRESS")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
