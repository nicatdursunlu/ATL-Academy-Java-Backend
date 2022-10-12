package lesson_19_io_streams_rw_files.lecture;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) throws IOException {

        String source = "src/lesson_19_io_streams_rw_files/lecture/atl.txt";
        String target = "src/lesson_19_io_streams_rw_files/lecture/academy.txt";

        try (FileInputStream sourceStream = new FileInputStream(source);
             FileOutputStream targetStream = new FileOutputStream(target)) {

            int temp;
            while ((temp = sourceStream.read()) != -1) {
                targetStream.write(temp);
            }
        }
    }
}
