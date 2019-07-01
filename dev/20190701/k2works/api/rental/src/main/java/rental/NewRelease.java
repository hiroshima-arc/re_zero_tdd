package rental;

public class NewRelease implements Rate {
  int amountPerDay = 300;

  @Override
  public int amount(int daysRented) {
    return amountPerDay * daysRented;
  }

  @Override
  public int point(int daysRented) {
    if (daysRented > 1) return 2;
    return 1;
  }
}
