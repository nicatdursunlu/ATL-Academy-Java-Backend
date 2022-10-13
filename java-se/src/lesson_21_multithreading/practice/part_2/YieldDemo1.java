package lesson_21_multithreading.practice.part_2;

class ChildThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("ChildThread is running...");
        }
    }
}

public class YieldDemo1 {
    public static ChildThread childThread;

    public static void main(String[] args) {
        childThread = new ChildThread();
        childThread.setPriority(4);
        childThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread is running...");
            Thread.yield();
        }
    }
}
