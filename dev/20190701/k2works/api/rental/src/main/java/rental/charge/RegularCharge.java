package rental.charge;

import rental.rate.DaysRented;

public class RegularCharge implements Charge {
  int baseAmount = 200;
  int baseDays = 2;
  int amountPerDay = 150;

  @Override
  public int amountFor(DaysRented daysRented) {
    return amount(daysRented.intValue());
  }

  private int amount(int daysRented) {
    return baseAmount + additionalAmount(daysRented);
  }

  private int additionalAmount(int daysRented) {
    if (daysRented > baseDays) return (daysRented - baseDays) * amountPerDay;
    return 0;
  }
}
