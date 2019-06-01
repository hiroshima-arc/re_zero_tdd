package fizzbuzz.application.service;

import fizzbuzz.application.command.FizzBuzzListCommand;
import fizzbuzz.application.command.FizzBuzzValueCommand;
import fizzbuzz.domain.type.FizzBuzzType;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

  public IFizzBuzz generateList(FizzBuzzType type, int number) {
    IFizzBuzzCommand command = new FizzBuzzListCommand(type);
    return command.execute(number);
  }

  public IFizzBuzz generate(FizzBuzzType type, int number) {
    IFizzBuzzCommand command = new FizzBuzzValueCommand(type);
    return command.execute(number);
  }

}

