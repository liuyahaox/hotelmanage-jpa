package com.example.jpa.Customer;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Customermapper {
    @Select("select * from customer")
    List<Customer> findAll();
    @Select("select * from customer where id = #{id}")
    Customer findcustomerbyid();
    @Delete("delete from customer where id = #{id}")
    boolean deleteByid(int id);
    @Update("update customer set name = #{name},sex = #{sex},ident = #{ident},roomid = #{roomid} where id = #{id}")
    boolean update(Customer customer);
    @Insert("insert into customer (name,sex,ident,roomid) values(#{name},#{sex},#{ident},#{roomid})")
    void insertcustomer(Customer customer);
    
}
