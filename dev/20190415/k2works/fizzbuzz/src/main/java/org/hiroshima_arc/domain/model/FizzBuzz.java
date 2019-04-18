package org.hiroshima_arc.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void printValue() {
        generateList().forEach(System.out::println);
    }

    public static List<String> generateList() {
        return IntStream.rangeClosed(1,100).mapToObj(FizzBuzz::generate).collect(Collectors.toList());
    }

    public static String generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return  "FizzBuzz";
        if (fizz) return  "Fizz";
        if (buzz) return "Buzz";
        return Integer.toString(number);
    }

    private static boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private static boolean isFizz(int number) {
        return number % 3 == 0;
    }
}
