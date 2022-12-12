package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.AuthorDAO;
import pttk.model.book.Author;
import pttk.model.book.Publisher;
import pttk.util.impl.AuthorMapper;
import pttk.util.impl.PublisherMapper;

import java.util.List;

public class AuthorDAOImpl extends BaseDAOImpl<Author> implements AuthorDAO {

    @Override
    public Author getAuthorById(int authorId) {
        String sql = "SELECT * FROM Author WHERE ID = ?";
        List<Author> authorList =  query(sql, new AuthorMapper(), authorId);
        return authorList.isEmpty() ? null : authorList.get(0);
    }

    @Override
    public Author save(Author author) {
        String sql = "INSERT INTO Author( Name, Biography, Nation) VALUE( ?, ?, ?)";
        Long id = insert(sql, author.getName(), author.getBiography(), author.getNation());
        return getAuthorById(Math.toIntExact(id));
    }

    @Override
    public Author update(Author author) {
        String sql = "UPDATE Author SET Name = ?, Biography = ?, Nation = ? WHERE ID = ?";
        update(sql, author.getName(), author.getBiography(), author.getNation(), author.getId());
        return author;
    }

}
