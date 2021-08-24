package com.mag.controller;

import com.mag.entity.Customer;
import com.mag.entity.Order;
import com.mag.service.CustomerService;
import com.mag.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getCustomerById(@PathVariable Long id) {
        try {
            Order order = orderService.findOrderById(id);
            if (order == null) {
                throw new NullPointerException();
            }
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (NullPointerException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getAll")
    public List<Order> getAllCustomers() {
        return orderService.findAllOrders();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order createdOrder = orderService.createOrder(order);
            if (createdOrder == null) {
                throw new NullPointerException();
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Something went wrong! " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
        try {
            orderService.deleteOrderById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> updateCustomerById(@PathVariable Long id,
                                                         @RequestBody Order customer) {
        try {
            orderService.updateOrderById(id, customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
