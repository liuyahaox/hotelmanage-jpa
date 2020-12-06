package com.example.jpa.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  
    @Autowired
    UserDao userDao;
     
    @RequestMapping("/test")
    public void test(){
    System.out.println(userDao.findAll());
   }

    
}
