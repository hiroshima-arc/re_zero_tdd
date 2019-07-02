package rental.point;

import rental.DaysRented;

public enum PointType {
  NEW_RELEASE, OLD_RELEASE;
  Point zero = new Point(0);
  Point one = new Point(1);

  Point basePoint = one;

  public Point point(DaysRented daysRented) {
    return basePoint.add(bonusPoint(daysRented));
  }

  private Point bonusPoint(DaysRented daysRented) {
    if (this != NEW_RELEASE) return zero;
    if (daysRented.lessThan(2)) return zero;

    return one;
  }
}
