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
import com.example.jpa.Record.Recordmapper;
import com.example.jpa.Room.Room;
import com.example.jpa.Room.RoomService;
import com.github.pagehelper.PageHelper;

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
  CustomerService customerService;
  @Autowired
  RoomService roomservice;
  @Autowired
  RecordService recordservice;
  @Autowired
  OrderService orderservice;
  @Autowired
  Customermapper customermapper;
  @Autowired
  Recordmapper recordmapper;

  @RequestMapping(value = "/getallcustomer")
  public Map<String, Object> findallcustomer(int page, int limit) {
    PageHelper.startPage(page, limit);
    List<Customer> customers = customermapper.findAll();
    Map<String, Object> map = new HashMap<>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("count", customermapper.findAll().size());
    map.put("data", customers);
    return map;

  }

  @RequestMapping(value = "/getallroomnobook")
  public Map<String, Object> findallroomnobook(int page, int limit) {
    PageHelper.startPage(page, limit);
    List<Room> rooms = roomservice.findallroomnobook();
    Map<String, Object> map = new HashMap<>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("count", roomservice.findallroomnobook().size());
    map.put("data", rooms);
    return map;
  }

  @RequestMapping(value = "/getallrecord")
  public Map<String, Object> getallrecord(int page, int limit) {
    PageHelper.startPage(page, limit);
    List<Record> records = recordmapper.findallrecord();
    System.out.println(records);
    Map<String, Object> map = new HashMap<>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("count", recordmapper.findallrecord());
    map.put("data", records);
    return map;

  }

  @RequestMapping(value = "/getallroom")
  public Map<String, Object> findallroom(int page, int limit) {
    PageHelper.startPage(page, limit);
    List<Room> rooms = roomservice.roommapper.findallroom();
    Map<String, Object> map = new HashMap<>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("count", roomservice.roommapper.findallroom().size());
    map.put("data", rooms);
    return map;
  }

  @RequestMapping(value = "/getallorder")
  public Map<String, Object> findallorder(int page, int limit) {
    PageHelper.startPage(page, limit);
    List<Order> orders = orderservice.ordermapper.findAll();
    Map<String, Object> map = new HashMap<>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("count", orderservice.ordermapper.findAll().size());
    map.put("data", orders);
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
    customerService.customermapper.deleteByid(id);
  }

  @RequestMapping(value = "/deleteRoombyid")
  public void deleteRoombyid(Integer id) {
    roomservice.roommapper.deletebyid(id);
  }

  @RequestMapping(value = "/deleteRecordbyid")
  public void deleteRecordbyid(Integer id) {
    System.out.println();
    recordservice.recordmapper.deleteById(id);
  }

  @RequestMapping(value = "/updatecustomer")
  public String updatecustomer(Customer customer) {
    if(customer.getId()!=null)
    customerService.customermapper.update(customer);
    else
    customerService.customermapper.insertcustomer(customer);
    return "SUCCESS";

  }

  @RequestMapping(value = "/updateroom")
  public String updateroom(Room room) {
    if(room.getId()!=null)
    roomservice.roommapper.updateroom(room);
    else
    roomservice.roommapper.insertroom(room);
    return "SUCCESS";
  }

  @RequestMapping(value = "/updaterecord")
  public String updaterecord(Record record) {
    if(record.getId()!=null)
    recordservice.recordmapper.updaterecord(record);
    else
    recordservice.recordmapper.insertrecord(record);
    return "SUCCESS";
  }

  @RequestMapping(value = "/editcustomer")
  public ModelAndView editcustomer(Integer id) {
    ModelAndView mv = new ModelAndView("customer/formcuslook");
    Customer customer = customerService.customermapper.findcustomerbyid();
    mv.addObject("customer", customer);
    return mv;
  }

  @RequestMapping(value = "/editroom")
  public ModelAndView editroom(Integer id) {
    ModelAndView mv = new ModelAndView("room/formroomlook");
    Room room = roomservice.roommapper.findroombyid(id);
    mv.addObject("room", room);
    return mv;
  }

  @RequestMapping(value = "/editrecord")
  public ModelAndView editrecord(Integer id) {
    ModelAndView mv = new ModelAndView("record/formreclook");
    Record record = recordservice.recordmapper.findrecordbyid(id);
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
  public void checkin(Integer customerid, Integer roomid) {
    recordservice.saverecord(customerid, roomid);
  }

  @RequestMapping(value = "/checkout")
  public int checkout(Integer recordid, Integer roomid) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    int price = customerService.checkout(recordid, roomid);
    orderservice.ordermapper.insertoreder(new Order(null, recordid, price, df.format(new Date())));
    return price;

  }
  @RequestMapping(value = "/testprocedure")
  public ModelAndView testprocedure() {
    ModelAndView mv = new ModelAndView("procedure");
    return mv;
  }
  // @RequestMapping(value = "/getprice")
  // public String getprice(String type,String stime,String etime) {
  //   System.out.println(customerDao.getcount(stime, etime, type));
  //   return stime+" 到 "+etime+ " "+type +" 类型的总收益是 " +customerDao.getcount(stime, etime, type);
  // }

}
