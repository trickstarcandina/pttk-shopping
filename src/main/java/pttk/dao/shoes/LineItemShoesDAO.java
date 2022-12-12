package pttk.dao.shoes;

import pttk.dao.BaseDAO;
import pttk.model.shoes.LineItemShoes;

public interface LineItemShoesDAO extends BaseDAO<LineItemShoes> {
    Long create(int cardId, int itemClothesId, int quantity);

}
