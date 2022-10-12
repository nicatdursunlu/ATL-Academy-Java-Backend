package lesson_19_io_streams_rw_files.lecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderExample {
    public static void main(String[] args) throws IOException {
        String source = "src/lesson_19_io_streams_rw_files/lecture/atl.txt";
        FileReader fr = new FileReader(source);
        BufferedReader br = new BufferedReader(fr);

        char[] c = new char[20];
        if (br.markSupported()) {
            System.out.println("mark() method is supported");

            //illustrating mark method
            br.mark(100);
        }

        // skipping 8 characters
        br.skip(8);
        if (br.ready()) {
            // illustrating readLine() method
            System.out.println(br.readLine());

            // illustrating read(char c[],int off,int len)
            br.read(c);
            for (int i = 0; i < 20; i++) {
                System.out.print(c[i]);
            }
            System.out.println();

            // illustrating reset() method
            br.reset();
            for (int i = 0; i < 8; i++) {
                //illustrating read() method
                System.out.print((char) br.read());
            }
        }
    }
}

