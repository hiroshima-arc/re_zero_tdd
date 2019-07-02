package rental.presentation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rental.domain.model.Days;
import rental.domain.model.Rental;
import rental.domain.model.Rentals;
import rental.domain.model.customer.Customer;
import rental.domain.model.movie.Movie;
import rental.domain.model.movie.ReleaseDate;
import rental.presentation.view.statement.Statement;
import java.time.LocalDate;

@RestController
public class StatementController {

  @CrossOrigin
  @RequestMapping("/")
  public String index() {
    ReleaseDate tenDaysBefore = new ReleaseDate(LocalDate.now().minusDays(10));
    ReleaseDate tenMonthsBefore = new ReleaseDate(
      LocalDate.now().minusMonths(10)
    );
    ReleaseDate fiveMonthBefore = new ReleaseDate(
      LocalDate.now().minusMonths(5)
    );

    Movie newOne = Movie.children("新作", tenDaysBefore);
    Movie children = Movie.children("子供", tenMonthsBefore);
    Movie regular = Movie.create("一般", fiveMonthBefore);

    Customer customer = new Customer("山田");

    Rentals rentals = new Rentals(customer);

    rentals.addRental(new Rental(newOne, Days.of(3)));
    rentals.addRental(new Rental(children, Days.of(2)));
    rentals.addRental(new Rental(regular, Days.of(1)));

    Statement statement = new Statement(rentals);

    return statement.statement();
  }
}
