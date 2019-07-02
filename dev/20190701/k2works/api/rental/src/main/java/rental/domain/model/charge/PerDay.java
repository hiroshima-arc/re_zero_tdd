package rental.domain.model.charge;

import rental.domain.model.Days;

public class PerDay {
  Charge perDay;

  PerDay(int perDay) {
    this.perDay = Charge.of(perDay);
  }

  Charge forDays(Days days) {
    return Charge.of(perDay.value * days.intValue());
  }

  static PerDay of(int value) {
    return new PerDay(value);
  }
}
