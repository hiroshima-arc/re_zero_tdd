package rental.presentation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rental.application.service.RentalService;
import rental.presentation.view.statement.Statement;
import rental.presentation.view.statement.StatementDTO;

@RestController
public class StatementController {

  @CrossOrigin
  @RequestMapping("/text")
  public String text() {
    RentalService service = new RentalService();
    Statement statement = new Statement(service.createRentals());

    return statement.statement();
  }

  @CrossOrigin
  @RequestMapping("/json")
  public StatementDTO json() {
    RentalService service = new RentalService();

    return new StatementDTO(service.createRentals());
  }
}
