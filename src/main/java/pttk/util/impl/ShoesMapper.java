package pttk.util.impl;

import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoesMapper implements RowMapper<Shoes> {

    @Override
    public Shoes mapRow(ResultSet rs) {
        try{
            Shoes shoes = new Shoes();
            shoes.setId(rs.getInt("ID"));
            shoes.setOrigin(rs.getString("Origin"));
            shoes.setBrand(rs.getString("Brand"));
            shoes.setColor(rs.getString("Color"));
            shoes.setDescription(rs.getString("Description"));
            shoes.setType(rs.getString("Type"));
            shoes.setPrice(rs.getFloat("Price"));
            shoes.setName(rs.getString("Name"));
            return shoes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
