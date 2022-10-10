package lesson_19_io_streams_rw_files.task;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {

        String path1 = "src/lesson_19_io_streams_rw_files/task/file1.txt";
        String path2 = "src/lesson_19_io_streams_rw_files/task/file2.txt";
        String path3 = "src/lesson_19_io_streams_rw_files/task/file3.txt";
        String path4 = "src/lesson_19_io_streams_rw_files/task/file4.txt";

        FileInputStream input1 = new FileInputStream(path1);
        FileInputStream input2 = new FileInputStream(path2);
        FileInputStream input3 = new FileInputStream(path3);
        FileInputStream input4 = new FileInputStream(path4);

        Vector<InputStream> inputStreams = new Vector<>();
        inputStreams.add(input1);
        inputStreams.add(input2);
        inputStreams.add(input3);
        inputStreams.add(input4);

        Enumeration<InputStream> enumeration = inputStreams.elements();
        SequenceInputStream sis = new SequenceInputStream(enumeration);

        int j;
        while ((j = sis.read()) != -1) {
            System.out.print((char) j);
        }
        sis.close();
        input1.close();
        input2.close();
        input3.close();
        input4.close();
    }
}
