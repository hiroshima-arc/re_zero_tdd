package rental.charge;

import rental.DaysRented;

public class ChildCharge implements Charge {
  int baseAmount = 150;
  int baseDays = 3;
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
