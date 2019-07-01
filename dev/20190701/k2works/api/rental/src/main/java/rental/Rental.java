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

  int daysRented() {
    return daysRented;
  }

  int amount() {
    int amount = 0;
    switch (movie().movieType()) {
      case REGULAR:
        amount += 200;
        if (daysRented() > 2) amount += (daysRented() - 2) * 150;
        break;
      case NEW_RELEASE:
        amount += daysRented() * 300;
        break;
      case CHILDREN:
        amount += 150;
        if (daysRented() > 3) amount += (daysRented() - 3) * 150;
    }

    return amount;
  }
}
