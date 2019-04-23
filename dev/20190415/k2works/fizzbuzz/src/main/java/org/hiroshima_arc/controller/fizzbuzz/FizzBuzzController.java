package org.hiroshima_arc.controller.fizzbuzz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FizzBuzzController {
    @RequestMapping(value = "/fizzbuzz", method = RequestMethod.GET)
    public ModelAndView fizzbuzz(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }
}
