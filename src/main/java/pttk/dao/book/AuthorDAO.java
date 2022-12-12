package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.model.book.Author;

public interface AuthorDAO  extends BaseDAO<Author> {
    Author getAuthorById(int authorId);
    Author save(Author author);
    Author update(Author author);
}
