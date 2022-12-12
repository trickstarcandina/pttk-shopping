package pttk.util.impl;

import pttk.model.clothes.Origin;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class OriginMapper implements RowMapper<Origin> {
    @Override
    public Origin mapRow(ResultSet rs) {
        try {
            Origin origin = new Origin();
            origin.setId(rs.getInt("ID"));
            origin.setAddress(rs.getString("Address"));
            origin.setNation(rs.getString("Nation"));
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
