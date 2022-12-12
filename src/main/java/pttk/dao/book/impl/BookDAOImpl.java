package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.AuthorDAO;
import pttk.dao.book.BookDAO;
import pttk.dao.book.PublisherDAO;
import pttk.model.book.Author;
import pttk.model.book.Book;
import pttk.model.book.Publisher;
import pttk.util.impl.BookMapper;

import java.util.List;

public class BookDAOImpl extends BaseDAOImpl<Book> implements BookDAO {

    private AuthorDAO authorDAO = new AuthorDAOImpl();
    public PublisherDAO publisherDAO = new PublisherDAOImpl();

    @Override
    public Book getBookByItemBookId(int itemBookID) {
        String sql = "SELECT * FROM Book WHERE ItemBookId = ?";
        List<Book> bookList = query(sql, new BookMapper(), itemBookID);
        Book book =  bookList.isEmpty() ? null : bookList.get(0);
        if (book != null) {
            book.setAuthor(authorDAO.getAuthorById(book.getAuthor().getId()));
            book.setPublisher(publisherDAO.getPublisherById(book.getPublisher().getId()));
        }
        return book;
    }

    @Override
    public Book save(Book book, Integer itemBookId) {
        Author author = authorDAO.save(book.getAuthor());
        Publisher publisher = publisherDAO.save(book.getPublisher());
        String sql = "INSERT INTO Book(AuthorID, PublisherID, ItemBookID, Title, Type, Quantity, Size, Description) VALUE(?, ?, ?, ?, ?, ?, ?, ?)";
        Long id = insert(sql, author.getId(), publisher.getId(), itemBookId, book.getTitle(), book.getType(), book.getQuantity(), book.getSize(), book.getDescription());
        Book newBook = getBookByItemBookId(itemBookId);
        newBook.setAuthor(author);
        newBook.setPublisher(publisher);
        return newBook;
    }

    @Override
    public Book update(Book book) {
        String sql = "UPDATE Book SET Title = ?, Type = ?, Quantity = ?, Size = ?, Description = ? WHERE ID = ?";
        update(sql, book.getTitle(), book.getType(), book.getQuantity(), book.getSize(), book.getDescription());
        authorDAO.update(book.getAuthor());
        publisherDAO.update(book.getPublisher());
        return book;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Book WHERE id = ?";
        update(sql, id);
    }

}
