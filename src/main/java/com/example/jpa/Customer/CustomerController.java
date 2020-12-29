package com.example.jpa.Customer;

import com.example.jpa.Room.Room;
import com.example.jpa.Room.RoomDao;
import com.example.jpa.Room.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * PUT 更新 POST 添加 GET 查询 DELETE 删除
 */

@RestController
@RequestMapping(value = "/Customer")
public class CustomerController {
  @Autowired
  RoomDao roomDao;
  @Autowired
  CustomerDao customerDao;
  @Autowired
  CustomerService customerService;
  @Autowired
  RoomService roomservice; 

  @RequestMapping(value = "/lookcusinfo")
  public ModelAndView getcustomer() {
    ModelAndView mv = new ModelAndView("formcustomer");
    return mv;
  }

  @RequestMapping(value = "/getallcustomer")
  public Iterable<Customer> findallcustomer() {
    return customerService.findallcustomer();
  }

  @RequestMapping(value = "/lookroominfo")
  public ModelAndView getroom() {
    ModelAndView mv = new ModelAndView("formroom");
    return mv;
  }
 
  @RequestMapping(value = "/getallroom")
  public Iterable<Room> findallroom() {
    return roomservice.findallroom();
  }
  
  @RequestMapping(value = "/getallroomnobook")
  public Iterable<Room> findallroomnobook() {
    return customerService.findallroomnobook();
  }

}
