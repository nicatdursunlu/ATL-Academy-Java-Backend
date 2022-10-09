package lesson_20_serialization_and_reflection.lecture.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TransientExample implements Serializable {

    int i = 10, j = 20;
    transient int k = 30;
    transient static int l = 40;
    transient final int m = 50;

    public static void main(String[] args) throws Exception {
        TransientExample input = new TransientExample();

        String fileName = "src/lesson_20_serialization_and_reflection/theory/serialization/atl.txt";
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);

        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TransientExample output =  (TransientExample) ois.readObject();
        System.out.println("i = " + output.i);
        System.out.println("j = " + output.j);
        System.out.println("k = " + output.k);
        System.out.println("m = " + output.m);
    }
}
