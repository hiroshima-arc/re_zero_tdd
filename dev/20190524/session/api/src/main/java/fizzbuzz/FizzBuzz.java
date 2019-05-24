package fizzbuzz;

public class FizzBuzz {

  public static String[] generateList() {
    String[] list = new String[100];
    for (int i = 1; i <= 100; i++) {
      list[i - 1] = generate(i);
    }
    return list;
  }

  public static String generate(int number) {
    String result = Integer.toString(number);

    if (number % 3 == 0 && number % 5 == 0) {
      result = "FizzBuzz";
    } else if (number % 3 == 0) {
      result = "Fizz";
    } else if (number % 5 == 0) {
      result = "Buzz";
    }
    return result;
  }

}

