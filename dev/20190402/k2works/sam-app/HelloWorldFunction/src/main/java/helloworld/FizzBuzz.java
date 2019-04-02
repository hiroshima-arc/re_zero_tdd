package helloworld;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static List<String> generateFizzBuzzList() {
        List<String> list = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach(i -> {
            String result = FizzBuzz.fizzBuzz(i);
            list.add(result);
        });
        return list;
    }

    public static void print(List<String> list) {
        for(String s : list) {
            System.out.println(s);
        }
    }

    public static String fizzBuzz(int i) {
        String result = Integer.toString(i);
        if (i % 3 == 0 && i % 5 == 0) {
           result = "FizzBuzz";
        } else if (i % 3 == 0) {
            result = "Fizz";
        } else if(i % 5 == 0) {
            result = "Buzz";
        }
        return result;
    }
}
