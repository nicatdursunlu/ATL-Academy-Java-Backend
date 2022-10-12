package lesson_19_io_streams_rw_files.lecture;

import java.io.FileReader;
import java.io.IOException;

public class CharacterStreamExample {
    public static void main(String[] args) throws IOException {
        String source = "src/lesson_19_io_streams_rw_files/lecture/atl.txt";

        try (FileReader sourceStream = new FileReader(source)) {
            int temp;
            while ((temp = sourceStream.read()) != -1) {
                System.out.print((char) temp);
            }
        }
    }
}
