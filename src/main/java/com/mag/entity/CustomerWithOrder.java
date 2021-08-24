package com.mag.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWithOrder {

    @Id
    private Long id;

    private String name;

    private String email;

    private String description;

    public CustomerWithOrder(Customer customer, Order order) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.description = order.getDescription();
    }
}
