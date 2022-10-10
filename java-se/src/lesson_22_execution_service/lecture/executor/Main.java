package lesson_22_execution_service.lecture.executor;

public class Main {
    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        Executor executor = new Invoker();
        executor.execute(() -> {
            // task to be performed
            System.out.println("Execute");
        });
    }
}
