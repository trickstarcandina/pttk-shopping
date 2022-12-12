package pttk.dao.order.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.order.CashDAO;
import pttk.dao.order.CreditDAO;
import pttk.dao.order.PaymentDAO;
import pttk.model.order.Cash;
import pttk.model.order.Credit;
import pttk.model.order.Payment;
import pttk.util.impl.PaymentMapper;

import java.util.List;

public class PaymentDAOImpl extends BaseDAOImpl<Payment> implements PaymentDAO {

    private final CashDAO cashDAO = new CashDAOImpl();
    private final CreditDAO creditDAO = new CreditDAOImpl();
    @Override
    public Payment findByOrderId(int orderId) {
        String sql = "SELECT * FROM Payment WHERE OrderID = ?";
        List<Payment> payments = query(sql, new PaymentMapper(), orderId);
        Payment payment = payments.isEmpty() ? null : payments.get(0);
        Cash cash = cashDAO.findByPaymentId(payment.getId());
        Credit credit = creditDAO.findByPaymentId(payment.getId());
        if (cash != null) {
            return cash;
        }
        if(credit != null) {
            return credit;
        }
        return payment;
    }

    @Override
    public void save(Payment payment, int orderId) {
        String sql = "INSERT INTO Payment(OrderId, Amount) VALUES(?, ?)";
        Long id = insert(sql, orderId, payment.getAmount());
        if (payment instanceof Cash) {
            Cash cash = (Cash) payment;
            cashDAO.save(cash, Math.toIntExact(id));
        }
        else {
            Credit credit = (Credit) payment;
            creditDAO.save(credit, Math.toIntExact(id));
        }
    }
}
