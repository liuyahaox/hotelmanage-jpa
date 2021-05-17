package com.example.jpa.Order;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface Ordermapper {
    @Select("select * from myorder")
    public List<Order> findAll();

    @Insert("insert into myorder (recordid,price,time) values(#{recordid},#{price},#{time})")
    public void insertoreder(Order order);
    
}
