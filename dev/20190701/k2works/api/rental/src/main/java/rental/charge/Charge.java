package rental.charge;

import rental.DaysRented;

public interface Charge {
  public int amountFor(DaysRented daysRented);
}
