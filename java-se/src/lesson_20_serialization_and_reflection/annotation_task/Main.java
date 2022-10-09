package lesson_20_serialization_and_reflection.annotation_task;

import lesson_20_serialization_and_reflection.annotation_task.serializer.XmlSerializer;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Student student = new Student();
        student.setName("Nijat");
        student.setSurname("Dursunlu");
        student.setAddress("Azerbaijan, Baku");

        String response = XmlSerializer.serializerToXml(student);
        System.out.println(response);
    }
}
