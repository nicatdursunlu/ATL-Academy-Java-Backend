package lesson_20_serialization_and_reflection.serialization_task;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        User user1 = new User("Nijat", "Dursunlu", "nijatdursunlu@gmail.com", 94.8);

        serializeToXML(user1);

        User loadedUser = deserializeXml();
        System.out.println(loadedUser);
    }

    public static void serializeToXML(User user) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream
                    ("src/lesson_20_serialization_and_reflection/serialization_task/user.xml");
            XMLEncoder encoder = new XMLEncoder(fileOutputStream);
            encoder.writeObject(user);
            encoder.close();
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static User deserializeXml() throws IOException {
        FileInputStream fileInputStream = new FileInputStream
                ("src/lesson_20_serialization_and_reflection/serialization_task/user.xml");
        XMLDecoder decoder = new XMLDecoder(fileInputStream);
        User decodedUser = (User) decoder.readObject();
        decoder.close();
        fileInputStream.close();
        return decodedUser;
    }
}
