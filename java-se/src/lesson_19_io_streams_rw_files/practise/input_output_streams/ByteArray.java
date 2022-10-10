package lesson_19_io_streams_rw_files.practise.input_output_streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArray {

    public static void main(String[] args) {
        String path1 = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/array1.txt";
        String path2 = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/array2.txt";

        writeToOutputStreams(path1, path2);

        byte[] bytes = {35, 36, 37, 38, 65, 69};
        readFromByteArray(bytes);
    }

    public static void writeToOutputStreams(String path1, String path2) {
        try {

            FileOutputStream outputStream1 = new FileOutputStream(path1);
            FileOutputStream outputStream2 = new FileOutputStream(path2);
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

            arrayOutputStream.write(52);
            arrayOutputStream.writeTo(outputStream1);
            arrayOutputStream.writeTo(outputStream2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromByteArray(byte[] bytes) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        int k;
        while ((k = inputStream.read()) != -1) {
            char ch = (char) k;
            System.out.println("ASCII value: " + k + "; special character is " + ch);
        }
    }
}
