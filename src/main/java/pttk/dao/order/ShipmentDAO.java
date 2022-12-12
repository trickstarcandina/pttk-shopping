package pttk.dao.order;

import pttk.dao.BaseDAO;
import pttk.model.order.Shipment;

public interface ShipmentDAO extends BaseDAO<Shipment> {
    Shipment findByOrderId(int orderId);
    void save(Shipment shipment, int orderId);
}
