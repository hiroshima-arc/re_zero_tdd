package rental.charge;

import rental.DaysRented;

public class NewReleaseCharge implements Charge {
  int amountPerDay = 300;

  @Override
  public int amountFor(DaysRented daysRented) {
    return amountPerDay * daysRented.intValue();
  }
}
