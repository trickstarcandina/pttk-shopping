package pttk.util.impl;

import pttk.model.book.Author;
import pttk.model.book.Book;
import pttk.model.book.Publisher;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs) {
        try {
            Book book = new Book();
            book.setId(rs.getInt("ID"));
            book.setTitle(rs.getString("Title"));
            book.setType(rs.getString("Type"));
            book.setQuantity(rs.getInt("Quantity"));
            book.setSize(rs.getString("Size"));
            book.setDescription(rs.getString("Description"));
            Author author = new Author();
            author.setId(rs.getInt("AuthorID"));
            book.setAuthor(author);
            Publisher publisher = new Publisher();
            publisher.setId(rs.getInt("PublisherID"));
            book.setPublisher(publisher);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
