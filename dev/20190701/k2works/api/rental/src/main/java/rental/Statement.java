package rental;

public class Statement {
  Rentals rentals;

  Statement(Rentals rentals) {
    this.rentals = rentals;
  }

  String statement() {
    String result = rentals.customer.name() + "様のレンタル明細\n";

    for (Rental each : rentals.asList()) {
      result += "\t" + each.movie().title() + "\t" + each.amount() + "円\n";
    }

    int totalAmount = rentals.totalAmount();
    int points = rentals.totalPoints();

    result += "合計金額 " + totalAmount + "円\n";
    result += "獲得ポイント " + points + "p";
    return result;
  }
}
