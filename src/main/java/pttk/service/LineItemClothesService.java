package pttk.service;

import pttk.model.book.LineItemBook;
import pttk.model.clothes.LineItemClothes;

import java.util.List;

public interface LineItemClothesService {
    Long create(int cartId, int itemBookId, int quantityB);
    List<LineItemClothes> findByCartId(int cartId);
    void updateQuantity(int quantity, int id);
    void deleteLineItemClothes(int id);
    LineItemClothes findById(int id);
}
