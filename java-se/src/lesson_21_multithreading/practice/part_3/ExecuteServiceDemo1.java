package lesson_21_multithreading.practice.part_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1. ExecutorService executorService1 = Executors.newSingleThreadExecutor();
 * Creates a ExecutorService object having a single thread
 * <p>
 * 2. ExecutorService executorService2 = Executors.newFixedThreadPool(10);
 * Creates ExecutorService object having a pool of 10 threads
 * <p>
 * 3. ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
 * Creates a scheduled thread pool executor with 10 threads
 */

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("ExecutorService");
        System.out.println("Name: " + Thread.currentThread().getName());
        System.out.println("State: " + Thread.currentThread().getState());
    }
}

public class ExecuteServiceDemo1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        MyThread myThread = new MyThread();
        executorService.execute(myThread);
        executorService.shutdown();
    }
}
