package lesson_21_multithreading.practice.part_2;

class MyThread implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 0; i <= 3; i++) {
            System.out.println(t.getName() + " is running...");
        }
        System.out.println(t.getName() + " ended");
    }
}

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyThread(), "thread1");
        Thread thread2 = new Thread(new MyThread(), "thread2");
        Thread thread3 = new Thread(new MyThread(), "thread3");

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
    }
}
