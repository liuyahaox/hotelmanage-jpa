package com.example.jpa.Config;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class welcome {
  @RequestMapping("/")
  public ModelAndView index() {
      return new ModelAndView("login");
  }

//   @RequestMapping("/page")
//   public ModelAndView test() {
//       return new ModelAndView("redirect:/page/test.html");
//   }
  @RequestMapping("/loginerro")
  public ModelAndView test2() {
      return new ModelAndView("loginerro");
  }
  @RequestMapping("/tologout")
  public ModelAndView test3() {
    return new ModelAndView("logout");
}
@RequestMapping(value="/page")
public ModelAndView qufen(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if(auth.getAuthorities().toString().equals("[admin]"))
        return new ModelAndView ("redirect:/page/test.html");//如果是客户登录
    else
        return new ModelAndView("room/formroom");//如果是后台管理人员登录
}

    
}
