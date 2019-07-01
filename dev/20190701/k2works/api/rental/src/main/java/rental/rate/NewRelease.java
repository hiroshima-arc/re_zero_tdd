package rental.rate;

public class NewRelease implements Rate {
  int amountPerDay = 300;

  @Override
  public int amount(DaysRented daysRented) {
    return amountPerDay * daysRented.intValue();
  }

  @Override
  public int point(DaysRented daysRented) {
    if (daysRented.intValue() > 1) return 2;
    return 1;
  }
}
