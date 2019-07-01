package rental;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rental.rate.DaysRented;
import rental.rate.NewRelease;
import rental.rate.OldRelease;
import static rental.rate.MovieType.CHILDREN;
import static rental.rate.MovieType.REGULAR;

@RestController
public class StatementController {

  @CrossOrigin
  @RequestMapping("/")
  public String index() {
    Movie newReleaseMovie = new Movie("新作", new NewRelease());
    Movie childrenMovie = new Movie("子供", new OldRelease(CHILDREN));
    Movie regularMovie = new Movie("一般", new OldRelease(REGULAR));

    Rental newRelease = new Rental(newReleaseMovie, new DaysRented(3));
    Rental children = new Rental(childrenMovie, new DaysRented(2));
    Rental regular = new Rental(regularMovie, new DaysRented(1));

    Customer customer = new Customer("山田");

    Rentals rentals = new Rentals(customer);

    rentals.addRental(newRelease);
    rentals.addRental(children);
    rentals.addRental(regular);

    Statement statement = new Statement(rentals);

    return statement.statement();
  }
}
