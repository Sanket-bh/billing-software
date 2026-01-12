package com.boot.billing_software.services;

import com.boot.billing_software.entity.Customer;
import com.boot.billing_software.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer addCustomer(Customer customer){
        try{
            return repository.addCustomer(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findCustById(int id){
        try {
            return repository.findCustById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer updateById(int id,Customer customer){
        try{
            return repository.updateById(id, customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCust(){
        return repository.getAllCust();
    }

    public Customer getCustById(int id){
        try{
            return repository.getCustById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
