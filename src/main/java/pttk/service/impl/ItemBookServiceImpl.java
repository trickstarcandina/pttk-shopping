package pttk.service.impl;

import pttk.dao.book.AuthorDAO;
import pttk.dao.book.BookDAO;
import pttk.dao.book.PublisherDAO;
import pttk.dao.book.impl.AuthorDAOImpl;
import pttk.dao.book.impl.BookDAOImpl;
import pttk.dao.book.impl.PublisherDAOImpl;
import pttk.model.book.ItemBook;
import pttk.dao.book.ItemBookDAO;
import pttk.dao.book.impl.ItemBookDAOImpl;
import pttk.model.book.Publisher;
import pttk.service.ItemBookService;

import java.util.List;

public class ItemBookServiceImpl implements ItemBookService {

    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();

    @Override
    public ItemBook findById(int itemBookId) {
        return itemBookDAO.findById(itemBookId);
    }

    @Override
    public List<ItemBook> findAll() {
        return itemBookDAO.findAll();
    }

    @Override
    public List<ItemBook> findAll(int limit, int offset) {
        return itemBookDAO.findAll(limit, offset);
    }

    @Override
    public List<ItemBook> findByName(String name) {
        return itemBookDAO.findByName(name);
    }

    @Override
    public int getTotalItem() {
        return itemBookDAO.getTotalItem();
    }

    @Override
    public ItemBook save(ItemBook itemBook) {
        return itemBookDAO.save(itemBook);
    }

    @Override
    public ItemBook update(ItemBook itemBook) {
        return itemBookDAO.update(itemBook);
    }

    @Override
    public void delete(String[] ids) {
        for (String id: ids) {
            itemBookDAO.delete(Integer.parseInt(id));
        }
    }
}
