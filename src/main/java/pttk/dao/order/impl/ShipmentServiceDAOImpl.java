package pttk.dao.order.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.order.ShipmentServiceDAO;
import pttk.model.order.ShipmentService;
import pttk.util.impl.ShipmentServiceMapper;

import java.util.List;

public class ShipmentServiceDAOImpl extends BaseDAOImpl<ShipmentService> implements ShipmentServiceDAO {
    @Override
    public List<ShipmentService> findAll() {
        String sql = "SELECT * FROM ShipmentService";
        List<ShipmentService> shipmentServices = query(sql, new ShipmentServiceMapper());
        return shipmentServices;
    }

    @Override
    public ShipmentService findById(int id) {
        String sql = "SELECT * FROM ShipmentService WHERE id = ?";
        List<ShipmentService> shipmentServices = query(sql, new ShipmentServiceMapper(), id);
        return shipmentServices.isEmpty() ? null : shipmentServices.get(0);
    }
}
