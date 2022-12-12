package pttk.dao.customer.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.customer.AccountDAO;
import pttk.dao.customer.AddressDAO;
import pttk.dao.customer.CustomerDAO;
import pttk.dao.customer.FullNameDAO;
import pttk.model.customer.Account;
import pttk.model.customer.Customer;
import pttk.model.order.Cart;
import pttk.util.impl.CustomerMapper;

import java.util.List;
import pttk.model.customer.Address;
import pttk.model.customer.FullName;

public class CustomerDAOImpl extends BaseDAOImpl implements CustomerDAO{
    private final AccountDAO accountDAO = new AccountDAOImpl();
    private final AddressDAO addressDAO = new AddressDAOImpl();
    private final FullNameDAO fullNameDAO = new FullNameDAOImpl();

    @Override
    public Customer findByAccount(Account account) {
        account = accountDAO.findAccountByUserNameAndPassword(account.getUsername(), account.getPassword());
        if(account != null) {
            String sql = "SELECT c.* FROM Customer c LEFT JOIN Account a ON c.id = a.CustomerID WHERE a.id = ?";
            List<Customer> customers = query(sql, new CustomerMapper(), account.getId());
            Customer customer = customers.isEmpty() ? null : customers.get(0);
            if (customer != null) {
                int customerId = customer.getId();
                customer.setAccount(account);
                customer.setAddress(addressDAO.findAddressByCustomerId(customerId));
                customer.setFullName(fullNameDAO.findFullNameByCustomerID(customerId));
            }
            return customer;
        }
        return null;
    }

    @Override
    public Customer findCustomerByCart(Cart Cart) {
        String sql = "SELECT * FROM Customer, Cart " +
                "Where Customer.ID = Cart.CustomerID" +
                "and Card.ID = ?";
        List<Customer> customers = query(sql, new CustomerMapper(), Cart.getId());
        Customer customer = customers.isEmpty() ? null : customers.get(0);
        if(customer != null) {
            int customerId = customer.getId();
            customer.setAccount(accountDAO.findAccountByCustomerId(customerId));
            customer.setAddress(addressDAO.findAddressByCustomerId(customerId));
            customer.setFullName(fullNameDAO.findFullNameByCustomerID(customerId));
        }
        return customer;
    }

    @Override
    public Customer findById(int id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        List<Customer> customers = query(sql, new CustomerMapper(), id);
        Customer customer = customers.isEmpty() ? null : customers.get(0);
        if(customer != null) {
            int customerId = customer.getId();
            customer.setAccount(accountDAO.findAccountByCustomerId(customerId));
            customer.setAddress(addressDAO.findAddressByCustomerId(customerId));
            customer.setFullName(fullNameDAO.findFullNameByCustomerID(customerId));
        }
        return customer;
    }

    @Override
    public Boolean create(Customer customer) {
         try {
            String sqlCustomer = "INSERT INTO `customer` (Role) VALUES (?)";
            Long idCustomer = insert(sqlCustomer, "customer");
            Account account = customer.getAccount();
            String sqlAccount = "INSERT INTO `account` (Username, Password, CustomerID) VALUES ( ?, ?,?)";
            long idAccount = accountDAO.insert(sqlAccount ,account.getUsername(), account.getPassword(),idCustomer);
            FullName fullname = customer.getFullName();
            String sqlFullname = "INSERT INTO `fullname` (FirstName, MiddleName, LastName,CustomerID) VALUES ( ?, ?,?,?)";
            long idFullname = fullNameDAO.insert(sqlFullname ,fullname.getFirstName(), fullname.getMiddleName(),fullname.getLastName(),idCustomer);
            String sqlAddress = "INSERT INTO `address` (NumberHouse, Street, District,City,Nation,CustomerID) VALUES ( ?, ?,?,?,?,?)";
            long idAdress = addressDAO.insert(sqlAddress,0,"","","","" ,idCustomer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Customer customer) {
        try {
            int idCustomer = customer.getId();
            //update password
            Account account = customer.getAccount();
            String sqlAccount = "UPDATE `account` SET Password =? WHERE CustomerID = ? ";
            accountDAO.update(sqlAccount, account.getPassword(),idCustomer);
            //update fullname
            
            FullName fullname = customer.getFullName();
            if(fullname.isValid() == true){
                String sqlFullName = "UPDATE `fullname` SET FirstName =?,MiddleName=?,LastName=? WHERE CustomerID = ? ";
            fullNameDAO.update(sqlFullName, fullname.getFirstName(),fullname.getMiddleName(),fullname.getLastName(),idCustomer);
            }
            

            //update
            Address address = customer.getAddress();
                 String sqlAddress = "UPDATE `address` SET NumberHouse =?,Street=?,District=?,City=?,Nation=? WHERE CustomerID = ? ";
                 fullNameDAO.update(sqlAddress,address.getNumberHouse(),address.getStreet(),address.getDistrict(),address.getCity(),address.getNation() ,idCustomer);
            System.out.println("pttk.dao.customer.impl.CustomerDAOImpl.update()-------------------");
             return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}
