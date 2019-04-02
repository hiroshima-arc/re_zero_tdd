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
