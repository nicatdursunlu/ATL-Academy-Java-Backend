package lesson_21_multithreading.practise.part_1;

public class Thread1 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Active count: " + Thread.activeCount());

        System.out.println("Main thread: " + Thread.currentThread());
        System.out.println("Name of main thread: " + Thread.currentThread().getName());
        System.out.println("Id of main thread: " + Thread.currentThread().getId());
        System.out.println("Is alive main thread: " + Thread.currentThread().isAlive());
        System.out.println("Status of main thread: " + Thread.currentThread().getState());
        System.out.println("Group of main thread: " + Thread.currentThread().getThreadGroup());

        Thread.currentThread().setPriority(3); // set the priority to the thread
        System.out.println("Priority of main thread: " + Thread.currentThread().getPriority());

        System.out.println("-------------------------------------");
        first();
    }

    public static void first() {
        second();
    }

    public static void second() {
        third();
    }

    public static void third() {
        for (StackTraceElement stack : Thread.currentThread().getStackTrace()) {
            System.out.println(stack);
        }
    }
}
