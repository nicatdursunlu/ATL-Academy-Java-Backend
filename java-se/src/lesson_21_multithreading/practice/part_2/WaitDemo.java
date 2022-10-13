package lesson_21_multithreading.practice.part_2;

class Printer {
    int noOfPaper = 100;

    synchronized void printingPages(int pages) {
        System.out.println("Printing the pages");
        for (int i = 0; i < 100; i++) {
            //
            //
        }
        if (this.noOfPaper < pages) {
            System.out.println("Number of papers in printer are less");
            try {
                System.out.println("Waiting...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("After called notify() method number of paper: " + this.noOfPaper);
        System.out.println("Printing process complete");
    }

    synchronized void addPages(int noOfPages) {
        System.out.println("In addPages() method");
        this.noOfPaper += noOfPages;
        notify();
    }
}

public class WaitDemo {

    public static void main(String[] args) {
        Printer printer = new Printer();

        // thread1
        new Thread(() -> {
            printer.printingPages(120);
        }).start();

        // thread2
        new Thread(() -> {
            printer.addPages(100);
        }).start();
    }
}
