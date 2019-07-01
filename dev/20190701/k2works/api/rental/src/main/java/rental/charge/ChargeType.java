package rental.charge;

public enum ChargeType {
  REGULAR(200, 2, 150), CHILDREN(150, 3, 150);
  int baseAmount = 0;
  int baseDays = 0;
  int amountPerDay = 0;

  private ChargeType(int baseAmount, int baseDays, int amountPerDay) {
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
}
