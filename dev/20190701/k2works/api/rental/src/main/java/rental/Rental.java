package rental;

import static rental.MovieType.NEW_RELEASE;

class Rental {
  Movie movie;
  int daysRented;

  Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  Movie movie() {
    return movie;
  }

  int amount() {
    int baseAmount = 0;
    int additionalAmount = 0;

    int baseDays = 0;
    int amountPerDay = 0;

    MovieType movieType = movie.movieType();
    baseAmount = movieType.baseAmount;
    baseDays = movieType.baseDays;
    amountPerDay = movieType.amountPerDay;

    if (daysRented > baseDays) additionalAmount =
      (daysRented - baseDays) * amountPerDay;
    return baseAmount + additionalAmount;
  }

  int frequentPoints() {
    int points = 1;
    if (movie().movieType() == NEW_RELEASE && daysRented > 1) points++;

    return points;
  }
}
