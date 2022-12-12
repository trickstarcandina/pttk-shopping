package pttk.dao.order.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.order.ShipmentDAO;
import pttk.dao.order.ShipmentServiceDAO;
import pttk.model.customer.Customer;
import pttk.model.order.Shipment;
import pttk.util.impl.CustomerMapper;
import pttk.util.impl.ShipmentMapper;

import java.util.List;

public class ShipmentDAOImpl extends BaseDAOImpl<Shipment> implements ShipmentDAO {

    private final ShipmentServiceDAO shipmentServiceDAO = new ShipmentServiceDAOImpl();

    @Override
    public Shipment findByOrderId(int orderId) {
        String sql = "SELECT * FROM Shipment WHERE OrderID = ?";
        List<Shipment> shipmentList = query(sql, new ShipmentMapper(), orderId);
        Shipment shipment = shipmentList.isEmpty() ? null : shipmentList.get(0);
        if(shipment != null) {
            shipment.setShipmentService(shipmentServiceDAO.findById(shipment.getShipmentService().getId()));
        }
        return shipment;
    }

    @Override
    public void save(Shipment shipment, int orderId) {
        String sql = "INSERT INTO Shipment(ShipmentServiceID, OrderId, AddressReceive) VALUES(?, ?, ?)";
        insert(sql, shipment.getShipmentService().getId(), orderId, shipment.getAddressReceive());
    }
}
