package fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
  public static final int MAX_NUMBER = 100;
  private FizzBuzzList _list;
  private FizzBuzzType _type;

  public FizzBuzz(FizzBuzzType type) {
    List<FizzBuzzValue> list = new ArrayList<>();
    _list = new FizzBuzzList(list);
    _type = type;
  }

  public FizzBuzzList generateList() {
    IntStream.rangeClosed(1, MAX_NUMBER).forEach(
      number -> _list = _list.add(generate(number))
    );
    return _list;
  }

  public FizzBuzzValue generate(int number) {
    return _type.generate(number);
  }

}

