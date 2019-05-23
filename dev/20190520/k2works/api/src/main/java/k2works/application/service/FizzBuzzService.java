package k2works.application.service;

import java.util.List;

import k2works.domain.model.FizzBuzzValue;
import k2works.domain.type.FizzBuzzType;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

  public List<FizzBuzzValue> generateList(String type) {
    IFizzBuzzCommand command = new FizzBuzzValuesCommand(
      FizzBuzzType.valueOf(type)
    );
    IFizzBuzz list = command.execute(100);
    return list.getValues();
  }

}

