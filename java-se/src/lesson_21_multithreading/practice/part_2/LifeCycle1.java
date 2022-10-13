package lesson_21_multithreading.practice.part_2;

public class LifeCycle1 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("My Thread " + Thread.currentThread().getName());
        LifeCycle1 lifeCycle = new LifeCycle1();
        Thread thread = new Thread(lifeCycle);

        // state = NEW
        thread.start();
        // state = RUNNABLE -> TIME_WAITING (sleep, join, join)
        // TIME_WAITING -> RUNNABLE (notify, notifyAll)
        // state = TERMINATED
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("My Thread " + Thread.currentThread().getName());
        System.out.println("My thread " + Thread.currentThread().isAlive());
    }
}
