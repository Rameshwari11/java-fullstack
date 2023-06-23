package com.cgi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
