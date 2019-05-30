package fizzbuzz;

public class FizzBuzz {

  public static int[] print1To100() {
    int[] list = new int[100];
    for (int i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }

}

