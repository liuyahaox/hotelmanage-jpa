package com.example.jpa.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * PUT 更新
 * POST 添加
 * GET 查询
 * DELETE 删除
 */
@RestController
@RequestMapping("/Customer")
public class CustomerController {
  
    @Autowired
    CustomerDao customerDao;
     
    @RequestMapping(value = "/test",method = RequestMethod. GET)
    public void test(){
    System.out.println(customerDao.findAll());
    
   }

    
}
