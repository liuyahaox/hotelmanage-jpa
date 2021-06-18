package com.example.jpa.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequestMapping("/User")
public class Usercontroller {
    @Autowired
    Usermapper usermapper;
    @Autowired
    UserDetailsService myservice;
    @RequestMapping("/regist")
    public String registuser(MUser user){
        if(usermapper.findByUsername(user.username)!=null)
          return "用户名已存在" ;
        else
        {
          usermapper.save(user);
          return "SUCCESS";
        }
    }
    
    @RequestMapping("/registration")
    public ModelAndView registt(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("registraion");
        return mv;
    }

}
