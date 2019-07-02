package rental.domain.model;

import rental.domain.model.charge.Charge;
import rental.domain.model.charge.ChargeType;
import rental.domain.model.movie.Movie;
import rental.domain.model.point.Point;
import rental.domain.model.point.PointType;

public class Rental {
  Movie movie;
  Days days;

  public Rental(Movie movie, Days days) {
    this.movie = movie;
    this.days = days;
  }

  public Movie movie() {
    return movie;
  }

  public Charge chargeAmount() {
    return chargeType().amount(days);
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
    return pointType().point(days);
  }

  private PointType pointType() {
    if (isNewRelease()) return PointType.NEW_RELEASE;
    return PointType.OLD_RELEASE;
  }
}
