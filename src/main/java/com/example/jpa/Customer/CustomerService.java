package com.example.jpa.Customer;

import com.example.jpa.Record.RecordService;
import com.example.jpa.Room.Room;
import com.example.jpa.Room.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService { 
    @Autowired
    CustomerDao customerdao;
    @Autowired
    RecordService recordService;
    @Autowired
    RoomService roomService;

    public void regist() {

    }

    public boolean querryifbook(Integer id) {
        Room room = roomService.findroombyid(id);
        if (room.isIsbooked()) {
            return true;
        } else
            return false;
    }

    public boolean bookroom(Integer id) {
        if (querryifbook(id)) {
            return false;
        } else
            return roomService.bookroom(id);
    }

    public boolean checkin(Integer roomid, Integer customerid) {
        if (querryifbook(roomid)) {
            return false;
        }
        roomService.checkin(roomid, customerid);
        recordService.saverecord(customerid, roomid);
        customerdao.findById(customerid).get().setRoomid(roomid);
        return true;

    }
    public void checkout() {

    }

    public Iterable<Customer> findallcustomer() {
       return customerdao.findAll();
    }

    public Iterable<Room> findallroomnobook() {
        return roomService.findallroomnobook();
     }
 


}
