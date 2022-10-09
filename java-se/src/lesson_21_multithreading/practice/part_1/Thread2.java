package lesson_21_multithreading.practice.part_1;

/**
 * States of Thread:
 * 1. NEW
 * 2.RUNNABLE -> {
 * READY_TO_RUN
 * RUNNING
 * }
 * 3. TIME_WAITING -> sleep();
 * 4. WAITING
 * 5. BLOCKED
 * 6. TERMINATED (DEAD)
 */

public class Thread2 implements Runnable {

    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        Thread2 thread2 = new Thread2();
        Thread thread = new Thread(thread2);
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
