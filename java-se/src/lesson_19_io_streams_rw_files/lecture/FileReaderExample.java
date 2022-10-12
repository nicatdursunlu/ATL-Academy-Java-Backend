package lesson_19_io_streams_rw_files.lecture;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) throws IOException {

        int ch;
        FileReader fr = null;
        String fileName = "src/lesson_19_io_streams_rw_files/lecture/lesson.txt";
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }
        while ((ch = fr.read()) != -1)
            System.out.print((char) ch);

        fr.close();
    }
}
