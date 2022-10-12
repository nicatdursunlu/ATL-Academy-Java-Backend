package lesson_19_io_streams_rw_files.lecture;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String fileName = "src/lesson_19_io_streams_rw_files/lecture/lesson.txt";
        String str = "Ulvi Aghajanov";

        FileWriter fileWriter = new FileWriter(fileName);

        for (int i = 0; i < str.length(); i++)
            fileWriter.write(str.charAt(i));

        System.out.println("Writing successful");
        fileWriter.close();
    }
}
