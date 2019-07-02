package rental.domain.model;

import rental.domain.model.charge.Charge;
import rental.domain.model.charge.ChargeType;
import rental.domain.model.movie.Movie;
import rental.domain.model.point.Point;
import rental.domain.model.point.PointType;

public class Rental {
  Movie movie;
  DaysRented daysRented;

  public Rental(Movie movie, DaysRented daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie movie() {
    return movie;
  }

  public Charge chargeAmount() {
    return chargeType().amount(daysRented);
  }

  private ChargeType chargeType() {
    if (isNewRelease()) return ChargeType.NEW_RELEASE;
    if (movie.forChildre()) return ChargeType.CHILDREN;
    return ChargeType.REGULAR;
  }

  private boolean isNewRelease() {
    return movie.daysFromRelease() < 90;
  }

  Point frequentPoints() {
    return pointType().point(daysRented);
  }

  private PointType pointType() {
    if (isNewRelease()) return PointType.NEW_RELEASE;
    return PointType.OLD_RELEASE;
  }
}
