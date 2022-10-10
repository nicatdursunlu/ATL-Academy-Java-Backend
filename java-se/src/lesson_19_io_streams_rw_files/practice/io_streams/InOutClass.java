package lesson_19_io_streams_rw_files.practice.io_streams;

import java.io.IOException;

public class InOutClass {
    public static void main(String[] args) throws IOException {

        System.out.print("Hello");
        System.out.println();

        String name = "Nijat";
        System.out.printf("Hello, %s\n", name);

        System.err.println("Exception!");

        int i = System.in.read();
        System.out.println(i);
    }
}
