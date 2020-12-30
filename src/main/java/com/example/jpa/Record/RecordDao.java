package com.example.jpa.Record;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface RecordDao extends CrudRepository<Record, Integer> {
    List<Record> findAll(Pageable pageable);
    List<Record> findAll();
}
