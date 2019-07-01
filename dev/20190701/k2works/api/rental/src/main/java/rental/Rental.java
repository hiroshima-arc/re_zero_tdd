package rental;

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
    MovieType movieType = movie.movieType();
    return movieType.point(daysRented);
  }
}
