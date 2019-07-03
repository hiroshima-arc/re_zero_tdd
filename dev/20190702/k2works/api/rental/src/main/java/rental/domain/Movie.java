package rental.domain;

public class Movie {
  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private int _priceCode;
  private Price _price;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public void setPriceCode(int arg) {
    switch (arg) {
      case REGULAR:
        _price = new RegularPrice();
        break;
      case CHILDREN:
        _price = new ChildrenPrice();
        break;
      case NEW_RELEASE:
        _price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("不正な料金コード");
    }
  }

  public String getTitle() {
    return _title;
  }

  int getCharge(int daysRented) {
    int result = 0;
    switch (getPriceCode()) {
      case REGULAR:
        result += 200;
        if (daysRented > 2) result += (daysRented - 2) * 150;
        break;
      case NEW_RELEASE:
        result += daysRented * 300;
        break;
      case CHILDREN:
        result += 150;
        if (daysRented > 3) result += (daysRented - 3) * 150;
        break;
    }
    return result;
  }

  int getFrequentRenterPoints(int daysRented) {
    if (
      (getPriceCode() == NEW_RELEASE) && daysRented > 1
    ) return 2; else return 1;
  }
}
