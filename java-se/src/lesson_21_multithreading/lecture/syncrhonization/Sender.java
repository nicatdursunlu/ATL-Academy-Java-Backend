package lesson_21_multithreading.lecture.syncrhonization;

public class Sender {
    public void send(String  message) {
        System.out.println("Sending\t" + message);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n" + message + " Sent");
    }
}
