package com.example.jpa.Order;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderDao extends CrudRepository<Order,Integer> {
    List<Order> findAll(Pageable pageable);
    List<Order> findAll();
  
}
