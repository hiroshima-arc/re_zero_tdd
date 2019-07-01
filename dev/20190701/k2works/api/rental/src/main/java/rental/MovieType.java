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
}
