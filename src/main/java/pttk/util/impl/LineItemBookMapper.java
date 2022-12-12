package pttk.util.impl;

import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItemBookMapper implements RowMapper<LineItemBook> {

    @Override
    public LineItemBook mapRow(ResultSet rs) {
        try{
            LineItemBook lineItemBook = new LineItemBook();
            ItemBook itemBook = new ItemBook();
            lineItemBook.setQuantity(rs.getInt("QuantityB"));
            itemBook.setId(rs.getInt("ItemBookID"));
            lineItemBook.setItemBook(itemBook);
            lineItemBook.setId(rs.getInt("id"));
            return lineItemBook;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
