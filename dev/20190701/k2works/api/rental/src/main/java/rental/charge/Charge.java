package rental.charge;

import generics.Accumulate;

public class Charge implements Accumulate<Charge> {
  int value;

  public Charge(int value) {
    this.value = value;
  }

  @Override
  public Charge add(Charge other) {
    return new Charge(this.value + other.value);
  }

  @Override
  public String toString() {
    return value + "円";
  }
}
