package rental.domain;

public class ChildrenPrice extends Price {

  @Override
  int getPriceCode() {
    return Movie.CHILDREN;
  }
}
