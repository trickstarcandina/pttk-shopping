package pttk.util.impl;

import pttk.model.shoes.ItemShoes;
import pttk.model.shoes.LineItemShoes;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItemShoesMapper implements RowMapper<LineItemShoes> {

    @Override
    public LineItemShoes mapRow(ResultSet rs) {
        try{
            LineItemShoes lineItemShoes = new LineItemShoes();
            ItemShoes itemShoes = new ItemShoes();
            lineItemShoes.setQuantity(rs.getInt("Quantity"));
            itemShoes.setId(rs.getInt("ItemShoesID"));
            lineItemShoes.setItemShoes(itemShoes);
            return lineItemShoes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
