package pttk.util.impl;

import pttk.model.clothes.Trademark;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class TrademarkMapper implements RowMapper<Trademark> {
    @Override
    public Trademark mapRow(ResultSet rs) {
        try {
            Trademark trademark = new Trademark();
            trademark.setId(rs.getInt("ID"));
            trademark.setName(rs.getString("Name"));
            trademark.setAddress(rs.getString("Address"));
            return trademark;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
