package lesson_20_serialization_and_reflection.practise.annotations;

public class Main {

    @SingleValueAnnotation(value = 50)
    @MultiValueAnnotation(value = 20, value2 = 50, value3 = "String")
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.message();
    }
}
