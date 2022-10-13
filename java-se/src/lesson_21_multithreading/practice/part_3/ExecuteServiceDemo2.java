package lesson_21_multithreading.practice.part_3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteServiceDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<?> response = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ExecutorService");
            }
        });

        System.out.println("Response: " + response.isDone());
        executorService.shutdown();
        System.out.println("Response: " + response.isDone());
    }
}
