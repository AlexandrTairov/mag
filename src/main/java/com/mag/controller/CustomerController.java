package com.mag.controller;

import com.mag.entity.Customer;
import com.mag.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        try {
            Customer customer = customerService.findCustomerById(id);
            if (customer == null) {
                throw new NullPointerException();
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (NullPointerException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {

//            customerService.save(customer);
//            Customer createdCustomer = customerRepository.createCustomer(customer);
//            return new ResponseEntity<>(createdCustomer, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Something went wrong! " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
