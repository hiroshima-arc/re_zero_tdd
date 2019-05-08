package org.hiroshima_arc.domain.model.fizzbuzz;

public class FizzBuzzEntity {
    private Integer _number;
    private String _value;

    public FizzBuzzEntity(FizzBuzzValue value) {
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
