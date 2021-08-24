package com.mag.service;

import com.mag.dao.CustomerDAO;
import com.mag.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> findAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer findCustomerById(Long id) {
        if (customerDAO.existsById(id)) {
            return customerDAO.findCustomerById(id);
        } else return null;
    }

    public Customer createCustomer(Customer customer) {
        try {
            customerDAO.save(customer);
            return customer;
        } catch (Exception e) {
            return null;
        }
    }
}
