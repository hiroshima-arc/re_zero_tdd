package fizzbuzz.domain.model;

import fizzbuzz.application.IFizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzList implements IFizzBuzz {
  private final List<FizzBuzzValue> _list;

  public FizzBuzzList(List<FizzBuzzValue> list) {
    if (list.size() > 100)
    throw new IllegalArgumentException("FizzBuzzList can't generate over 100");
    _list = list;
  }

  @Override
  public String getValue() {
    return "";
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

