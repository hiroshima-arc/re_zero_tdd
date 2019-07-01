package rental;

class Movie {
  static final int CHILDREN = 2;
  static final int REGULAR = 0;
  static final int NEW_RELEASE = 1;

  String title;
  int priceCode;

  Movie(String title, int priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  int priceCode() {
    return this.priceCode;
  }

  void setPriceCode(int arg) {
    priceCode = arg;
  }

  String title() {
    return title;
  }
}
