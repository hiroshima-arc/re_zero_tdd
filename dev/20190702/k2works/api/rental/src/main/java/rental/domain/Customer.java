package rental.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String _name;
  private List<Rental> _rentals = new ArrayList<>();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.add(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    int totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = getName() + "様のレンタル明細" + "\n";
    for (Rental each : _rentals) {
      int thisAmount = 0;

      thisAmount = amountFor(each);

      //レンタルポイントを加算
      frequentRenterPoints++;

      //新作を二日以上借りた場合はボーナスポイント
      if (
        (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
        each.getDaysRented() > 1
      ) frequentRenterPoints++;

      //この貸し出しに関する数値の表示
      result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "円\n";
      totalAmount += thisAmount;
    }

    //フッタ部分の追加
    result += "合計金額 " + totalAmount + "円\n";
    result += "獲得ポイント " + frequentRenterPoints + "ポイント";
    return result;
  }

  private int amountFor(Rental aRental) {
    int result = 0;
    switch (aRental.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 200;
        if (aRental.getDaysRented() > 2) result +=
          (aRental.getDaysRented() - 2) * 150;
        break;
      case Movie.NEW_RELEASE:
        result += aRental.getDaysRented() * 300;
        break;
      case Movie.CHILDREN:
        result += 150;
        if (aRental.getDaysRented() > 3) result +=
          (aRental.getDaysRented() - 3) * 150;
        break;
    }
    return result;
  }
}
