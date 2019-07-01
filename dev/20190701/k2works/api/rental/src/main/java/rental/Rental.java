package rental;

import rental.rate.DaysRented;
import rental.rate.Rate;

class Rental {
  Movie movie;
  DaysRented daysRented;

  Rental(Movie movie, DaysRented daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  Movie movie() {
    return movie;
  }

  int amount() {
    Rate movieType = movie.movieType();
    return movieType.amount(daysRented);
  }

  int frequentPoints() {
    Rate movieType = movie.movieType();
    return movieType.point(daysRented);
  }
}
