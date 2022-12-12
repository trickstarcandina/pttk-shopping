package pttk.util.impl;

import pttk.model.book.ItemBook;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.Mobile;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ElectronicMapper implements RowMapper<Electronic> {
    @Override
    public Electronic mapRow(ResultSet rs) {
        try {
            Electronic electronic = new Electronic();
            electronic.setId(rs.getInt("ID"));
            electronic.setName(rs.getString("name"));
            electronic.setBrand(rs.getString("Brand"));
            electronic.setDiscount(rs.getFloat("Discount"));
            electronic.setOrigin(rs.getString("Origin"));
            electronic.setPrice(rs.getFloat("Price"));
            electronic.setDescription(rs.getString("Description"));
            return electronic;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
