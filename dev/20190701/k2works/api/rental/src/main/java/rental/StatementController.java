package rental;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static rental.MovieType.CHILDREN;
import static rental.MovieType.NEW_RELEASE;
import static rental.MovieType.REGULAR;

@RestController
public class StatementController {

  @CrossOrigin
  @RequestMapping("/")
  public String index() {
    Movie newReleaseMovie = new Movie("新作", NEW_RELEASE);
    Movie childrenMovie = new Movie("子供", CHILDREN);
    Movie regularMovie = new Movie("一般", REGULAR);

    Rental newRelease = new Rental(newReleaseMovie, 3);
    Rental children = new Rental(childrenMovie, 2);
    Rental regular = new Rental(regularMovie, 1);

    Rentals rentals = new Rentals();
    rentals.addRental(newRelease);
    rentals.addRental(children);
    rentals.addRental(regular);

    Customer customer = new Customer("山田", rentals);
    Statement statement = new Statement(customer);

    return statement.statement();
  }
}
