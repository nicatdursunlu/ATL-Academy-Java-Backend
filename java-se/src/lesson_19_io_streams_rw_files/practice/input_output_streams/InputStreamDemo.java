package lesson_19_io_streams_rw_files.practice.input_output_streams;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo {

    public static void main(String[] args) {

        String path1 = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/file1.txt";
        String path2 = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/file2.txt";

        try (FileInputStream inputStream = new FileInputStream(path1);
             FileInputStream inputStream2 = new FileInputStream(path2)) {
            int n = inputStream.read();
            System.out.println("Result: " + (char) n);

            int index = 0;
            while ((index = inputStream2.read()) != -1) {
                System.out.print((char) index);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
