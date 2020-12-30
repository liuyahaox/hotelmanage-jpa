package com.example.jpa.Record;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    public RecordDao recordDao;

    public void saverecord(Integer customerid, Integer roomid) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Record record = new Record();
        record.setCustomerid(customerid);
        record.setRoomid(roomid);
        record.setStime(df.format(new Date()));
        recordDao.save(record);
    }

    public List<Record> findallrecord(Pageable pageable) {
        return recordDao.findAll(pageable);
    }

    public List<Record> findallrecord() {
        return recordDao.findAll();
    }

    public int getprice(Record record, int price) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date stime = df.parse(record.getStime());
        Date etime = df.parse(record.getEtime());
        int day = (int) ((stime.getTime()-etime.getTime())/(24 * 60 * 60 * 1000));
        return day*price;
        
    }
}

