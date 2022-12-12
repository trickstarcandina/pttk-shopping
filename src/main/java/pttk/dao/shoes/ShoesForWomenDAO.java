package pttk.dao.shoes;

import pttk.dao.BaseDAO;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;
import pttk.model.shoes.ShoesForWomen;

public interface ShoesForWomenDAO extends BaseDAO<ShoesForWomen> {
    ShoesForWomen getShoesForWomenByShoesID(Shoes shoes);
}
