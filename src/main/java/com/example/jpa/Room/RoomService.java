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
       
       return roomDao.findById(id).get();
    }

    public boolean bookroom(Integer id) {
        Room room = roomDao.findById(id).get();
        room.setIsbooked(true);
        roomDao.save(room);
        return true;
    }
    
    public List<Room> findallroom(Pageable pageable) {
        return roomDao.findAll(pageable);
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
