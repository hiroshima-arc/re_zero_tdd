package rental.domain;

public class Movie {
  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private int _priceCode;
  Price _price;

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

  int getFrequentRenterPoints(int daysRented) {
    if (
      (getPriceCode() == NEW_RELEASE) && daysRented > 1
    ) return 2; else return 1;
  }
}
