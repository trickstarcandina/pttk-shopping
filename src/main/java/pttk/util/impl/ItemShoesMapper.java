package pttk.util.impl;

import pttk.model.shoes.ItemShoes;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemShoesMapper implements RowMapper<ItemShoes> {
    @Override
    public ItemShoes mapRow(ResultSet rs) {
        try{
            ItemShoes itemShoes = new ItemShoes();
            itemShoes.setId(rs.getInt("ID"));
            itemShoes.setPrice(rs.getFloat("Price"));
            itemShoes.setImageUrl(rs.getString("imageUrl"));
            return itemShoes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
