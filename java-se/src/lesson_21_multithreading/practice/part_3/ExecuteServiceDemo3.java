package lesson_21_multithreading.practice.part_3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecuteServiceDemo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("as = " + Thread.currentThread().getThreadGroup().activeCount());
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Set<Callable<String>> callables = new HashSet<>();
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task1";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task2";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task3";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task4";
            }
        });

        List<Future<String>> results = executorService.invokeAll(callables);
        System.out.println("as = " + Thread.currentThread().getThreadGroup().activeCount());

        results.forEach(e -> {
            try {
                System.out.println("Result: " + e.get());
            } catch (InterruptedException | ExecutionException exception) {
                exception.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
