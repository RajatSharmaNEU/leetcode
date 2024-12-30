package BasicJava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        /*
            Conversion
            // From String
            // To String


        // From String
        String string = "12345";
        int numInteger = Integer.parseInt(string);
        Double numDecimal = Double.parseDouble(string);
        Boolean numBool = Boolean.parseBoolean("true");

        System.out.println(numInteger);
        System.out.println(numDecimal);
        System.out.println(numBool);

        // To String

        Integer integer = 123;
        Double d = 123.0;
        Boolean b = true;
        String resultInteger = Integer.toString(integer);
        resultInteger = String.valueOf(integer);

        String resultDouble = Double.toString(d);
        resultDouble = String.valueOf(d);

        String resultBoolean = Boolean.toString(b);
        resultBoolean = String.valueOf(b);

        System.out.println(resultInteger);
        System.out.println(resultDouble);
        System.out.println(resultBoolean);

       */

        /**/
        int[] array = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
//        IntStream intStream = Arrays.stream(array);
//        int result = Arrays.stream(array).findAny().orElse(10);
//        int result = Arrays.stream(array).reduce(0, (acc, curr) -> acc + curr);
//        int result = Arrays.stream(array).max().orElse(-1);
//        int[] result = Arrays.stream(array).distinct().toArray();

//        List<Integer> result = Arrays.stream(array).distinct().boxed().collect(Collectors.toList());
//        String[] names = new String[] {"Preeti", "Nitin", "Rajat"};
//        Map<Integer, List<String>> map = Arrays.stream(names).collect(Collectors.groupingBy(String::length, Collectors.toList()));

//        List<String> list = new ArrayList<>(Arrays.asList(names));
//        list.add("Renuka");
//
//        List<String> result = list.stream().sorted((a , b) -> a.length() - b.length()).collect(Collectors.toList());
//        System.out.println(result);

        Map<Integer, String[]> map = new HashMap<>();
        map.computeIfAbsent(10, k -> new String[k]);
        map.putIfAbsent(11, new String[11]);

        System.out.println(map);
        System.out.println(map.getOrDefault(12, new String[0]));
    }
}
