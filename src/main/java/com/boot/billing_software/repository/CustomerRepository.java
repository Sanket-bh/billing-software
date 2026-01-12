package com.boot.billing_software.repository;

import com.boot.billing_software.entity.Customer;
import com.boot.billing_software.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private final ArrayList<Customer> list = new ArrayList<>();

    public Customer addCustomer(Customer customer) {
        list.add(customer);
        return customer;
    }

    public Customer findCustById(int id) {
        return list.stream().filter(c -> c.getId() == id).findFirst().
                orElse(null);
    }

    public Customer updateById(int id, Customer customer) {
        Customer existingCustomer = findCustById(id);
        if (existingCustomer != null) {
            existingCustomer.setName(customer.getName());
            existingCustomer.setPhone(customer.getPhone());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setAddress(customer.getAddress());
            return customer;
        } else {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public List<Customer> getAllCust() {
        return list;
    }

    public Customer getCustById(int id) {
        return list.stream().filter(c -> c.getId() == id).findFirst().
                orElse(null);
    }


}
