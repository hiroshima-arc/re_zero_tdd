package helloworld;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static List<String> generateFizzBuzzList() {
        return IntStream.rangeClosed(1,100).mapToObj(FizzBuzz::fizzBuzz).collect(Collectors.toList());
    }

    public static void print(List<String> list) {
        list.forEach(System.out::println);
    }

    public static String fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        if (i % 3 == 0) return "Fizz";
        if (i % 5 == 0) return "Buzz";
        return Integer.toString(i);
    }
}
