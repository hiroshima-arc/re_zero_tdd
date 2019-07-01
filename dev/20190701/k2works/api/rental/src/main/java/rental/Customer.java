package rental;

import java.util.ArrayList;
import java.util.List;

class Customer {
  String name;
  List<Rental> rentals = new ArrayList<>();

  Customer(String name) {
    this.name = name;
  }

  void addRental(Rental rental) {
    rentals.add(rental);
  }

  String name() {
    return name;
  }

  String statement() {
    int totalAmount = 0;
    int points = 0;

    String result = name() + "様のレンタル明細\n";

    for (Rental each : rentals) {
      int thisAmount = 0;
      switch (each.movie().priceCode()) {
        case Movie.REGULAR:
          thisAmount += 200;
          if (each.daysRented() > 2) thisAmount +=
            (each.daysRented() - 2) * 150;
          break;
        case Movie.NEW_RELEASE:
          thisAmount += each.daysRented() * 300;
          break;
        case Movie.CHILDREN:
          thisAmount += 150;
          if (each.daysRented() > 3) thisAmount +=
            (each.daysRented() - 3) * 150;
      }

      points++;
      if (
        each.movie().priceCode() == Movie.NEW_RELEASE && each.daysRented() > 1
      ) points++;

      result += "\t" + each.movie().title() + "\t" + thisAmount + "円\n";

      totalAmount += thisAmount;
    }

    result += "合計金額 " + totalAmount + "円\n";
    result += "獲得ポイント " + points + "p";
    return result;
  }
}
