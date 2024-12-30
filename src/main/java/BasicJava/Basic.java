package BasicJava;

import java.util.*;

public class Basic {
    public static void main(String[] args) {
        /* Conversion between primitive
        // String to any
        String string = "123";
        Integer integer = Integer.parseInt(string);
        Double d = Double.parseDouble(string);
        Boolean bool = Boolean.parseBoolean(string);

        // any to String
        String i = Integer.toString(integer);
        String j = Double.toString(d);
        String k = Boolean.toString(bool);

        int p = Integer.valueOf(i);
        Integer q = Integer.valueOf(string);
        */


        //Streams

        // IntStream vs Stream<Integer>
        /* IntStream vs Stream<Integer>

        Integer[] arrayInteger = new Integer[]{1, 2, 3, 4, 5};
        Integer[] arrayIntegerFilter = Arrays.stream(arrayInteger).filter(a -> a % 2 == 0).toArray(Integer[]::new);

        int[] arrayInt = new int[]{1, 2, 3, 4, 5};
        int[] arrayIntFilter = Arrays.stream(arrayInt).filter(a -> a % 2 == 0).toArray();

        Integer[] convertedArrayIntegerFilter = Arrays.stream(arrayInt).filter(a -> a % 2 == 0).mapToObj(Integer::valueOf).toArray(Integer[]::new);
        int[] convertedArrayIntFilter = Arrays.stream(arrayInteger).filter(a -> a % 2 == 0).mapToInt(Integer::intValue).toArray();
        */

        // Intermediate and Terminating Operations
        /*Intermediate and Terminating Operations
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        IntStream stream = Arrays.stream(array);
        int[] even = Arrays.stream(array).filter(a -> a % 2 == 0).toArray();
        int[] distinct = Arrays.stream(array).distinct().toArray();
        int[] map = Arrays.stream(array).map((a) -> a * 2).toArray();
        int max = Arrays.stream(array).max().orElse(-1);
        int reduceSum = Arrays.stream(array).reduce(0, (a, b) -> a + b);
        int sum = Arrays.stream(array).sum();

        List<Integer> list = Arrays.stream(array).mapToObj(Integer::valueOf).collect(Collectors.toList());
        Map<Integer, List<Integer>> group = Arrays.stream(array).mapToObj(Integer::valueOf).collect(Collectors.groupingBy(a -> a % 2));

        int x = Arrays.stream(array).findAny().orElse(-1);
        System.out.println(x);
        */

        // Collections(List, Set, Map) vs Collectors(Stream Utility)
        /*
        List<String> list = new ArrayList<>(Arrays.asList("Rajat", "Preeti", "Nitin"));
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        System.out.println(list.stream().collect(Collectors.joining(" - ")));
        */

        // String
        String name = "Rajat Sharma";
        System.out.println(name.substring(2, 5));

        // Copy
        List<String> list = new ArrayList<>(Arrays.asList("Rajat", "Preeti", "Nitin"));
        List<String> listCopy = List.copyOf(list);
        List<String> listCopyRange = list.subList(1,2);

        System.out.println(listCopy);
        System.out.println(listCopyRange);

        int[] arr = new int[] {1,2,3,4,5};
        int[] arrCopy = Arrays.copyOf(arr, arr.length - 2);
        int[] arrCopyRange = Arrays.copyOfRange(arr, 1, arr.length);
        System.out.println(Arrays.toString(arrCopy));
        System.out.println(Arrays.toString(arrCopyRange));


        // Hash Map
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.putIfAbsent(1, 1);
        hashMap.getOrDefault(2, 0);

        hashMap.entrySet().stream().peek(System.out::println).forEach(entry -> {});
    }
}
