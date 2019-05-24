package fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
  private static final int MAX_NUMBER = 100;

  private List<String> _list;
  private IFizzBuzzType _type;

  public List<String> getList() {
    return _list;
  }

  public FizzBuzz(int type) {
    _list = new ArrayList<>();

    switch (type) {
      case 1:
        _type = new FizzBuzzType01();
        break;
      case 2:
        _type = new FizzBuzzType02();
        break;
      case 3:
        _type = new FizzBuzzType03();
        break;
      default:
        _type = new FizzBuzzType01();
    }
  }

  public void generateList() {
    this.generateList(1);
  }

  public void generateList(int type) {
    IntStream.rangeClosed(1, MAX_NUMBER).forEach(
      number -> _list.add(this.generate(number))
    );
  }

  public String generate(int number) {
    return _type.generate(number);
  }

}

