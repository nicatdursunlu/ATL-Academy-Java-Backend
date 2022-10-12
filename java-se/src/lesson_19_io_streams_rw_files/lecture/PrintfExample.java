package lesson_19_io_streams_rw_files.lecture;

public class PrintfExample {
    public static void main(String[] args) {
        int x = 100;
        System.out.printf("Printing simple" + " integer: x = %d\n", x);

        System.out.printf("Formatted with" + " precision: PI: x = %.2f\n", Math.PI);

        float n = 5.2f;
        System.out.printf("Formatted to " + "specific: n = %4f\n", n);

        n = 2324435.3f;
        System.out.printf("Formatted to " + "right margin: n = %20.4f\n", n);
    }
}
