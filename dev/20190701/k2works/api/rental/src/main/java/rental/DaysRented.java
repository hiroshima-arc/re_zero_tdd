package rental;

public class DaysRented {
  int value;

  public DaysRented(int value) {
    this.value = value;
  }

  public int intValue() {
    return value;
  }

  public boolean lessThan(int days) {
    return value < days;
  }

  public boolean within(int days) {
    return value <= days;
  }

  public DaysRented minus(int days) {
    return new DaysRented(value - days);
  }
}
