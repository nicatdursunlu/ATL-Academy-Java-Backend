package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.stream.LongStream;
import java.util.stream.Stream;

class Total {
    public long total = 1;

    public void multiply(long n) {
        total *= n;
    }
}

public class ParallelStreams {
    public static void main(String[] args) {
        Stream.of("a", "b", "c", "d", "e")
                .forEach(System.out::print);
        System.out.println();

        Stream.of("a", "b", "c", "d", "e")
                .parallel()
                .forEach(System.out::print);
        System.out.println();

        Total t = new Total();

        LongStream.rangeClosed(1, 10)
                .forEach(t::multiply);
        System.out.println("Sequential total: " + t.total);

        LongStream.rangeClosed(1, 10)
                .parallel()
                .forEach(t::multiply);
        System.out.println("Parallel total: " + t.total);

        long total = LongStream.rangeClosed(1, 10)
                .parallel()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Total with reducer: " + total);
    }
}
