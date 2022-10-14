package lesson_21_multithreading.practice.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Wallet {
    private final AtomicInteger balance = new AtomicInteger();

//    private int balance;

    public void increment() {
//        balance++;
        balance.addAndGet(1);
    }

    public AtomicInteger getBalance() {
        return balance;
    }
}

public class AtomicScalars {
    public static void main(String[] args) {
        final Wallet wallet = new Wallet();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Thread(new Runnable() {
                @Override
                public void run() {
                    wallet.increment();
                }
            }));
        }

        executorService.shutdown();
        System.out.println("Total balance: " + wallet.getBalance());
    }
}
