package pttk.dao.order;

import pttk.dao.BaseDAO;
import pttk.model.order.Credit;

public interface CreditDAO extends BaseDAO<Credit> {
    Credit findByPaymentId(int paymentId);
    void save(Credit credit, int paymentId);
}
