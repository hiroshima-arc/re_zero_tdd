package helloworld;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static List<String> generateFizzBuzzList(int type) {
        return IntStream.rangeClosed(1,100).mapToObj(i -> FizzBuzz.generate(i, type)).collect(Collectors.toList());
    }

    public static void print(List<String> list) {
        list.forEach(System.out::println);
    }

    public static String generate(int i) {
        boolean fizz = isFizz(i);
        boolean buzz = isBuzz(i);
        if (fizz && buzz) return "FizzBuzz";
        if (fizz) return "Fizz";
        if (buzz) return "Buzz";
        return Integer.toString(i);
    }

    public static String generate(int i, int type) {
        switch (type) {
            case 1:
                return FizzBuzz.generate(i);
            case 2:
                return Integer.toString(i);
            case 3:
                boolean fizz = isFizz(i);
                boolean buzz = isBuzz(i);
                if (fizz && buzz) return "FizzBuzz";
                return Integer.toString(i);
            default:
                return FizzBuzz.generate(i);
        }
    }

    private static boolean isBuzz(int i) {
        return i % 5 == 0;
    }

    private static boolean isFizz(int i) {
        return i % 3 == 0;
    }
}
