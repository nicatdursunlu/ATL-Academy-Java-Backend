package lesson_22_execution_service.lecture.atomic_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends Thread {
    AtomicInteger count;

    Counter() {
        count = new AtomicInteger();
    }

    public void run() {
        int max = 100_000_000;

        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            count.addAndGet(1);
        }
    }
}
