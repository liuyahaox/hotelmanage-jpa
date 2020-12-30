package com.example.jpa.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.jpa.Order.Order;
import com.example.jpa.Order.OrderService;
import com.example.jpa.Record.Record;
import com.example.jpa.Record.RecordService;
import com.example.jpa.Room.Room;
import com.example.jpa.Room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
  CustomerDao customerDao;
  @Autowired
  CustomerService customerService;
  @Autowired
  RoomService roomservice;
  @Autowired
  RecordService recordservice;
  @Autowired
  OrderService orderservice;

  
  @RequestMapping(value = "/getallcustomer")
  public Map<String, Object> findallcustomer(int page, int limit) {
    Pageable pageable = PageRequest.of(page-1, limit);
    List<Customer> customers = customerService.findallcustomer(pageable);
    Map<String, Object> map = new HashMap<>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("count",customerDao.findAll().size());
    map.put("data",customers);
    return map;
    
  }
  @RequestMapping(value = "/getallroomnobook")
  public Map<String, Object> findallroomnobook(int page, int limit) {
    Pageable pageable = PageRequest.of(page-1, limit);
    List<Room> rooms = roomservice.findallroomnobook(pageable);
    Map<String, Object> map = new HashMap<>();
    map.put("code",0);
    map.put("msg", "");
    map.put("count",roomservice.findallroomnobook().size());
    map.put("data",rooms);
    return map;
  }
  @RequestMapping(value = "/getallrecord")
  public Map<String, Object> getallrecord(int page, int limit) {
    Pageable pageable = PageRequest.of(page-1, limit);
    List<Record> records = recordservice.findallrecord(pageable);
    Map<String, Object> map = new HashMap<>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("count",recordservice.findallrecord().size());
    map.put("data",records);
    return map;
    
  }
  
    @RequestMapping(value = "/getallroom")
    public Map<String, Object> findallroom(int page, int limit) {
      Pageable pageable = PageRequest.of(page-1, limit);
      List<Room> rooms = roomservice.findallroom(pageable);
      Map<String, Object> map = new HashMap<>();
      map.put("code",0);
      map.put("msg", "");
      map.put("count",roomservice.findallroom().size());
      map.put("data",rooms);
      return map;
    }
      
    @RequestMapping(value = "/getallorder")
    public Map<String, Object> findallorder(int page, int limit) {
      Pageable pageable = PageRequest.of(page-1, limit);
      List<Order> orders = orderservice.orderdao.findAll(pageable);
      Map<String, Object> map = new HashMap<>();
      map.put("code",0);
      map.put("msg", "");
      map.put("count",orderservice.orderdao.findAll().size());
      map.put("data",orders);
      return map;
    }
  
  @RequestMapping(value = "/lookcusinfo")
  public ModelAndView getcustomer() {
    ModelAndView mv = new ModelAndView("customer/formcustomer");
    return mv;
  }
  @RequestMapping(value = "/lookroominfo")
  public ModelAndView getroom() {
    ModelAndView mv = new ModelAndView("room/formroom");
    return mv;
  }
  @RequestMapping(value = "/lookrecordinfo")
  public ModelAndView lookrecordinfo() {
    ModelAndView mv = new ModelAndView("record/formrecord");
    return mv;
  }
  @RequestMapping(value = "/lookorderinfo")
  public ModelAndView lookorderinfo() {
    ModelAndView mv = new ModelAndView("order/formorder");
    return mv;
  }
  @RequestMapping(value = "/deleteCusbyid")
  public void deleteCusbyid(Integer id) {
    customerService.customerdao.deleteById(id);
  }
  @RequestMapping(value = "/deleteRoombyid")
  public void deleteRoombyid(Integer id) {
    roomservice.roomDao.deleteById(id);
  }
  @RequestMapping(value = "/deleteRecordbyid")
  public void deleteRecordbyid(Integer id) {
    System.out.println();
    recordservice.recordDao.deleteById(id);
  }

  @RequestMapping(value = "/updatecustomer")
  public String updatecustomer(Customer customer) {
    customerService.customerdao.save(customer);
    return "SUCCESS";
    
  }
  @RequestMapping(value = "/updateroom")
  public String updateroom(Room room) {
    roomservice.roomDao.save(room);
    return "SUCCESS";
  }
  
  @RequestMapping(value = "/updaterecord")
  public String updaterecord(Record record) {
    System.out.println(record.getId());
    recordservice.recordDao.save(record);
    return "SUCCESS";
  }
  @RequestMapping(value = "/editcustomer")
  public ModelAndView editcustomer(Integer id) {
    ModelAndView mv = new ModelAndView("customer/formcuslook");
    Customer customer = customerService.customerdao.findById(id).get();
    mv.addObject("customer", customer);
    return mv;
  }

  @RequestMapping(value = "/editroom")
  public ModelAndView editroom(Integer id) {
    ModelAndView mv = new ModelAndView("room/formroomlook");
    Room room = roomservice.roomDao.findById(id).get();
    mv.addObject("room", room);
    return mv;
  }
   @RequestMapping(value = "/editrecord")
  public ModelAndView editrecord(Integer id) {
    ModelAndView mv = new ModelAndView("record/formreclook");
    Record record = recordservice.recordDao.findById(id).get();
    System.out.println(record);
    mv.addObject("record", record);
    return mv;
  }
  
  
  @RequestMapping(value = "/addcustomer")
  public ModelAndView addcustomer() {
    ModelAndView mv = new ModelAndView("customer/formcuslook");
    return mv;
  }

  @RequestMapping(value = "/addroom")
  public ModelAndView addroom() {
    ModelAndView mv = new ModelAndView("room/formroomlook");
    return mv;
  }
  
  @RequestMapping(value = "/checkin")
  public void checkin(Integer customerid,Integer roomid) {
    recordservice.saverecord(customerid, roomid);
  }
  @RequestMapping(value = "/checkout")
  public int checkout(Integer recordid,Integer roomid) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
   int price = customerService.checkout(recordid, roomid);
   orderservice.orderdao.save(new Order(null, recordid, price,df.format(new Date())));
  return price;
  
  }
  

}
