package com.example.interapp.service;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import java.util.logging.Logger;

public class Services {
    private static Logger log = Logger.getLogger("Services");

    /**
     * Lookup the CustomerService. You would add one of these for each service you introduce
     */
    public static CustomerService getCustomerService() {
        return getService("java:global/service/CustomerServiceImpl");
    }

    @SuppressWarnings("unchecked")
    /**
     * Lookup the given service and wait if the service is offline. After a timeout, throw an exception.
     */
    private static <T> T getService(String lookup) {
        Integer counter = 0;
        while (counter++ < 10) {
            try {
                return (T) new InitialContext().lookup(lookup);
            } catch (NameNotFoundException ex) {
                log.warning(String.format("Waiting for %s to come online...", lookup));
                sleep(1000);
            } catch (NamingException ex) {
                throw new RuntimeException(ex);
            }
        }
        throw new RuntimeException(String.format("Timeout waiting for %s", lookup));
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
