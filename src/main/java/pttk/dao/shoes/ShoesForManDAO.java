package pttk.dao.shoes;

import pttk.dao.BaseDAO;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;

public interface ShoesForManDAO extends BaseDAO<ShoesForMan> {
    ShoesForMan getShoesForManByShoesID(Shoes shoes);

}
