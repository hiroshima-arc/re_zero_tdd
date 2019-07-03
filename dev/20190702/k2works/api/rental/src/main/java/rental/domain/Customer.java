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
    int frequentRenterPoints = 0;
    String result = getName() + "様のレンタル明細" + "\n";
    for (Rental each : _rentals) {
      frequentRenterPoints += each.getFrequentRenterPoints();

      //この貸し出しに関する数値の表示
      result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "円\n";
    }

    //フッタ部分の追加
    result += "合計金額 " + getTotalAmount() + "円\n";
    result += "獲得ポイント " + frequentRenterPoints + "ポイント";
    return result;
  }

  private int getTotalAmount() {
    int totalAmount = 0;
    for (Rental each : _rentals) {
      totalAmount += each.getCharge();
    }
    return totalAmount;
  }
}
