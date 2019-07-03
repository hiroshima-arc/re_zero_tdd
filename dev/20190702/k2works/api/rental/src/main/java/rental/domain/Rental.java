package rental.domain;

public class Rental {
  private Movie _movie;
  private int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  int getCharge() {
    int result = 0;
    switch (getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 200;
        if (getDaysRented() > 2) result += (getDaysRented() - 2) * 150;
        break;
      case Movie.NEW_RELEASE:
        result += getDaysRented() * 300;
        break;
      case Movie.CHILDREN:
        result += 150;
        if (getDaysRented() > 3) result += (getDaysRented() - 3) * 150;
        break;
    }
    return result;
  }

  int getFrequentRenterPoints() {
    int frequentRenterPoints = 0;

    //レンタルポイントを加算
    frequentRenterPoints++;

    //新作を二日以上借りた場合はボーナスポイント
    if (
      (getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1
    ) frequentRenterPoints++;
    return frequentRenterPoints;
  }
}
