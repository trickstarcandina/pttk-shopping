package pttk.dao.shoes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.shoes.ShoesForWomenDAO;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;
import pttk.model.shoes.ShoesForWomen;
import pttk.util.impl.ShoesForWomenMapper;

import java.util.List;

public class ShoesForWomenImpl extends BaseDAOImpl<ShoesForWomen> implements ShoesForWomenDAO {

    @Override
    public ShoesForWomen getShoesForWomenByShoesID(Shoes shoes) {
        String sql = "select * From ShoesForWomen where ShoesID = ?";
        List<ShoesForWomen> list = query(sql, new ShoesForWomenMapper(), shoes.getId());
        if(list.isEmpty()) return null;
        else{
            ShoesForWomen shoesForWomen = list.get(0);
            shoesForWomen.setOrigin(shoes.getOrigin());
            shoesForWomen.setBrand(shoes.getBrand());
            shoesForWomen.setColor(shoes.getColor());
            shoesForWomen.setDescription(shoes.getDescription());
            shoesForWomen.setType(shoes.getType());
            shoesForWomen.setPrice(shoes.getPrice());
            shoesForWomen.setName(shoes.getName());
            return shoesForWomen;
        }
    }
}
