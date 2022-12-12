package pttk.util.impl;

import pttk.model.book.Publisher;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class PublisherMapper implements RowMapper<Publisher> {
    @Override
    public Publisher mapRow(ResultSet rs) {
        try {
            Publisher publisher = new Publisher();
            publisher.setId(rs.getInt("ID"));
            publisher.setName(rs.getString("Name"));
            publisher.setAddress(rs.getString("Address"));
            return publisher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
