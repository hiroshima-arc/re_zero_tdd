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
        String result = Integer.toString(number);
        if (number % 3 == 0 && number % 5 == 0) {
            result = "FizzBuzz";
        }else if (number % 3 == 0) {
            result = "Fizz";
        } else if (number % 5 == 0) {
            result = "Buzz";
        }
        return result;
    }
}
