package lesson_19_io_streams_rw_files.practice.input_output_streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferInputStreamDemo {

    public static void main(String[] args) {

        String path = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/bufferFile.txt";

        try (FileInputStream inputStream = new FileInputStream(path);
             BufferedInputStream buffer = new BufferedInputStream(inputStream)) {

            System.out.println("Available: " + buffer.available());

            int index = 0;
            while ((index = buffer.read()) != -1) {
                System.out.print((char) index);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
