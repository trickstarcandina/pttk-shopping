package pttk.dao.shoes;

import pttk.dao.BaseDAO;
import pttk.model.shoes.Shoes;



public interface ShoesDAO extends BaseDAO<Shoes> {
    Shoes getShoesByItemShoesId(int itemShoesId);
    Shoes getShoesForManByItemShoesId(int itemShoesId);
    Shoes getShoesForWomenByItemShoesId(int itemShoesId);
}
