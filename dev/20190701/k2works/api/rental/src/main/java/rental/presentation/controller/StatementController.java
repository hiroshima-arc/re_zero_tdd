package rental.presentation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rental.domain.model.DaysRented;
import rental.domain.model.Rental;
import rental.domain.model.Rentals;
import rental.domain.model.customer.Customer;
import rental.domain.model.movie.Movie;
import rental.domain.model.movie.MovieType;
import rental.presentation.view.statement.Statement;
import java.time.LocalDate;

@RestController
public class StatementController {

  @CrossOrigin
  @RequestMapping("/")
  public String index() {
    Movie newReleaseMovie = new Movie(
      "新作",
      LocalDate.now().minusDays(10),
      MovieType.Children
    );
    Movie childrenMovie = new Movie(
      "子供",
      LocalDate.now().minusDays(30 * 10),
      MovieType.Children
    );
    Movie regularMovie = new Movie(
      "一般",
      LocalDate.now().minusDays(30 * 5),
      MovieType.General
    );

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
