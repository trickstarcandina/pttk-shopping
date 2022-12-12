package pttk.dao.shoes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.shoes.ShoesDAO;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;
import pttk.model.shoes.ShoesForWomen;
import pttk.util.impl.ShoesMapper;

import java.util.List;

public class ShoesDAOImpl extends BaseDAOImpl<Shoes> implements ShoesDAO {

    private final ShoesForManImpl shoesForManImpl = new ShoesForManImpl();
    private final ShoesForWomenImpl shoesForWomenImpl = new ShoesForWomenImpl();

    @Override
    public Shoes getShoesByItemShoesId(int itemShoesId) {
        String sql = "SELECT * FROM Shoes WHERE Shoes.ItemShoesID = ?";
        List<Shoes> listShoes = query(sql, new ShoesMapper(), itemShoesId);
        Shoes shoes = listShoes.isEmpty() ? null : listShoes.get(0);
        if(shoes == null) return null;
        ShoesForMan shoesForMan = shoesForManImpl.getShoesForManByShoesID(shoes);
        ShoesForWomen shoesForWomen = shoesForWomenImpl.getShoesForWomenByShoesID(shoes);
        if (shoesForMan != null){
            shoesForMan.setName(shoes.getName());
            shoesForMan.setBrand(shoes.getBrand());
            shoesForMan.setPrice(shoes.getPrice());
            shoesForMan.setDescription(shoes.getDescription());
            shoesForMan.setOrigin(shoes.getOrigin());
            shoesForMan.setColor(shoes.getColor());
            shoesForMan.setType(shoes.getType());
            return  shoesForMan;
        }
        if (shoesForWomen != null){
            shoesForWomen.setName(shoes.getName());
            shoesForWomen.setBrand(shoes.getBrand());
            shoesForWomen.setPrice(shoes.getPrice());
            shoesForWomen.setDescription(shoes.getDescription());
            shoesForWomen.setOrigin(shoes.getOrigin());
            shoesForWomen.setColor(shoes.getColor());
            shoesForWomen.setType(shoes.getType());
            return shoesForWomen;
        }
        return null;
    }

    @Override
    public Shoes getShoesForManByItemShoesId(int itemShoesId) {
        String sql = "SELECT * FROM Shoes WHERE Shoes.ItemShoesID = ?";
        List<Shoes> listShoes = query(sql, new ShoesMapper(), itemShoesId);
        Shoes shoes = listShoes.isEmpty() ? null : listShoes.get(0);
        if(shoes == null) return null;
        ShoesForMan shoesForMan = shoesForManImpl.getShoesForManByShoesID(shoes);
        if (shoesForMan != null) {
            shoesForMan.setName(shoes.getName());
            shoesForMan.setBrand(shoes.getBrand());
            shoesForMan.setPrice(shoes.getPrice());
            shoesForMan.setDescription(shoes.getDescription());
            shoesForMan.setOrigin(shoes.getOrigin());
            shoesForMan.setColor(shoes.getColor());
            shoesForMan.setType(shoes.getType());
            return  shoesForMan;
        }
        return  null;
    }

    @Override
    public Shoes getShoesForWomenByItemShoesId(int itemShoesId) {
        String sql = "SELECT * FROM Shoes WHERE Shoes.ItemShoesID = ?";
        List<Shoes> listShoes = query(sql, new ShoesMapper(), itemShoesId);
        Shoes shoes = listShoes.isEmpty() ? null : listShoes.get(0);
        if(shoes == null) return null;
        ShoesForWomen shoesForWomen = shoesForWomenImpl.getShoesForWomenByShoesID(shoes);
        if(shoesForWomen!=null){
            shoesForWomen.setName(shoes.getName());
            shoesForWomen.setBrand(shoes.getBrand());
            shoesForWomen.setPrice(shoes.getPrice());
            shoesForWomen.setDescription(shoes.getDescription());
            shoesForWomen.setOrigin(shoes.getOrigin());
            shoesForWomen.setColor(shoes.getColor());
            shoesForWomen.setType(shoes.getType());
            return shoesForWomen;
        }
        return  null;
    }
}
