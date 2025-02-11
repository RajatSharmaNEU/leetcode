package BasicJava;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    // Primitive Stream ~ IntStream, DoubleStream, LongStream
    // Boxed Stream ~ Stream<Integer>

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        IntStream intStream = Arrays.stream(arr);
        IntStream directIntStream = IntStream.of(arr);
        Stream<Integer> integerStream = Arrays.stream(arr).boxed();

        int sum = intStream.reduce(0, (acc, next) -> acc + next);




    }
}
