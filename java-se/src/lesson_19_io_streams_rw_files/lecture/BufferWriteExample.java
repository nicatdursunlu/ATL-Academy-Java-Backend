package lesson_19_io_streams_rw_files.lecture;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriteExample {
    public static void main(String[] args) {
        String file = "src/lesson_19_io_streams_rw_files/lecture/lesson.txt";
        FileWriter atlFile;
        try {
            atlFile = new FileWriter(file);

            // Initialing BufferedWriter
            BufferedWriter geekWrite = new BufferedWriter(atlFile);
            System.out.println("Buffered Writer start writing :)");

            // Use of write() method to write the value in 'ABC' file
            // Printing E
            geekWrite.write(69);

            // Printing 1
            geekWrite.write(49);

            // Closing BufferWriter to end operation
            geekWrite.close();
            System.out.println("Written successfully");
        } catch (IOException except) {
            except.printStackTrace();
        }

    }
}
