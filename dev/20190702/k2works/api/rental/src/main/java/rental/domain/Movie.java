package rental.domain;

public class Movie {
  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private int _priceCode;

  public Movie(String title, int priceCode) {
    _title = title;
    _priceCode = priceCode;
  }

  public int getPriceCode() {
    return _priceCode;
  }

  public void setPriceCode(int arg) {
    _priceCode = arg;
  }

  public String getTitle() {
    return _title;
  }

  int getCharge(Rental rental) {
    int result = 0;
    switch (rental.getMovie().getPriceCode()) {
      case REGULAR:
        result += 200;
        if (rental.getDaysRented() > 2) result +=
          (rental.getDaysRented() - 2) * 150;
        break;
      case NEW_RELEASE:
        result += rental.getDaysRented() * 300;
        break;
      case CHILDREN:
        result += 150;
        if (rental.getDaysRented() > 3) result +=
          (rental.getDaysRented() - 3) * 150;
        break;
    }
    return result;
  }
}
