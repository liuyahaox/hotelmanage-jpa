package com.example.jpa.Room;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoomDao extends CrudRepository <Room,Integer>{
    @Query(value = "select * from room ",nativeQuery = true)
    Iterable<Room> findallroomnobook();
}
