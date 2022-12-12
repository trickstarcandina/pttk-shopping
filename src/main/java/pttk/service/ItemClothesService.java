package pttk.service;

import pttk.model.clothes.ItemClothes;

import java.util.List;

public interface ItemClothesService {
    ItemClothes findClothesById(int itemClothesId);
    List<ItemClothes> findAllItemClothes();
    List<ItemClothes> findAll(int limit, int offset);
    List<ItemClothes> findByName(String name);
    ItemClothes findById(int id);
    int getTotalItem();

    public ItemClothes update(ItemClothes itemClothes);

    public ItemClothes save(ItemClothes itemClothes);

    public void delete(String[] ids);
}
