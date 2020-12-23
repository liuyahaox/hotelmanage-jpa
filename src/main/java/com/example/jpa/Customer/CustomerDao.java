package com.example.jpa.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Integer>{
    
}
