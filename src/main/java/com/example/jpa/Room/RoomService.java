package com.example.jpa.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoomService {
    @Autowired
    RoomDao roomDao;

    public Room findroombyid(Integer id) {
       // return roomDao.findById(id).get();
       return roomDao.findById(id).get();
    }

    public boolean bookroom(Integer id) {
        Room room = roomDao.findById(id).get();
        room.setIsbooked(true);
        roomDao.save(room);
        return true;
    }

    public void checkin(Integer roomid, Integer customerid) {
        Room room = roomDao.findById(roomid).get();
        room.setIsbooked(true);
        room.setIsempty(false);
        roomDao.save(room);
    }
    
    public Iterable<Room> findallroom() {
        return roomDao.findAll();
     }
     public Iterable<Room> findallroomnobook() {
        return roomDao.findallroomnobook();
     }
    

}
