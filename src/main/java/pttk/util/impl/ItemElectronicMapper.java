package pttk.util.impl;

import pttk.model.book.ItemBook;
import pttk.model.electronic.ItemElectronic;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ItemElectronicMapper implements RowMapper<ItemElectronic> {

    @Override
    public ItemElectronic mapRow(ResultSet rs) {
        try {
            ItemElectronic itemElectronic = new ItemElectronic();
            itemElectronic.setId(rs.getInt("ID"));
            itemElectronic.setPrice(rs.getFloat("Price"));
            itemElectronic.setImageUrl(rs.getString("imageUrl"));
            return itemElectronic;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
