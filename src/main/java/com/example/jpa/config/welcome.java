package com.example.jpa.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class welcome {
  @RequestMapping("/")
  public ModelAndView index() {
      return new ModelAndView("login");
  }

  @RequestMapping("/page")
  public ModelAndView test() {
      return new ModelAndView("redirect:/page/test.html");
  }
  @RequestMapping("/loginerro")
  public ModelAndView test2() {
      return new ModelAndView("loginerro");
  }
  @RequestMapping("/tologout")
  public ModelAndView test3() {
    return new ModelAndView("logout");
}

    
}
