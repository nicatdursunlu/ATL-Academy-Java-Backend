package lesson_21_multithreading.lecture.runnable;

public class MultiThreadRunnable implements Runnable {

    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception i caught");
        }
    }
}
