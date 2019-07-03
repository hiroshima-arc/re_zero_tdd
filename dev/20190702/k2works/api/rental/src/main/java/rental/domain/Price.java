package rental.domain;

abstract class Price {

  abstract int getPriceCode();

  int getCharge(int daysRented) {
    int result = 0;
    switch (getPriceCode()) {
      case Movie.REGULAR:
        result += 200;
        if (daysRented > 2) result += (daysRented - 2) * 150;
        break;
      case Movie.NEW_RELEASE:
        result += daysRented * 300;
        break;
      case Movie.CHILDREN:
        result += 150;
        if (daysRented > 3) result += (daysRented - 3) * 150;
        break;
    }
    return result;
  }
}
