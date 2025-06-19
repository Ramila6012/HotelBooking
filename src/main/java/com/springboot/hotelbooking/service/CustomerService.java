package com.springboot.hotelbooking.service;

import com.springboot.hotelbooking.entity.Customer;
import com.springboot.hotelbooking.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public List<Customer> getcustomers(){
        return customerRepo.findAll();
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}
