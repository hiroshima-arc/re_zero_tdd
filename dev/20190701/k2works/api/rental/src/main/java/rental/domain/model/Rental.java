package rental.domain.model;

import rental.domain.model.charge.Charge;
import rental.domain.model.charge.ChargeType;
import rental.domain.model.movie.Movie;
import rental.domain.model.point.Point;
import rental.domain.model.point.PointType;

public class Rental {
  Movie movie;
  Days days;

  public Movie getMovie() {
    return movie;
  }

  public Days getDays() {
    return days;
  }

  public Rental(Movie movie, Days days) {
    this.movie = movie;
    this.days = days;
  }

  public Movie movie() {
    return movie;
  }

  public Days days() {
    return days;
  }

  public Charge amount() {
    ChargeType type = ChargeType.of(movie);
    return type.amount(days);
  }

  public Point points() {
    PointType type = PointType.of(movie);
    return type.point(days);
  }
}
