package pttk.service;

import pttk.model.customer.Customer;

public interface CustomerService {
    Customer findByUserNameAndPassword(String username, String password);

    Boolean createNewCustomer(Customer customer);
    Boolean updateCustomer(Customer customer);
}
