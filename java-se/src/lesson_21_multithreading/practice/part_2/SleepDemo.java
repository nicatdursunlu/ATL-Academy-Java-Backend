package lesson_21_multithreading.practice.part_2;

public class SleepDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepDemo thread1 = new SleepDemo();
        thread1.setName("Thread 1");

        SleepDemo thread2 = new SleepDemo();
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}
