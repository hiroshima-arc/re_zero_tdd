package rental.domain;

public class NewReleasePrice extends Price {

  @Override
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  int getCharge(int daysRented) {
    return daysRented * 300;
  }
}
