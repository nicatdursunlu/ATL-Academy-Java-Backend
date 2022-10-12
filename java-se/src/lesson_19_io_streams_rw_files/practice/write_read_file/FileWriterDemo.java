package lesson_19_io_streams_rw_files.practice.write_read_file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriterDemo {

    public static void main(String[] args) {
        try {
            String path = "src/lesson_19_io_streams_rw_files/practice/write_read_file/message.txt";
            FileWriter fileWriter = new FileWriter(path);

            List<String> stringList = new ArrayList<>();
            stringList.add("Hello");
            stringList.add("How are you?");

            fileWriter.write(String.valueOf(stringList));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
