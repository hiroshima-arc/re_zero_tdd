package rental.statement;

import rental.Rental;
import rental.Rentals;

public class Statement {
  Rentals rentals;

  public Statement(Rentals rentals) {
    this.rentals = rentals;
  }

  public String statement() {
    String result = rentals.customerName() + "様のレンタル明細\n";

    for (Rental each : rentals.asList()) {
      result += "\t" + each.movie().title() + "\t" + each.chargeAmount() + "\n";
    }

    result += "合計金額 " + rentals.totalAmount() + "\n";
    result += "獲得ポイント " + rentals.totalPoints();
    return result;
  }
}
