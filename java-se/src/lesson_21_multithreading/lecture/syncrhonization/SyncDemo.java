package lesson_21_multithreading.lecture.syncrhonization;

public class SyncDemo {
    public static void main(String[] args) {
        Sender sender = new Sender();
        ThreadedSend s1 = new ThreadedSend("Hello", sender);
        ThreadedSend s2 = new ThreadedSend("Bye", sender);

        // Start two threads of ThreadSend type
        s1.start();
        s2.start();

        // wait for threads to send
        try {
            s1.join();
            s2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
