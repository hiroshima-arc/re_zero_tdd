package org.hiroshima_arc.domain.model;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> printValue() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            String result = FizzBuzz.generate(i);
            list.add(result);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(list.get(i));
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
