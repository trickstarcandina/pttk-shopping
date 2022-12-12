package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.model.customer.Address;

public interface AddressDAO extends BaseDAO {
    Address findAddressByCustomerId(int customerId);
}
