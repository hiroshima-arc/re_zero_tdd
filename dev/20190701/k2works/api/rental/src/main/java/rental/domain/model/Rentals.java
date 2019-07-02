package rental.domain.model;

import rental.domain.generics.Total;
import rental.domain.model.charge.Charge;
import rental.domain.model.customer.Customer;
import rental.domain.model.point.Point;
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

  public Charge charge() {
    Total<Rental, Charge> total = new Total<>(rentals, Rental::amount);
    return total.sum();
  }

  public Point points() {
    Total<Rental, Point> total = new Total<>(rentals, Rental::points);
    return total.sum();
  }

  public Customer customer() {
    return customer;
  }
}
