package rental.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import rental.domain.Customer;
import rental.domain.Movie;
import rental.domain.Rental;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableWebMvc
public class StatementController {

  @CrossOrigin
  @RequestMapping(path = "/statement", method = RequestMethod.GET)
  private Map<String, String> statement() {
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

    HashMap<String, String> result = new HashMap<>();
    result.put("statement", customer.statement());
    return result;
  }
}
