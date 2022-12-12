package pttk.util.impl;

import pttk.model.clothes.ItemClothes;
import pttk.model.clothes.LineItemClothes;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItemClothesMapper implements RowMapper<LineItemClothes> {
    @Override
    public LineItemClothes mapRow(ResultSet rs) {
        try{
            LineItemClothes lineItemClothes = new LineItemClothes();
            ItemClothes itemClothes = new ItemClothes();
            lineItemClothes.setQuantity(rs.getInt("QuantityC"));
            itemClothes.setId(rs.getInt("ItemClothesID"));
            lineItemClothes.setItemClothes(itemClothes);
            lineItemClothes.setId(rs.getInt("id"));
            return lineItemClothes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
