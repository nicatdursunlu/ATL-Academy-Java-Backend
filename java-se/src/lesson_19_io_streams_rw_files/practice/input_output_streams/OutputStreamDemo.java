package lesson_19_io_streams_rw_files.practice.input_output_streams;

import java.io.FileOutputStream;

public class OutputStreamDemo {

    public static void main(String[] args) {
        String path1 = "src/lesson_19_io_streams_rw_files/practice/input_output_streams/file1.txt";
        try (FileOutputStream outputStream = new FileOutputStream(path1, true)) {
            String directory = System.getProperty("user.dir");
            System.out.println("My directory: " + directory);

            outputStream.write(75);
            System.out.println("Success!");

            String path2 = "src/lesson_19_io_streams_rw_files/practice/input_output_streams/file2.txt";
            FileOutputStream outputStream2 = new FileOutputStream(path2, true);
            String message = "Hello FileOutputStream \n";
            byte[] bytes = message.getBytes();
            outputStream2.write(bytes);
            outputStream2.flush();
            outputStream2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
