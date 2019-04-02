package helloworld;


import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> generateFizzBuzzList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String result = FizzBuzz.fizzBuzz(i + 1);
            list.add(result);
        }
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
