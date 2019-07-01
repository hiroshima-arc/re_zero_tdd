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
    MovieType movieType = movie.movieType();
    return movieType.amount(daysRented);
  }

  int frequentPoints() {
    int points = 1;
    if (movie().movieType() == NEW_RELEASE && daysRented > 1) points++;

    return points;
  }
}
