package pttk.util.impl;

import pttk.model.book.Author;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs) {
        try {
            Author author = new Author();
            author.setId(rs.getInt("ID"));
            author.setName(rs.getString("Name"));
            author.setBiography(rs.getString("Biography"));
            author.setNation(rs.getString("Nation"));
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
