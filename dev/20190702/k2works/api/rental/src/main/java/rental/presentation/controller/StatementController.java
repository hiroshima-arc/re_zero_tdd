package rental.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatementController {

  @RequestMapping(value = "/index.html", method = RequestMethod.GET)
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("index");
    return mav;
  }
}
