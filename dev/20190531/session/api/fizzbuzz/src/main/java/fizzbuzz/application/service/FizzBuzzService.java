package fizzbuzz.application.service;

import fizzbuzz.application.command.FizzBuzzListCommand;
import fizzbuzz.application.command.FizzBuzzValueCommand;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FizzBuzzService {

  public List<FizzBuzzValue> generateList(FizzBuzzType type, int number) {
    IFizzBuzzCommand command = new FizzBuzzListCommand(type);
    return command.execute(number).getList();
  }

  public IFizzBuzz generate(FizzBuzzType type, int number) {
    IFizzBuzzCommand command = new FizzBuzzValueCommand(type);
    return command.execute(number);
  }

}

