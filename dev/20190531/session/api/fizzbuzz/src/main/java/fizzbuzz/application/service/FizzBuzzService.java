package fizzbuzz.application.service;

import fizzbuzz.application.command.FizzBuzzListCommand;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

  public List<FizzBuzzValue> generateList(FizzBuzzType type, int number) {
    IFizzBuzzCommand command = new FizzBuzzListCommand(type);
    return command.execute(number).getList();
  }

}

