package com.example.jpa.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * PUT 更新 POST 添加 GET 查询 DELETE 删除
 */

@RestController
@RequestMapping( value = "/Customer")
public class CustomerController {
  @Autowired
  CustomerDao customerdao;

  CustomerService customerService = new CustomerService();

  @RequestMapping(value = "/lookcusinfo")
  public ModelAndView getcustomer(){
    ModelAndView mv = new ModelAndView("formcustomer");
    return mv;
}


  @RequestMapping(value = "/getallcustomer")
  public Iterable<Customer> findallcustomer() {
    customerService.findallcustomer();
     return customerdao.findAll();
  }

  


}
