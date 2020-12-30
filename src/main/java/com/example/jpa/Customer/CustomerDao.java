package com.example.jpa.Customer;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository <Customer,Integer>{
      
    List<Customer> findAll(Pageable pageable);
    List<Customer> findAll();
    
}
