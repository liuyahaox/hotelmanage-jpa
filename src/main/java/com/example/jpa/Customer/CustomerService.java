package com.example.jpa.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.jpa.Record.Record;
import com.example.jpa.Record.RecordService;
import com.example.jpa.Room.Room;
import com.example.jpa.Room.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    public int checkout(Integer recordid,Integer roomid) throws Exception {
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         Record record = recordService.recordDao.findById(recordid).get();
         Room room = roomService.findroombyid(roomid);
         record.setEtime(df.format(new Date()));
         recordService.recordDao.save(record);
         return recordService.getprice(record,room.getPrice());
    }

    public List<Customer> findallcustomer(Pageable pageable) {
       return customerdao.findAll(pageable);
    }

    public List<Room> findallroomnobook(Pageable pageable) {
        return roomService.findallroomnobook(pageable);
     }

     
 


}
