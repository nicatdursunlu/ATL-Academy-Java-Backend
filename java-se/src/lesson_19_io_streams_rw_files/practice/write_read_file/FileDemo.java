package lesson_19_io_streams_rw_files.practice.write_read_file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {

        try {
            String path = "src/lesson_19_io_streams_rw_files/practice/write_read_file/test.txt";
            File file = new File(path);

            System.out.println(file.setWritable(true));
            if (file.createNewFile()) {
                System.out.println("Created new file!");
            } else {
                System.out.println("File has already created!");
            }

            System.out.println("Is it directory: " + file.isDirectory());
            System.out.println("Can I read this file? " + file.canRead());
            System.out.println("Can I write something to this file? " + file.canWrite());

            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write("Hello\n");
            fileWriter.close();


            String directory = System.getProperty("user.dir");
            System.out.println("My directory: " + directory);
            File file2 = new File(
                    directory + "/src/lesson_19_io_streams_rw_files/practice/write_read_file/test");
            System.out.println(file2.mkdirs());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
