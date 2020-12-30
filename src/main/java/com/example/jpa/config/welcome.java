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
  // public void test() throws ParseException {
  //     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  //     String s = df.format(new Date());
  //     System.out.println(s);

  //   }
  
    
}
