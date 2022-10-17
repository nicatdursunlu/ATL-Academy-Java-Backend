package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partitioning {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> map =
                Stream.of(45, 9, 65, 77, 12, 89, 31, 12)
                        .collect(Collectors.partitioningBy(i -> i < 50));
//                        .collect(Collectors.partitioningBy(i -> i%2==0));
        System.out.println("partitioningBy list [i < 50]: " + map);

        Map<Boolean, Set<Integer>> map2 =
                Stream.of(45, 9, 65, 77, 12, 89, 31, 12)
                        .collect(
                                Collectors.partitioningBy(i -> i < 50,
                                        Collectors.toSet()
                                )
                        );
        System.out.println("partitioningBy set [i < 50]: " + map2);

        Set<Integer> lessThan50 = map2.get(true);
        Set<Integer> moreThan50 = map2.get(false);
        System.out.println("Less than 50: " + lessThan50);
        System.out.println("More than 50: " + moreThan50);
    }
}
