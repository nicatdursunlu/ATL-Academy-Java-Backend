package lesson_19_io_streams_rw_files.lecture;

import java.io.File;
import java.io.IOException;

public class FileIOExample {
    public static void main(String[] args) throws IOException {
        String fileName = "src/lesson_19_io_streams_rw_files/lecture/academy.txt";

        File file = new File(fileName);

        System.out.println("File name: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Parent: " + file.getParent());
        System.out.println("Exists: " + file.exists());

        if (file.exists()) {
            System.out.println("Is writable: " + file.canWrite());
            System.out.println("Is readable: " + file.canRead());
            System.out.println("Is a directory: " + file.isDirectory());
            System.out.println("File Size in bytes: " + file.length());
        }
    }
}
