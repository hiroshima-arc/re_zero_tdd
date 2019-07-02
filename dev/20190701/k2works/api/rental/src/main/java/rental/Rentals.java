package rental;

import rental.customer.Customer;
import rental.point.Point;
import java.util.ArrayList;
import java.util.List;

public class Rentals {
  Customer customer;
  List<Rental> rentals = new ArrayList<>();

  public Rentals(Customer customer) {
    this.customer = customer;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public List<Rental> asList() {
    return rentals;
  }

  public int totalAmount() {
    int result = 0;
    for (Rental each : rentals) {
      int thisAmount = each.chargeAmount();
      result += thisAmount;
    }

    return result;
  }

  public Point totalPoints() {
    Point result = new Point(0);
    for (Rental each : rentals) {
      result = result.add(each.frequentPoints());
    }
    return result;
  }

  public String customerName() {
    return customer.name();
  }
}
