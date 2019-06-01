package fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  private List<FizzBuzzValue> _list;
  private FizzBuzzType _type;

  public FizzBuzz(FizzBuzzType type) {
    _type = type;
  }

  public List<FizzBuzzValue> getList() {
    return _list;
  }

  public void generateList() {
    _list = IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      number -> this.generate(number)
    ).collect(Collectors.toList());
  }

  public FizzBuzzValue generate(int number) {
    return _type.generate(number);
  }

}

