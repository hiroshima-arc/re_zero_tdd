package rental.point;

import basic.Accumulate;

public class Point implements Accumulate<Point> {
  int value;

  public Point(int value) {
    this.value = value;
  }

  @Override
  public Point add(Point other) {
    return new Point(this.value + other.value);
  }

  @Override
  public String toString() {
    return value + "p";
  }
}
