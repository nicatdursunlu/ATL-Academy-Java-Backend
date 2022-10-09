package lesson_21_multithreading.theory.thread;

public class MultiThread {
    public static void main(String[] args) {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo demo = new MultithreadingDemo();
            demo.start();
        }
    }
}
