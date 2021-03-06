package com.mag.controller;

import com.mag.entity.Customer;
import com.mag.entity.CustomerWithOrder;
import com.mag.entity.Order;
import com.mag.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping(value = "/WithOrder/{id}")
    public ResponseEntity<CustomerWithOrder> getCustomerWithOrderById(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8080/order/customer/" + customer.getId();
        Order order = restTemplate.getForObject(uri, Order.class);
        CustomerWithOrder response = new CustomerWithOrder(customer, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer createdCustomer = customerService.createCustomer(customer);
            if (createdCustomer == null) {
                throw new NullPointerException();
            }
            return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Something went wrong! " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
        try {
            customerService.deleteCustomerById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable Long id,
                                                         @RequestBody Customer customer) {
        try {
            customerService.updateCustomerById(id, customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
