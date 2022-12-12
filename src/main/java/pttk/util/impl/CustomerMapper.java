package pttk.util.impl;

import pttk.model.customer.Customer;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs) {
        try {
            Customer customer = new Customer();
            customer.setId(rs.getInt("ID"));
            customer.setRole(rs.getString("Role"));
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
