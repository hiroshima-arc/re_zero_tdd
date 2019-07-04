package rental.presentation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import rental.application.StatementService;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableWebMvc
public class StatementApiController {

  @CrossOrigin
  @RequestMapping(path = "/api/textStatement", method = RequestMethod.GET)
  private Map<String, String> textStatement() {
    StatementService service = new StatementService();
    HashMap<String, String> result = new HashMap<>();
    result.put("statement", service.createStatment().statement());
    return result;
  }

  @CrossOrigin
  @RequestMapping(path = "/api/htmlStatement", method = RequestMethod.GET)
  private Map<String, String> htmlStatement() {
    StatementService service = new StatementService();
    HashMap<String, String> result = new HashMap<>();
    result.put("statement", service.createStatment().htmlStatement());
    return result;
  }
}
