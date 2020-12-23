package com.example.jpa.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.jpa.Record.Record;
import com.example.jpa.Record.RecordDao;
import com.example.jpa.Room.Room;
import com.example.jpa.Room.RoomDao;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    @Autowired
    CustomerDao customerdao;
    @Autowired
    RecordDao recordDao;
    @Autowired
    RoomDao roomDao;

    public boolean querryifbook(Integer id){
        Room room = roomDao.findById(id).get();
        if(room.isIsbooked()){
            return true;
        }
        else return false;
    }
    

    public boolean bookroom(Integer id){
        Room room = new Room();
        if(querryifbook(id)){
            return false;
        }
        else 
            room = roomDao.findById(id).get();
            room.setIsbooked(true);
            roomDao.save(room);
            return true; 
    }

    public boolean checkin(Integer roomid,Integer customerid){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Room room = roomDao.findById(roomid).get();
        Record record = new Record();
        if(querryifbook(roomid)){
            return false;
        }
        Customer customer = customerdao.findById(customerid).get();
        room.setIsempty(false);
        room.setIsbooked(true);
        customer.setRoomid(roomid);
        roomDao.save(room);
        record.setCustomerid(customerid);
        record.setRoomid(roomid);
        record.setStime(df.format(new Date()));
        recordDao.save(record);
        return true;

    }

    public void checkout(){

    }


    
}
