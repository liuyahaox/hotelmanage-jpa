package com.example.jpa.Room;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoomDao extends CrudRepository <Room,Integer>{
    List<Room> findByisbooked(boolean s,Pageable pageable);
    List<Room> findByisbooked(boolean s);
    List<Room> findAll(Pageable pageable);
    List<Room> findAll();
}
