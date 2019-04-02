package helloworld;

public class FizzBuzz {
    public static int[] print1To100() {
        int[] list = new int[100];
        for (int i = 0; i < 100; i++) {
            list[i] = i + 1;
            System.out.println(list[i]);
        }
        return list;
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
