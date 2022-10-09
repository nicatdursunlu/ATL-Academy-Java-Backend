package lesson_21_multithreading.theory.syncrhonization;

public class ThreadedSend extends Thread {
    private String message;
    Sender sender;

    public ThreadedSend(String message, Sender sender) {
        this.message = message;
        this.sender = sender;
    }

    public void run() {
        // Only one thread can send a message at a time
        synchronized (sender) {
            // synchronized the send object
            sender.send(message);
        }
    }
}
