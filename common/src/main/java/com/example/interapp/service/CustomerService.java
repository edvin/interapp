package com.example.interapp.service;

import com.example.interapp.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getById(Integer id);
    List<Customer> all();
}
