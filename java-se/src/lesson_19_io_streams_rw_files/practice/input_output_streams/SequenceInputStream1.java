package lesson_19_io_streams_rw_files.practice.input_output_streams;

import java.io.FileInputStream;
import java.io.SequenceInputStream;

public class SequenceInputStream1 {

    public static void main(String[] args) throws Exception {
        String path1 = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/file1.txt";
        String path2 = "src/lesson_19_io_streams_rw_files/practise/input_output_streams/file2.txt";

        FileInputStream inputStream1 = new FileInputStream(path1);
        FileInputStream inputStream2 = new FileInputStream(path2);

        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);
        int j;
        while ((j = sequenceInputStream.read()) != -1) {
            System.out.print((char) j);
        }

        inputStream1.close();
        inputStream2.close();
        sequenceInputStream.close();
    }
}
