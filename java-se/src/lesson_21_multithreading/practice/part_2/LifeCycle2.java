package lesson_21_multithreading.practice.part_2;

class ThreadStates extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State of Thread1: " + LifeCycle2.thread1.getState());
        System.out.println("State of Thread2: " + LifeCycle2.thread2.getState());
    }
}

public class LifeCycle2 extends Thread {
    public static Thread thread1;
    public static Thread thread2;

    public static void main(String[] args) {
        thread1 = new LifeCycle2();
        System.out.println("State of Thread1 after creating: " + thread1.getState()); // NEW

        thread1.start();
        System.out.println("State of Thread1 after call start method: " + thread1.getState()); // RUNNABLE
    }

    @Override
    public void run() {
        thread2 = new ThreadStates();
        System.out.println("State of Thread2 after creation: " + thread1.getState()); // NEW

        thread2.start();
        System.out.println("State of Thread2 after call start method: " + thread1.getState()); // RUNNABLE

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State of Thread2 after completion of thread1: " + thread1.getState()); // NEW
        System.out.println("State of Thread2 after completion of thread2: " + thread2.getState()); // TERMINATED
    }
}
