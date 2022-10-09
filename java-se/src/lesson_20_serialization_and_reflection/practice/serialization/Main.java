package lesson_20_serialization_and_reflection.practice.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        User user1 = new User();
        user1.setName("Nijat");
        user1.setSurname("Dursunlu");

        User user2 = new User();
        user2.setName("Alakbar");
        user2.setSurname("Hajizada");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        serializationToBinary(users);
//        serializationToBinary(user2);

        List<User> deSerializedUser = deSerializationFromBinary();
        System.out.println(deSerializedUser);
    }

    public static void serializationToBinary(List<User> user) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("abc.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Success!");
    }

    public static List<User> deSerializationFromBinary() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("abc.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<User> deSerializedUser = (List<User>) objectInputStream.readObject();
        fileInputStream.close();
        fileInputStream.close();
        return deSerializedUser;
    }
}
