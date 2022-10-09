package lesson_21_multithreading.lecture.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderDemo {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd.exe", "/c", "dir");
        processBuilder.directory(new File("lesson_21_multithreading/lecture"));

        try {
            Process process = processBuilder.start();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
