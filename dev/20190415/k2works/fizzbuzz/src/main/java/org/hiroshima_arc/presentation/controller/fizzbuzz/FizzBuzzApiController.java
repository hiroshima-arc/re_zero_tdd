package org.hiroshima_arc.presentation.controller.fizzbuzz;

import org.hiroshima_arc.application.service.fizzbuzz.FizzBuzzValuesService;
import org.hiroshima_arc.application.service.fizzbuzz.IFizzBuzzService;
import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValue;
import org.hiroshima_arc.domain.model.fizzbuzz.IFizzBuzz;
import org.hiroshima_arc.domain.type.fizzbuzz.FizzBuzzType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FizzBuzzApiController {
    @RequestMapping(value = "/api/fizzbuzz", method = RequestMethod.GET)
    public List<FizzBuzzEntity> fizzBuzzValues() {
        IFizzBuzzService service = new FizzBuzzValuesService(FizzBuzzType.one);
        IFizzBuzz values = service.execute(100);
        List list = new ArrayList();
        for(FizzBuzzValue value : values.getValues()) {
            FizzBuzzEntity entity = new FizzBuzzEntity(value);
            list.add(entity);
        }
        return list;
    }
}

class FizzBuzzEntity {
    private Integer _number;
    private String _value;

    FizzBuzzEntity(FizzBuzzValue value) {
        _number = value.getNumber();
        _value = value.getValue();
    }

    public Integer getNumber() {
        return _number;
    }

    public String getValue() {
        return _value;
    }

}