package rental.domain;

public class RegularPrice extends Price {

  @Override
  int getPriceCode() {
    return Movie.REGULAR;
  }

  int getCharge(int daysRented) {
    int result = 200;
    if (daysRented > 2) result += (daysRented - 2) * 150;
    return result;
  }
}
