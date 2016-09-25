package com.example.interapp.customer;

import com.example.interapp.model.Customer;
import com.example.interapp.service.CustomerService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerServiceImpl implements CustomerService {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public Customer getById(Integer id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> all() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
}
