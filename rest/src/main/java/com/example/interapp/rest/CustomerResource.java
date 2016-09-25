package com.example.interapp.rest;

import com.example.interapp.model.Customer;
import com.example.interapp.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("customer")
@Produces("application/json")
public class CustomerResource {
    @Inject CustomerService customerService;

    @GET
    @Path("{id}")
    public Customer getCustomer(@PathParam("id") Integer id) {
        Customer customer = customerService.getById(id);
        System.out.println(String.format("Resource retrieved Customer %d with instance id %d", customer.getId(), System.identityHashCode(customer)));
        return customer;
    }

    @GET
    public List<Customer> all() {
        return customerService.all();
    }
}
