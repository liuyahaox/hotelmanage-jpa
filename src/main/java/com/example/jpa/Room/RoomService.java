package com.example.jpa.Room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class RoomService {
    @Autowired
    public RoomDao roomDao;

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
    
    public List<Room> findallroom() {
        return roomDao.findAll();
     }

     public List<Room> findallroomnobook(Pageable pageable) {
        return roomDao.findByisbooked(false,pageable);
     }

     public List<Room> findallroomnobook() {
        return roomDao.findByisbooked(false);
     }
    

}
