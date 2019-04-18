package org.hiroshima_arc.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void printValue() {
        List<String> list = generateList();
        for(String s: list) {
            System.out.println(s);
        }
    }

    public static List<String> generateList() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(FizzBuzz.generate(i));
        }
        return list;
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
