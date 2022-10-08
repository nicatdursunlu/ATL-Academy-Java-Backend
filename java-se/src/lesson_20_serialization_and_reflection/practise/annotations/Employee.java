package lesson_20_serialization_and_reflection.practise.annotations;

public class Employee extends People {

    @Override
    public void message() {
        System.out.println("Employee!");
    }
}
