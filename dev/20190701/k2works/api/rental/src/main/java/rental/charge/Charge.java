package rental.charge;

import rental.rate.DaysRented;

public interface Charge {
  public int amountFor(DaysRented daysRented);
}
