package pttk.util.impl;

import pttk.model.customer.Account;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs) {
        try {
            Account account = new Account();
            account.setId(rs.getInt("ID"));
            account.setUsername(rs.getString("Username"));
            account.setPassword(rs.getString("Password"));
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
