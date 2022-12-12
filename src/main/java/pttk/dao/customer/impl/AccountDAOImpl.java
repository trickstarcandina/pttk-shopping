package pttk.dao.customer.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.customer.AccountDAO;
import pttk.model.customer.Account;
import pttk.util.impl.AccountMapper;

import java.util.List;

public class AccountDAOImpl extends BaseDAOImpl implements AccountDAO {

    @Override
    public Account findAccountByUserNameAndPassword(String username, String password) {
        String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
        List<Account> accountList =  query(sql, new AccountMapper() ,username, password);
        return accountList.isEmpty() ? null : accountList.get(0);
    }
    @Override
    public Account findAccountByCustomerId(int customerId){
        String sql = "SELECT * FROM account WHERE CustomerID = ?";
        List<Account> accountList =  query(sql, new AccountMapper(), customerId);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public Account findById(Long id) {
        String sql = "SELECT * FROM `order` WHERE id = ?";
        List<Account> accounts = query(sql, new AccountMapper(), id);
         return accounts.isEmpty() ? null : accounts.get(0);
    }

}
