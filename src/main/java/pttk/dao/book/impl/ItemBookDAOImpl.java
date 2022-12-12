package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.AuthorDAO;
import pttk.dao.book.BookDAO;
import pttk.dao.book.ItemBookDAO;
import pttk.dao.book.PublisherDAO;
import pttk.model.book.Book;
import pttk.model.book.ItemBook;
import pttk.util.impl.ItemBookMapper;

import java.util.List;

public class ItemBookDAOImpl extends BaseDAOImpl<ItemBook> implements ItemBookDAO {

    private final BookDAO bookDAO = new BookDAOImpl();

    @Override
    public List<ItemBook> findAll() {
        String sql = "SELECT * FROM ItemBook";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper());
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public List<ItemBook> findAll(int limit, int offset) {
        String sql = "SELECT * FROM ItemBook LIMIT ?, ?";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper(), offset, limit);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM ItemBook";
        return count(sql);
    }

    @Override
    public ItemBook findById(int id) {
        String sql = "SELECT * FROM ItemBook WHERE id = ?";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper(), id);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList.isEmpty() ? null : itemBookList.get(0);
    }

    @Override
    public List<ItemBook> findByName(String name) {
        name = "%" + name + "%";
        String sql = "SELECT * FROM ItemBook, Book WHERE " +
                "Book.ItemBookID = ItemBookID " +
                "AND Book.Title like ?";

        List<ItemBook> itemBookList = query(sql, new ItemBookMapper(), name);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public ItemBook save(ItemBook itemBook) {
        String sql = "INSERT INTO Itembook( Price, ImageUrl) VALUE( ?, ?)";
        Long id = insert(sql, itemBook.getPrice(), itemBook.getImageUrl());
        ItemBook newItemBook = findById(Math.toIntExact(id));
        newItemBook.setBook(bookDAO.save(itemBook.getBook(), newItemBook.getId()));
        return newItemBook;
    }

    @Override
    public ItemBook update(ItemBook itemBook) {
        String sql = "UPDATE ItemBook SET  Price = ?, ImageUrl = ? WHERE ID = ?";
        update(sql, itemBook.getPrice(), itemBook.getImageUrl(), itemBook.getId());
        ItemBook newItemBook = findById(itemBook.getId());
        Book book = bookDAO.getBookByItemBookId(itemBook.getId());
        Integer bookId = book.getId();
        book = itemBook.getBook();
        book.setId(bookId);
        newItemBook.setBook(bookDAO.update(book));
        return newItemBook;
    }

    @Override
    public void delete(Integer id) {
        Book book = bookDAO.getBookByItemBookId(id);
        bookDAO.delete(book.getId());
        String sql = "DELETE FROM ItemBook WHERE id = ?";
        update(sql, id);
    }

}
