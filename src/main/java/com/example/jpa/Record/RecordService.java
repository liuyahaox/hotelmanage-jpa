package com.example.jpa.Record;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    public Recordmapper recordmapper;

    public void saverecord(Integer customerid, Integer roomid) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Record record = new Record();
        record.setCustomerid(customerid);
        record.setRoomid(roomid);
        record.setStime(df.format(new Date()));
        recordmapper.insertrecord(record);
    }


    public int getprice(Record record, Integer price) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date stime = df.parse(record.getStime());
        Date etime = df.parse(record.getEtime());
        int day = (int) ((etime.getTime()-stime.getTime())/(24 * 60 * 60 * 1000));
        return day*price;
        
    }
}

