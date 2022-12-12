/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pttk.dao.clothes;

import pttk.dao.BaseDAO;
import pttk.model.clothes.Clothes;

/**
 *
 * @author Admin88
 */
public interface ClothesDAO extends BaseDAO<Clothes>{
    Clothes getClothesByItemClothesId(int itemClothesID);
    Clothes save(Clothes clothes, int itemClothesId);
    Clothes update(Clothes clothes);
    void delete(Integer id);
}
