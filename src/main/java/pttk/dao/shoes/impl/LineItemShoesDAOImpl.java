package pttk.dao.shoes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.shoes.LineItemShoesDAO;
import pttk.model.shoes.LineItemShoes;

public class LineItemShoesDAOImpl extends BaseDAOImpl<LineItemShoes> implements LineItemShoesDAO {
    @Override
    public Long create(int cardId, int itemShoesId, int quantity) {
        String sql = "INSERT INTO LineItemBook (cardID, itemBookId, quantityB) VALUES (?, ?, ?)";
        Long ans = insert(sql, cardId, itemShoesId, quantity);
        return ans;
    }
}
