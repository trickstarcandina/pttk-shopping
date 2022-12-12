package pttk.service.impl;

import pttk.dao.customer.CustomerDAO;
import pttk.dao.customer.impl.CustomerDAOImpl;
import pttk.model.customer.Account;
import pttk.model.customer.Customer;
import pttk.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public Customer findByUserNameAndPassword(String username, String password) {
        Account account = new Account(username, password);
        return customerDAO.findByAccount(account);
    }
    @Override
    public Boolean createNewCustomer(Customer customer) {
       return customerDAO.create(customer);
    }

    @Override
    public Boolean updateCustomer(Customer customer) {
        return customerDAO.update(customer);
    }
    
}
