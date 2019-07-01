package rental;

import rental.rate.Rate;

class Movie {
  String title;
  Rate movieType;

  Movie(String title, Rate movieType) {
    this.title = title;
    this.movieType = movieType;
  }

  Rate movieType() {
    return this.movieType;
  }

  String title() {
    return title;
  }
}
