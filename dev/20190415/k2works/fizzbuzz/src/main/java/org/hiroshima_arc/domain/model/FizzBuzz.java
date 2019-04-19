package org.hiroshima_arc.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static void printValue() {
        generateList().forEach(System.out::println);
    }

    public static List<String> generateList() {
        return IntStream.rangeClosed(1,100).mapToObj(FizzBuzz::generate).collect(Collectors.toList());
    }

    public static List<String> generateList(int type) {
        return IntStream.rangeClosed(1,100).mapToObj(i -> FizzBuzz.generate(i, type)).collect(Collectors.toList());
    }

    public static String generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return FIZZ_BUZZ;
        if (fizz) return FIZZ;
        if (buzz) return BUZZ;
        return Integer.toString(number);
    }

    private static boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private static boolean isFizz(int number) {
        return number % 3 == 0;
    }

    public static String generate(int number, int type) {
        switch (type) {
            case 1:
                return FizzBuzz.generate(number);
            default:
                return FizzBuzz.generate(number);
        }
    }
}
