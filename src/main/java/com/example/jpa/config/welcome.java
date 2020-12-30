package com.example.jpa.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class welcome {
    @RequestMapping(value = "/")
    public ModelAndView welcome1() {
      ModelAndView mv = new ModelAndView("forward:/page/test.html");
      return mv;
    }

    // @RequestMapping(value = "/")
    // public ModelAndView test() {
    //   ModelAndView mv = new ModelAndView("formcuslook");
    //   Customer customer = new Customer(12,"测试1","男","123124",21);
    //   mv.addObject("customer", customer);
    //   return mv;
    // }
  
    
}
