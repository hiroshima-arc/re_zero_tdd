package rental.domain;

abstract class Price {

  abstract int getPriceCode();

  abstract int getCharge(int daysRented);

  int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
