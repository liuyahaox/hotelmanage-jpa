package com.example.jpa.Record;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RecordDao extends CrudRepository<Record, Integer> {
    List<Record> findAll(Pageable pageable);
    List<Record> findAll();
}
