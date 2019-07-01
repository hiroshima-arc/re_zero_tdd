package rental;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatementController {

  @CrossOrigin
  @RequestMapping("/")
  public String index() {
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

    return customer.statement();
  }
}
