package pttk.util.impl;

import pttk.model.book.Publisher;
import pttk.model.order.ShipmentService;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ShipmentServiceMapper implements RowMapper<ShipmentService> {

    @Override
    public ShipmentService mapRow(ResultSet rs) {
        try {
            ShipmentService shipmentService = new ShipmentService();
            shipmentService.setId(rs.getInt("ID"));
            shipmentService.setShipUnit(rs.getString("ShipUnit"));
            shipmentService.setShipPrice(rs.getFloat("ShipPrice"));
            return shipmentService;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
