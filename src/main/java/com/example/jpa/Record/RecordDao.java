package com.example.jpa.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordDao extends CrudRepository<Record, Integer> {
    
}
