package fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  private List<String> _list;
  private IFizzBuzzType _type;

  public FizzBuzz(IFizzBuzzType type) {
    _type = type;
  }

  public List<String> getList() {
    return _list;
  }

  public void generateList() {
    _list = IntStream.rangeClosed(1, MAX_NUMBER).mapToObj(
      number -> this.generate(number)
    ).collect(Collectors.toList());
  }

  public String generate(int number) {
    return _type.generate(number);
  }

}

