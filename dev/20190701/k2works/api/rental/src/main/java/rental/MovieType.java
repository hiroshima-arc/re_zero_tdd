package rental;

public enum MovieType implements Rate {
  REGULAR(200, 2, 150), CHILDREN(150, 3, 150);
  int baseAmount = 0;
  int baseDays = 0;
  int amountPerDay = 0;

  private MovieType(int baseAmount, int baseDays, int amountPerDay) {
    this.baseAmount = baseAmount;
    this.baseDays = baseDays;
    this.amountPerDay = amountPerDay;
  }

  public int amount(int daysRented) {
    return baseAmount + additionalAmount(daysRented);
  }

  private int additionalAmount(int daysRented) {
    if (daysRented > baseDays) return (daysRented - baseDays) * amountPerDay;
    return 0;
  }

  public int point(int daysRented) {
    return 1;
  }
}
