package fizzbuzz;

public class FizzBuzz {

  public static String[] generateList() {
    String[] list = new String[100];
    for (int i = 1; i <= 100; i++) {
      list[i - 1] = FizzBuzz.generate(i);
    }
    return list;
  }

  public static String generate(int number) {
    String result = Integer.toString(number);

    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;

    if (isFizz && isBuzz) {
      return "FizzBuzz";
    }
    if (isFizz) {
      return "Fizz";
    }
    if (isBuzz) {
      return "Buzz";
    }
    return result;
  }

}

