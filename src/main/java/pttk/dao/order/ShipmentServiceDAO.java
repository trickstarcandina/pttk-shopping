package pttk.dao.order;

import pttk.dao.BaseDAO;
import pttk.model.order.ShipmentService;

import java.util.List;

public interface ShipmentServiceDAO extends BaseDAO<ShipmentService> {
    List<ShipmentService> findAll();
    ShipmentService findById(int id);
}
