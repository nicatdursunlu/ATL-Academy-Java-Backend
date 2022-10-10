package lesson_22_execution_service.lecture.executor;

public class Invoker implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
