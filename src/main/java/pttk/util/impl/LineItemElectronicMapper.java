package pttk.util.impl;

import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.LineItemElectronic;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItemElectronicMapper implements RowMapper<LineItemElectronic> {
    @Override
    public LineItemElectronic mapRow(ResultSet rs) {
        try{
            LineItemElectronic lineItemElectronic = new LineItemElectronic();
            ItemElectronic itemElectronic = new ItemElectronic();
            lineItemElectronic.setQuantity(rs.getInt("Quantity"));
            itemElectronic.setId(rs.getInt("ItemElectronicID"));
            lineItemElectronic.setItemElectronic(itemElectronic);
            return lineItemElectronic;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
