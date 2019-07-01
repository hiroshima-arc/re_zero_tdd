package rental;

public class Statement {
  Customer customer;

  Statement(Customer customer) {
    this.customer = customer;
  }

  String statement() {
    int totalAmount = 0;
    int points = 0;

    String result = customer.name() + "様のレンタル明細\n";

    for (Rental each : customer.rentals.asList()) {
      int thisAmount = each.amount();
      points += each.frequentPoints();
      result += "\t" + each.movie().title() + "\t" + thisAmount + "円\n";

      totalAmount += thisAmount;
    }

    result += "合計金額 " + totalAmount + "円\n";
    result += "獲得ポイント " + points + "p";
    return result;
  }
}
