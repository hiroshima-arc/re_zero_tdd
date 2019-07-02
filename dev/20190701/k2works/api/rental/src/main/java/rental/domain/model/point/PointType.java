package rental.domain.model.point;

import rental.domain.model.Days;

public enum PointType {
  NEW_RELEASE(Point.one), OLD_RELEASE(Point.zero);
  Point bonusPoint;

  PointType(Point bonusPoint) {
    this.bonusPoint = bonusPoint;
  }

  Point basePoint = Point.one;
  static Days bonusCriteria = Days.of(1);

  public Point point(Days daysRented) {
    if (daysRented.within(bonusCriteria)) return basePoint;
    return basePoint.add(bonusPoint);
  }
}
