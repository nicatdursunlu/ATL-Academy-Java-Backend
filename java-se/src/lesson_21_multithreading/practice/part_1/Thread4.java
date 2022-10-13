package lesson_21_multithreading.practice.part_1;

class MyThread implements Runnable {
    String name;
    Thread thread;

    public MyThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("The " + name + " is running...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
    }
}

public class Thread4 {
    public static void main(String[] args) {
        new MyThread("First Thread");
        new MyThread("Second Thread");
        new MyThread("Third Thread");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
