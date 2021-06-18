package com.example.jpa.Room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
  
    @Autowired
    public Roommapper roommapper;

    public Room findroombyid(Integer id) {
       
       return roommapper.findroombyid(id);
    }

    public boolean bookroom(Integer id) {
        Room room = roommapper.findroombyid(id);
        room.setIsbooked(true);
        roommapper.updateroom(room);
        return true;
    }
    
 
     public List<Room> findallroomnobook() {
        return roommapper.findbyisbooked(false);
     }
    

}
