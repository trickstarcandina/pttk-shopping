package pttk.dao.clothes;

import pttk.dao.BaseDAO;
import pttk.model.clothes.ItemClothes;

import java.util.List;

public interface ItemClothesDAO extends BaseDAO<ItemClothes> {
    List<ItemClothes> findAll();
    List<ItemClothes> findAll(int limit, int offset);
    public int getTotalItem();
    ItemClothes findById(int id);
    List<ItemClothes> findByName(String name);

    public ItemClothes update(ItemClothes itemClothes);

    public ItemClothes save(ItemClothes itemClothes);

    public void delete(int parseInt);
}
