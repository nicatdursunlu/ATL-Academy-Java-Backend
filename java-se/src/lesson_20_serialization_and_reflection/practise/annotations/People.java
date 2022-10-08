package lesson_20_serialization_and_reflection.practise.annotations;

public class People {

    public String name;
    public int age;
    public String idSerialNumber;
    public String address;

    @Deprecated
    public void message() {
        System.out.println("People!");
    }
}
