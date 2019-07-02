package rental.domain.model.charge;

import rental.domain.model.DaysRented;

public class ChargePerDay {
  Charge perDay;

  ChargePerDay(int perDay) {
    this.perDay = new Charge(perDay);
  }

  public Charge forDays(DaysRented daysRented) {
    return new Charge(perDay.value * daysRented.intValue());
  }
}
