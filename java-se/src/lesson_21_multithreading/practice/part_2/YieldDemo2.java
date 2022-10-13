package lesson_21_multithreading.practice.part_2;

class ThreadOne extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread one is running...");
            Thread.yield();
        }
    }
}

class ThreadTwo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread two is running...");
        }
    }
}

public class YieldDemo2 {
    public static void main(String[] args) {

        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();

        threadOne.start();
        threadTwo.start();
    }
}
