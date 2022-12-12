package pttk.util.impl;

import pttk.model.shoes.ShoesForWomen;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoesForWomenMapper implements RowMapper<ShoesForWomen> {

    @Override
    public ShoesForWomen mapRow(ResultSet rs) {
        try{
            ShoesForWomen shoesForWomen = new ShoesForWomen();
            shoesForWomen.setId(rs.getInt("ID"));
            shoesForWomen.setSize(rs.getString("Size"));
            shoesForWomen.setSoleHeight(rs.getInt("SoleHeight"));
            return shoesForWomen;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
