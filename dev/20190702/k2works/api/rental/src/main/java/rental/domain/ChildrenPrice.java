package rental.domain;

public class ChildrenPrice extends Price {

  @Override
  int getPriceCode() {
    return Movie.CHILDREN;
  }

  int getCharge(int daysRented) {
    int result = 150;
    if (daysRented > 3) result += (daysRented - 3) * 150;
    return result;
  }
}
