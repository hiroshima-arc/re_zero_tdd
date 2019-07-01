package rental;

public class Statement {
  Customer customer;

  Statement(Customer customer) {
    this.customer = customer;
  }

  String statement() {
    String result = customer.name() + "様のレンタル明細\n";

    for (Rental each : customer.rentals.asList()) {
      result += "\t" + each.movie().title() + "\t" + each.amount() + "円\n";
    }

    int totalAmount = customer.rentals.totalAmount();
    int points = customer.rentals.totalPoints();

    result += "合計金額 " + totalAmount + "円\n";
    result += "獲得ポイント " + points + "p";
    return result;
  }
}
