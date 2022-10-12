package lesson_19_io_streams_rw_files.practice.write_read_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {

    public static void main(String[] args) {
        String path = "src/lesson_19_io_streams_rw_files/practice/write_read_file/buffer.txt";

        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter buffer = new BufferedWriter(fileWriter)) {

            buffer.write("Hello BufferWriterDemo class");
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
