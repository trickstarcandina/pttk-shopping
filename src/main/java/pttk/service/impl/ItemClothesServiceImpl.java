package pttk.service.impl;

import pttk.dao.clothes.ItemClothesDAO;
import pttk.dao.clothes.impl.ItemClothesDAOImpl;
import pttk.model.clothes.ItemClothes;
import pttk.service.ItemClothesService;

import java.util.List;

public class ItemClothesServiceImpl implements ItemClothesService {

    private final ItemClothesDAO itemClothesDAO = new ItemClothesDAOImpl();

    @Override
    public ItemClothes findClothesById(int itemClothesId) {
        return itemClothesDAO.findById(itemClothesId);
    }

    @Override
    public List<ItemClothes> findAllItemClothes() {
        return itemClothesDAO.findAll();
    }

    @Override
    public List<ItemClothes> findAll(int limit, int offset) {
        return itemClothesDAO.findAll(limit, offset);
    }

    @Override
    public List<ItemClothes> findByName(String name) {
        return null;
    }

    @Override
    public ItemClothes findById(int id) {
        return itemClothesDAO.findById(id);
    }

    @Override
    public int getTotalItem() {
        return itemClothesDAO.getTotalItem();
    }

    @Override
    public ItemClothes update(ItemClothes itemClothes) {
         return itemClothesDAO.update(itemClothes);
    }

    @Override
    public ItemClothes save(ItemClothes itemClothes) {
        return itemClothesDAO.save(itemClothes);
    }

    @Override
    public void delete(String[] ids) {
        for(String id : ids){
            itemClothesDAO.delete(Integer.parseInt(id));
        }
    }
}
