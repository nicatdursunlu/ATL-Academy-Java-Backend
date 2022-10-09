package lesson_21_multithreading.practice.part_1;

public class Thread3 extends Thread {

    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        Thread3 thread3 = new Thread3();
        Thread thread = new Thread(thread3);
        thread.setName("My Thread");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Thread is running... " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
