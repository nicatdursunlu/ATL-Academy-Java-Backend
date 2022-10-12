package lesson_19_io_streams_rw_files.lecture;

import java.io.IOException;
import java.io.InputStreamReader;

public class ErrorExample {
    public static void main(String[] args) throws IOException {
        InputStreamReader inp = null;
        inp = new InputStreamReader(System.in);

        System.out.println("Enter characters, " + " and '0' toquit.");
        char c;
        do {
            c = (char) inp.read();
            System.out.print(c + " ");
        } while (c != '0');
    }
}
