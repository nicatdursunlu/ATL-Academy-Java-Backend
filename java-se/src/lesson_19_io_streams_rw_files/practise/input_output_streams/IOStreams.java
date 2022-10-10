package lesson_19_io_streams_rw_files.practise.input_output_streams;

import java.io.IOException;

public class IOStreams {
    public static void main(String[] args) throws IOException {

        System.out.println("Hi");
        System.err.println("Not Found Exception!");

        int a = System.in.read(); // return ASCII code of a character
        System.out.println((char) a);
    }
}
