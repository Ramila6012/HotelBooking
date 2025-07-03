package com.springboot.hotelbooking.controller;

import com.springboot.hotelbooking.entity.Customer;
import com.springboot.hotelbooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
public class HotelController {

    @Autowired
    private CustomerService service;

    //201 CREATED
    @PostMapping("/addCustomer")
    public ResponseEntity<String> createuser(@RequestBody Customer customer){
        service.addCustomer(customer);
        String message = "customer with " + customer.getName() + " added";
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>> getCustomers(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-app-name", "CustomerService");

        return ResponseEntity.ok()
                .header(String.valueOf(httpHeaders))
                .body(service.getcustomers());

    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id){

        Optional<Customer> customer = service.getCustomerById(id);

        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

    }

    @PutMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        service.addCustomer(customer);
        return "Customer with ID " + id + " updated successfully.";
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
        return "Customer with ID " + id + " deleted successfully.";
    }

    @GetMapping("/calculateTotal")
    public String calculateCost(@RequestParam String start_date, @RequestParam String end_date){
        LocalDate start = LocalDate.parse(start_date);
        LocalDate end = LocalDate.parse(end_date);

        long nights = ChronoUnit.DAYS.between(start, end);
        double per_night = 20;

        double base_price = nights * per_night;
        double gst = 0.09 * base_price;
        double total_price = base_price + gst;

//        Map<String, Object> result = new HashMap<>();
//        result.put("Nights: ", nights);
//        result.put("Base Price: ", base_price);
//        result.put("GST: ", gst);
//        result.put("Total Price: ", total_price);

        return "Total Price: $" + total_price;

    }

}
