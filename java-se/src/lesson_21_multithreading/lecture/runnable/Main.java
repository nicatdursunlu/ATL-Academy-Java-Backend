package lesson_21_multithreading.lecture.runnable;

public class Main {
    public static void main(String[] args) {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread object = new Thread(new MultiThreadRunnable());
            object.start();
        }
    }
}
