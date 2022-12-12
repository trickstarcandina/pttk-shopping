package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.model.customer.FullName;

public interface FullNameDAO extends BaseDAO {
    FullName findFullNameByCustomerID(int customerId);
}
