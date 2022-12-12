package pttk.service.impl;

import pttk.dao.shoes.ItemShoesDAO;
import pttk.dao.shoes.ShoesDAO;
import pttk.dao.shoes.impl.ItemShoesDAOImpl;
import pttk.dao.shoes.impl.ShoesDAOImpl;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.shoes.ItemShoes;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;
import pttk.model.shoes.ShoesForWomen;
import pttk.service.ItemShoesService;

import java.util.List;

public class ItemShoesServiceImpl implements ItemShoesService {

    private final ItemShoesDAO itemShoesDAO = new ItemShoesDAOImpl();
    private final ShoesDAO shoesDAO = new ShoesDAOImpl();

    @Override
    public ItemShoes findShoesById(int itemShoesId) {
        return itemShoesDAO.findById(itemShoesId);
    }

    @Override
    public List<ItemShoes> findAllItemShoes() {
        return itemShoesDAO.findAll();
    }

    @Override
    public List<ItemShoes> findAll(int limit, int offset) {
        return itemShoesDAO.findAll(limit, offset);
    }

    @Override
    public List<ItemShoes> findByName(String name) {
        return itemShoesDAO.findByName(name);
    }

    @Override
    public List<ItemShoes> getAllShoesForMan() {
        return itemShoesDAO.getAllShoesForMan();
    }

    @Override
    public List<ItemShoes> getAllShoesForWomen() {
        return itemShoesDAO.getAllShoesForWomen();
    }

    @Override
    public ShoesForMan findShoesForMan(int itemShoesId) {
        Shoes shoes = shoesDAO.getShoesByItemShoesId(itemShoesId);
        if(shoes instanceof ShoesForMan) {
            ShoesForMan shoesForMan = (ShoesForMan) shoes;
            return shoesForMan;
        }
        return null;
    }

    @Override
    public ShoesForWomen findShoesForWomen(int itemShoesId) {
        Shoes shoes = shoesDAO.getShoesByItemShoesId(itemShoesId);
        if(shoes instanceof ShoesForWomen) {
            ShoesForWomen shoesForWomen = (ShoesForWomen) shoes;
            return shoesForWomen;
        }
        return null;
    }

    @Override
    public int getTotalItem() {
        return itemShoesDAO.getTotalItem();
    }
}
