package com.example.interapp.rest;

import com.example.interapp.service.CustomerService;
import com.example.interapp.service.Services;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class Imports {
    @Produces
    public CustomerService getCustomerService() {
        return Services.getCustomerService();
    }
}
