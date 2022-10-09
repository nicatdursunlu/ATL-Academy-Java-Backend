package lesson_20_serialization_and_reflection.annotation_task.serializer;

import lesson_20_serialization_and_reflection.annotation_task.Student;
import lesson_20_serialization_and_reflection.annotation_task.annotation.XmlFields;

import java.lang.reflect.Field;

public class XmlSerializer {

    public static String serializerToXml(Student student) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        String tagName;
        Object value;
        result.append("<xml>\n");

        Field[] fields = student.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            XmlFields annotation = field.getAnnotation(XmlFields.class);
            tagName = annotation == null ? field.getName() : annotation.value();
            value = field.get(student);
            result.append("<").append(tagName).append(">").append(value)
                    .append("</").append(tagName).append(">").append("\n");
        }
        result.append("</xml>");
        return  result.toString();
    }
}
