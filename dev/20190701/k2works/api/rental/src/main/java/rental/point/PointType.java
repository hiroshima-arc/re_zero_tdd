package rental.point;

import rental.rate.DaysRented;

public enum PointType {
  NEW_RELEASE, OLD_RELEASE;
  public int point(DaysRented daysRented) {
    return 1 + bonusPoinnt(daysRented);
  }

  private int bonusPoinnt(DaysRented daysRented) {
    if (this != NEW_RELEASE) return 0;
    if (daysRented.lessThan(2)) return 0;

    return 1;
  }
}
