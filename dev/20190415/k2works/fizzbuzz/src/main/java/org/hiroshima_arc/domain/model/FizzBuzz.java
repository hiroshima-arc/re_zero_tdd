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
        if (number % 3 == 0 && number % 5 == 0) return  "FizzBuzz";
        if (number % 3 == 0) return  "Fizz";
        if (number % 5 == 0) return "Buzz";
        return Integer.toString(number);
    }
}
