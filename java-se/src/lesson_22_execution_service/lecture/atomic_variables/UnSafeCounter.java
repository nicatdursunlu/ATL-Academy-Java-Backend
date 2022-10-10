package lesson_22_execution_service.lecture.atomic_variables;

public class UnSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        // Instance of Counter Class
        Counter counter = new Counter();

        // Defining Two different threads
        Thread first = new Thread(counter, "First");
        Thread second = new Thread(counter, "Second");

        // Threads start executing
        first.start();
        second.start();

        // main thread will wait for
        // both threads to get completed
        first.join();
        second.join();

        // Printing final value of count variable
        System.out.println(counter.count);
    }
}
