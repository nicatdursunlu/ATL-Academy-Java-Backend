package lesson_19_io_streams_rw_files.practise.input_output_streams;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutputStreamDemo {

    public static void main(String[] args) {

        String path = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/bufferFile.txt";

        try (FileOutputStream outputStream = new FileOutputStream(path, true);
             BufferedOutputStream buffer = new BufferedOutputStream(outputStream)) {

            String city = "London";
            byte[] bytes = city.getBytes();
            buffer.write(bytes);
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
