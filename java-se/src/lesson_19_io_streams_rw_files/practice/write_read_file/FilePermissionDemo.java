package lesson_19_io_streams_rw_files.practice.write_read_file;

import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.security.PermissionCollection;

public class FilePermissionDemo {

    public static void main(String[] args) {
        String path = "src/lesson_19_io_streams_rw_files/practice/write_read_file/test.txt";
        FilePermission file = new FilePermission(path, "write");

        try {
            PermissionCollection permissions = file.newPermissionCollection();
            permissions.add(file);

            if (permissions.implies(new FilePermission(path, "write"))) {
                FileOutputStream outputStream = new FileOutputStream(path);
                outputStream.write(65);
                System.out.println("File changed!");
                outputStream.flush();
                outputStream.close();
            } else {
                System.out.println("Couldn't write to file, this file read only");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
