package pttk.service;

import pttk.model.book.ItemBook;

import java.util.List;

public interface ItemBookService {
    ItemBook findById(int itemBookId);
    List<ItemBook> findAll();
    List<ItemBook> findAll(int limit, int offset);
    List<ItemBook> findByName(String name);
    int getTotalItem();
    ItemBook save(ItemBook itemBook);
    ItemBook update(ItemBook itemBook);
    void delete(String[] ids);
}
