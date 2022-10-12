package lesson_19_io_streams_rw_files.practice.write_read_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo   {

    public static void main(String[] args) {
        String path = "src/lesson_19_io_streams_rw_files/practice/write_read_file/buffer.txt";

        try (FileReader reader = new FileReader(path);
             BufferedReader buffer = new BufferedReader(reader)) {

            int index;
            while ((index = buffer.read()) != -1) {
                System.out.print((char) index);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
