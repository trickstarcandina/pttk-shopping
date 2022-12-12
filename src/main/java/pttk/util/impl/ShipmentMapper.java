package pttk.util.impl;

import pttk.model.customer.Customer;
import pttk.model.order.Cart;
import pttk.model.order.Order;
import pttk.model.order.Shipment;
import pttk.model.order.ShipmentService;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ShipmentMapper implements RowMapper<Shipment> {
    @Override
    public Shipment mapRow(ResultSet rs) {
        try {
            Shipment shipment = new Shipment();
            shipment.setId(rs.getInt("ID"));
            shipment.setAddressReceive(rs.getString("AddressReceive"));
            ShipmentService shipmentService = new ShipmentService();
            shipmentService.setId(rs.getInt("ShipmentServiceID"));
            shipment.setShipmentService(shipmentService);
            return shipment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
