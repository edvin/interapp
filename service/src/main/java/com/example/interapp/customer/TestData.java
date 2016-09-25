package com.example.interapp.customer;

import com.example.interapp.model.Customer;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class TestData {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer(i, String.format("Customer #%d", i));
            em.persist(customer);
        }
    }
}
