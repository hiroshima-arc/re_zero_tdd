package rental.domain.model;

public class Days {
  int value;

  Days(int value) {
    this.value = value;
  }

  public int intValue() {
    return value;
  }

  public boolean within(Days other) {
    return this.value <= other.value;
  }

  public Days minus(Days other) {
    return new Days(this.value - other.value);
  }

  public static Days of(int value) {
    return new Days(value);
  }
}
