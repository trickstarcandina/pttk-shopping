package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.model.customer.Account;
import pttk.model.customer.Customer;
import pttk.model.order.Cart;

public interface CustomerDAO extends BaseDAO {
    Customer findByAccount(Account account);
    Customer findCustomerByCart(Cart Cart);
    Customer findById(int id);
    public Boolean create(Customer customer);
    Boolean update(Customer customer);
}
