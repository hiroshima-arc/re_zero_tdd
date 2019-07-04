package rental.application;

import org.springframework.stereotype.Service;
import rental.domain.Customer;
import rental.domain.Movie;
import rental.domain.Rental;

@Service
public class StatementService {

  public Customer createStatment() {
    Movie newReleaseMovie = new Movie("新作", Movie.NEW_RELEASE);
    Movie childrenMovie = new Movie("子供", Movie.CHILDREN);
    Movie regularMovie = new Movie("一般", Movie.REGULAR);

    Rental newRelease = new Rental(newReleaseMovie, 3);
    Rental children = new Rental(childrenMovie, 2);
    Rental regular = new Rental(regularMovie, 1);

    Customer customer = new Customer("山田");
    customer.addRental(newRelease);
    customer.addRental(children);
    customer.addRental(regular);

    return customer;
  }
}
