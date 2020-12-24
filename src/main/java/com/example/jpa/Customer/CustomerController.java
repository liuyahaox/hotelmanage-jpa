package com.example.jpa.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * PUT 更新
 * POST 添加
 * GET 查询
 * DELETE 删除
 */
@RestController
public class CustomerController {
  
    @Autowired
    CustomerDao customerDao;
     
    @RequestMapping(value = "/test")
    public Customer test(){
     return customerDao.findById(1).get(); 
   }
   @RequestMapping(value = "/test3")
   public Iterable<Customer> test3(){
    return customerDao.findAll();
  }

    @RequestMapping(value = "/")
    public ModelAndView test2(){
        ModelAndView mv = new ModelAndView("form");
        return mv;
    }

    
}
