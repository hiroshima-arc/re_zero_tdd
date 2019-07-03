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
    String result = getName() + "様のレンタル明細" + "\n";
    for (Rental each : _rentals) {
      //この貸し出しに関する数値の表示
      result += "\t" + each.getMovie().getTitle() + "\t" + each._movie.getCharge(each.getDaysRented()) + "円\n";
    }

    //フッタ部分の追加
    result += "合計金額 " + getTotalAmount() + "円\n";
    result += "獲得ポイント " + getFrequentRenterPoints() + "ポイント";
    return result;
  }

  public String htmlStatement() {
    String result = "<H1><EM>" + getName() + "</EM>様のレンタル明細</H1>\n";
    for (Rental each : _rentals) {
      //この貸し出しに関する数値の表示
      result += each.getMovie().getTitle() + ": " + each._movie.getCharge(each.getDaysRented()) + "円<BR>\n";
    }

    //フッタ部分の追加
    result += "<P>合計金額 <EM>" + getTotalAmount() + "円</EM></P>\n";
    result +=
      "<P>獲得ポイント <EM>" + getFrequentRenterPoints() + "ポイント</EM></P>";
    return result;
  }

  private int getFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : _rentals) {
      frequentRenterPoints +=
        each._movie.getFrequentRenterPoints(each.getDaysRented());
    }
    return frequentRenterPoints;
  }

  private int getTotalAmount() {
    int totalAmount = 0;
    for (Rental each : _rentals) {
      totalAmount += each._movie.getCharge(each.getDaysRented());
    }
    return totalAmount;
  }
}
