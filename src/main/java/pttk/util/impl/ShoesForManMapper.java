package pttk.util.impl;

import pttk.model.shoes.ShoesForMan;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoesForManMapper implements RowMapper<ShoesForMan> {

    @Override
    public ShoesForMan mapRow(ResultSet rs) {
        try {
            ShoesForMan shoesForMan = new ShoesForMan();
            shoesForMan.setId(rs.getInt("ID"));
            shoesForMan.setSize(rs.getString("Size"));
            return shoesForMan;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
