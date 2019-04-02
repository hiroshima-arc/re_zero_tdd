package helloworld;

public class FizzBuzzType01 {
    public String generate(int number) {
        boolean fizz = isFizz(number);
        boolean buzz = isBuzz(number);
        if (fizz && buzz) return "FizzBuzz";
        if (fizz) return "Fizz";
        if (buzz) return "Buzz";
        return  Integer.toString(number);
    }

    private boolean isBuzz(int i) {
        return i % 5 == 0;
    }

    private boolean isFizz(int i) {
        return i % 3 == 0;
    }
}
