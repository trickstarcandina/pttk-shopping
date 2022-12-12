package pttk.dao.order;

import pttk.dao.BaseDAO;
import pttk.model.order.Payment;

public interface PaymentDAO extends BaseDAO<Payment> {
    Payment findByOrderId(int orderId);
    void save(Payment payment, int orderId);
}
