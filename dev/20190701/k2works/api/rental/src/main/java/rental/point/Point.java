package rental.point;

public class Point {
  int value;

  public Point(int value) {
    this.value = value;
  }

  public Point add(Point other) {
    return new Point(this.value + other.value);
  }

  @Override
  public String toString() {
    return value + "p";
  }
}
