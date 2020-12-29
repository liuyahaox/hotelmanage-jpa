package com.example.jpa.Config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class welcome {
    @RequestMapping(value = "/")
    public ModelAndView welcome() {
      ModelAndView mv = new ModelAndView("forward:/page/test.html");
      return mv;
    }
  
    
}
