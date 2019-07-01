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

  int daysRented() {
    return daysRented;
  }

  int amount() {
    int baseAmount = 0;
    int additionalAmount = 0;
    switch (movie().movieType()) {
      case REGULAR:
        baseAmount = 200;
        if (daysRented() > 2) additionalAmount = (daysRented - 2) * 150;
        break;
      case NEW_RELEASE:
        baseAmount = 0;
        additionalAmount = daysRented() * 300;
        break;
      case CHILDREN:
        baseAmount = 150;
        if (daysRented() > 3) additionalAmount = (daysRented - 3) * 150;
    }

    return baseAmount + additionalAmount;
  }

  int frequentPoints() {
    int points = 1;
    if (movie().movieType() == NEW_RELEASE && daysRented > 1) points++;

    return points;
  }
}
