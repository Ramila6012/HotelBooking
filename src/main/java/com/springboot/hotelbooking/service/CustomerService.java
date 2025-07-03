package com.springboot.hotelbooking.service;

import com.springboot.hotelbooking.entity.Customer;
import com.springboot.hotelbooking.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Customer> getCustomerById(int id){
        return customerRepo.findById(id);
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}
