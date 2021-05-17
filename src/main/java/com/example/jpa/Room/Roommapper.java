package com.example.jpa.Room;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Roommapper {
    @Select("select * from room")
    List<Room> findallroom();

    @Select("select * from room where id =#{id}")
    Room findroombyid(int id);
    
    @Update("update room set isempty=#{isempty},isbooked=#{isbooked},price=#{price},type=#{type} where id = #{id}")
    boolean updateroom(Room room);

    @Select("select * from room where isbooked=#{isbooked}")
    List<Room> findbyisbooked(boolean isbooked);

    @Delete("delete from room where id =#{is}")
    boolean deletebyid(int id);

    @Insert("insert room (isempty,isbooked,price,type) values (#{isempty},#{isbooked},#{price},#{type})")
    void insertroom(Room room);
}
