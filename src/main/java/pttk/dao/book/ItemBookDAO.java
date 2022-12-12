package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.model.book.ItemBook;

import java.util.List;

public interface ItemBookDAO extends BaseDAO<ItemBook> {
    List<ItemBook> findAll();
    List<ItemBook> findAll(int limit, int offset);
    public int getTotalItem();
    ItemBook findById(int id);
    List<ItemBook> findByName(String name);
    ItemBook save(ItemBook itemBook);
    ItemBook update(ItemBook itemBook);
    void delete(Integer id);
}
