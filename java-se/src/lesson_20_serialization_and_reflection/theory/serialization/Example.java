package lesson_20_serialization_and_reflection.theory.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example {
    public static void main(String[] args) throws IOException {
        Demo demo = new Demo(1, "ATL Academy");
        String fileName =  "src/lesson_20_serialization_and_reflection/theory/serialization/lesson.txt";

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(demo);
            out.close();
            file.close();

            System.out.println("Object has been serialized!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
