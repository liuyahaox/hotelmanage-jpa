package com.example.jpa.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
  
    @Autowired
    CustomerDao customerDao;
     
    @RequestMapping("/test")
    public void test(){
    System.out.println(customerDao.findAll());
   }

    
}
