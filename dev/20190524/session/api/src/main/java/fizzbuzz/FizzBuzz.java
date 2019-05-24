package fizzbuzz;

public class FizzBuzz {

  public static int[] print1To100() {
    int[] list = new int[100];
    for (int i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }

  public static String generate(int number) {
    String result = Integer.toString(number);
    if (number % 3 == 0) {
      result = "Fizz";
    } else if (number % 5 == 0) {
      result = "Buzz";
    }
    return result;
  }

}

