package lesson_23_lambda_stream_api.examples.stream_api_2;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DownstreamCollectors {
    public static void main(String[] args) {

        Map<Integer, Long> map =
                Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                        .collect(
                                Collectors.groupingBy(i -> i / 10 * 10, Collectors.counting())
                        );
        System.out.println(map);

        Map<Integer, Map<String, List<Integer>>> evenAndOdd =
                Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37, 12, 22, 25, 26)
                        .collect(Collectors.groupingBy(i -> i / 10 * 10,
                                        Collectors.groupingBy(i -> i % 2 == 0 ? "EVEN" : "ODD")
                                )
                        );
//        {
//            0 = {EVEN=[2]},
//            50 = {EVEN=[54], ODD=[59]},
//            20 = {EVEN=[20, 22, 26], ODD=[23, 25]},
//            10 = {EVEN=[12], ODD=[11, 19]},
//            30 = {EVEN=[34], ODD=[33, 37]}
//        }
        System.out.println("Even and Odd: " + evenAndOdd);


        Map<Integer, Map<String, List<Integer>>> sortedEvenAndOdd =
                Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                        .collect(Collectors.groupingBy(i -> i / 10 * 10,
                                        TreeMap::new,
                                        Collectors.groupingBy(i -> i % 2 == 0 ? "EVEN" : "ODD")
                                )
                        );
//        {
//            0 = {EVEN=[2]},
//            10 = {ODD=[11, 19]},
//            20 = {EVEN=[20], ODD=[23]},
//            30 = {EVEN=[34], ODD=[33, 37]},
//            50 = {EVEN=[54], ODD=[59]}
//        }
        System.out.println("Sorted Even and Odd: " + sortedEvenAndOdd);
    }
}
