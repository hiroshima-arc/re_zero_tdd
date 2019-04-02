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
}
