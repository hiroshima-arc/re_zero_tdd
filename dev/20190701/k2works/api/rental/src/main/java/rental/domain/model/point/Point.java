package rental.domain.model.point;

import rental.domain.generics.Accumulate;

public class Point implements Accumulate<Point> {
  int value;

  Point(int value) {
    this.value = value;
  }

  public static Point zero = new Point(0);
  public static Point one = new Point(1);

  @Override
  public Point add(Point other) {
    return new Point(this.value + other.value);
  }

  @Override
  public String toString() {
    return value + "ポイント";
  }
}
