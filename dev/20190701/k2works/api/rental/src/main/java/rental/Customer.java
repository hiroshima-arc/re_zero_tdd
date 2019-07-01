package rental;

class Customer {
  String name;
  Rentals rentals = new Rentals();

  Customer(String name, Rentals rentals) {
    this.name = name;
    this.rentals = rentals;
  }

  String name() {
    return name;
  }

  String statement() {
    int totalAmount = 0;
    int points = 0;

    String result = name() + "様のレンタル明細\n";

    for (Rental each : rentals.asList()) {
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
