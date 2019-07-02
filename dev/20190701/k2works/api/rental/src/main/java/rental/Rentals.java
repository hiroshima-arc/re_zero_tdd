package rental;

import generics.Total;
import rental.charge.Charge;
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

  public Charge totalAmount() {
    Total<Rental, Charge> total = new Total<>(rentals, Rental::chargeAmount);
    return total.sum();
  }

  public Point totalPoints() {
    Total<Rental, Point> total = new Total<>(rentals, Rental::frequentPoints);
    return total.sum();
  }

  public String customerName() {
    return customer.name();
  }
}
