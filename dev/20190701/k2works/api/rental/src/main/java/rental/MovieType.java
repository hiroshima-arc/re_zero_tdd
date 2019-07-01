package rental;

public enum MovieType {
  REGULAR(200, 2, 150), CHILDREN(150, 3, 150), NEW_RELEASE(0, 0, 300);
  int baseAmount = 0;
  int baseDays = 0;
  int amountPerDay = 0;

  private MovieType(int baseAmount, int baseDays, int amountPerDay) {
    this.baseAmount = baseAmount;
    this.baseDays = baseDays;
    this.amountPerDay = amountPerDay;
  }

  int amount(int daysRented) {
    return baseAmount + additionalAmount(daysRented);
  }

  private int additionalAmount(int daysRented) {
    if (daysRented > baseDays) return (daysRented - baseDays) * amountPerDay;
    return 0;
  }

  int point(int daysRented) {
    int points = 1;
    if (this == NEW_RELEASE && daysRented > 1) points++;

    return points;
  }
}
