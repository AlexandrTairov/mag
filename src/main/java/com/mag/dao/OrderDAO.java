package com.mag.dao;

import com.mag.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long> {

    Order findOrderById(Long id);

    Order findOrderByCustomerId(Long id);
}
