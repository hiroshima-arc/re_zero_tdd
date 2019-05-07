package org.hiroshima_arc.application.service.fizzbuzz;

import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzEntity;
import org.hiroshima_arc.domain.model.fizzbuzz.FizzBuzzValue;
import org.hiroshima_arc.domain.model.fizzbuzz.IFizzBuzz;
import org.hiroshima_arc.domain.type.fizzbuzz.FizzBuzzType;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzApiService {
    private String _type;

    public FizzBuzzApiService(String type) {
        this._type = type;
    }

    public List<FizzBuzzEntity> execute(int number) {
        IFizzBuzzService service = new FizzBuzzValuesService(FizzBuzzType.valueOf(this._type));
        IFizzBuzz values = service.execute(number);
        List list = new ArrayList();
        for(FizzBuzzValue value : values.getValues()) {
            FizzBuzzEntity entity = new FizzBuzzEntity(value);
            list.add(entity);
        }
        return list;
    }
}
