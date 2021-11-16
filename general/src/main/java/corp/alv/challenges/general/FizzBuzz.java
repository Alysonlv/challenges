package corp.alv.challenges.general;

import java.util.stream.IntStream;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = FIZZ + BUZZ;

    public static void execute(int start, int end) {
        IntStream.rangeClosed(start, end)
                .mapToObj(i -> i % 5 == 0 ? (i % 7 == 0 ? FIZZBUZZ : FIZZ) : (i % 7 == 0 ? BUZZ : i))
                .forEach(System.out::println);
    }

    public static void main(String... args) {
        FizzBuzz.execute(1, 100);
    }
}
