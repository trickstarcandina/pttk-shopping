package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;

import java.util.List;

public interface LineItemBookDAO extends BaseDAO<LineItemBook> {
    Long create(int cardId, int itemBookId, int quantityB);
    List<LineItemBook> findByCartId(int cartId);
    void updateQuantity(int quantity, int id);
    void deleteLineItemBook(int id);
    LineItemBook findById(int id);
}
