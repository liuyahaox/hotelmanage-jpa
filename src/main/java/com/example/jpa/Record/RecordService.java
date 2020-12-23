package com.example.jpa.Record;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class RecordService {
    @Autowired
    RecordDao recordDao;

    public void saverecord(Integer customerid,Integer roomid){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Record record = new Record();
        record.setCustomerid(customerid);
        record.setRoomid(roomid);
        record.setStime(df.format(new Date()));
        recordDao.save(record);
    }
}
