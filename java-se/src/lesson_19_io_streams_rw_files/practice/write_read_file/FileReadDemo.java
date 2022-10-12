package lesson_19_io_streams_rw_files.practice.write_read_file;

import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {

    public static void main(String[] args) {

        String path = "src/lesson_19_io_streams_rw_files/practice/write_read_file/message.txt";

        try (FileReader reader = new FileReader(path)) {

            int index;
            while ((index = reader.read()) != -1) {
                System.out.print((char) index);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
