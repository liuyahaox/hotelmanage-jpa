package com.example.jpa.Record;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Recordmapper {
    @Select("select id,roomid,customerid,stime,etime from record")
    List<Record> findallrecord();

    @Insert("insert into record (roomid,customerid,stime,etime) values (#{roomid},#{customerid},#{stime},#{etime})")
    void insertrecord(Record record);

    @Delete("delete from record where id = #{id}")
    boolean deleteById(int id);

    @Select("select * from record where id = #{id}")
    Record findrecordbyid(int id);

    @Update("update record set roomid = #{roomid},customerid = #{customerid},stime = #{stime},etime = #{etime} where id = #{id}")
    boolean updaterecord(Record record);


}
