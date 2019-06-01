package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzList {
  private final List<FizzBuzzValue> _list;

  public FizzBuzzList(List<FizzBuzzValue> list) {
    _list = list;
  }

  public List<FizzBuzzValue> getList() {
    return _list;
  }

  public FizzBuzzList add(FizzBuzzValue value) {
    List<FizzBuzzValue> result = new ArrayList<>(_list);
    result.add(value);
    return new FizzBuzzList(result);
  }

}

