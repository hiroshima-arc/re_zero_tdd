package rental.rate;

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
}
