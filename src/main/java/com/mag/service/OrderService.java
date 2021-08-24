package com.mag.service;

import com.mag.dao.OrderDAO;
import com.mag.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> findAllOrders() {
        return orderDAO.findAll();
    }

    public Order findOrderById(Long id) {
        if (orderDAO.existsById(id)) {
            return orderDAO.findOrderById(id);
        } else return null;
    }

    public Order createOrder(Order order) {
        try {
            orderDAO.save(order);
            return order;
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteOrderById(Long id) {
        try {
            orderDAO.deleteById(id);
        } catch (Exception ex) {
            System.out.println("Can`t delete");
        }
    }

    public void updateOrderById(Long id, Order order) {
        try {
            Order existOrder = orderDAO.findOrderById(id);
            if (existOrder == null) {
                throw new NullPointerException();
            } else {
                existOrder.setDescription(order.getDescription());
                orderDAO.save(existOrder);
            }
        } catch (Exception exception) {
            System.out.println("Error");
        }
    }
}
