package pttk.util.impl;

import pttk.model.book.ItemBook;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ItemBookMapper implements RowMapper<ItemBook> {

    @Override
    public ItemBook mapRow(ResultSet rs) {
        try {
            ItemBook itemBook = new ItemBook();
            itemBook.setId(rs.getInt("ID"));
            itemBook.setPrice(rs.getFloat("Price"));
            itemBook.setImageUrl(rs.getString("imageUrl"));
            return itemBook;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
