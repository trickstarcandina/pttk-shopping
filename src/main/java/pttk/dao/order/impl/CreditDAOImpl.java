package pttk.dao.order.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.order.CreditDAO;
import pttk.model.order.Cash;
import pttk.model.order.Credit;
import pttk.util.impl.CashMapper;
import pttk.util.impl.CreditMapper;

import java.util.List;

public class CreditDAOImpl extends BaseDAOImpl<Credit> implements CreditDAO {
    @Override
    public Credit findByPaymentId(int paymentId) {
        String sql = "SELECT * FROM Credit WHERE PaymentID = ?";
        List<Credit> creditList = query(sql, new CreditMapper(), paymentId);
        Credit credit = creditList.isEmpty() ? null : creditList.get(0);
        return credit;
    }

    @Override
    public void save(Credit credit, int paymentId) {
        String sql = "INSERT INTO Credit(CreditId, Name, PaymentID) VALUES(?, ?, ?)";
        insert(sql, credit.getCreditId(), credit.getName(), paymentId);
    }
}
