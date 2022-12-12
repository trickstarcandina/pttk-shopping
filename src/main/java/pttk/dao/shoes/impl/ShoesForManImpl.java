package pttk.dao.shoes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.shoes.ShoesForManDAO;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;
import pttk.util.impl.ShoesForManMapper;

import java.util.List;

public class ShoesForManImpl extends BaseDAOImpl<ShoesForMan> implements ShoesForManDAO {
    @Override
    public ShoesForMan getShoesForManByShoesID(Shoes shoes) {
        String sql = "select * From ShoesForMan where ShoesID = ?";
        List<ShoesForMan> list = query(sql, new ShoesForManMapper(), shoes.getId());
        if(list.isEmpty()) return null;
        else{
            ShoesForMan shoesForMan = list.get(0);
            shoesForMan.setOrigin(shoes.getOrigin());
            shoesForMan.setBrand(shoes.getBrand());
            shoesForMan.setColor(shoes.getColor());
            shoesForMan.setDescription(shoes.getDescription());
            shoesForMan.setType(shoes.getType());
            shoesForMan.setPrice(shoes.getPrice());
            shoesForMan.setName(shoes.getName());
            return shoesForMan;
        }
    }
}
