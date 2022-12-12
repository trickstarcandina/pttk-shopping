/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pttk.dao.clothes.impl;

import java.util.List;
import pttk.dao.BaseDAOImpl;
import pttk.dao.clothes.ClothesDAO;
import pttk.dao.clothes.OriginDAO;
import pttk.dao.clothes.TradeMarkDAO;
import pttk.model.clothes.Clothes;
import pttk.model.clothes.Origin;
import pttk.model.clothes.Trademark;
import pttk.util.impl.ClothesMapper;

/**
 *
 * @author Admin88
 */
public class ClothesDAOImpl extends BaseDAOImpl<Clothes> implements ClothesDAO{
    private OriginDAO originDAO = new OriginDAOImpl();
    private TradeMarkDAO tradeMarkDAO = new TradeMarkDAOImpl();
    @Override
    public Clothes getClothesByItemClothesId(int itemClothesID) {
        String sql = "SELECT * FROM clothes WHERE ItemClothesID = ?";
        List<Clothes> clothesList = query(sql, new ClothesMapper(), itemClothesID);
        Clothes clothes =  clothesList.isEmpty() ? null : clothesList.get(0);
        if (clothes != null) {
            clothes.setOrigin(originDAO.getOriginById(clothes.getOrigin().getId()));
            clothes.setTrademark(tradeMarkDAO.getTradeMarkById(clothes.getTrademark().getId()));
        }
        return clothes;
    }
    @Override
    public Clothes save(Clothes clothes, int itemClothesId) {
        Origin origin = originDAO.save(clothes.getOrigin());
        Trademark tradeMark = tradeMarkDAO.save(clothes.getTrademark());
        String sql = "INSERT INTO clothes(OriginID, TrademarkID, ItemClothesID, Barcode, Name, Type, Price, YearOfManufacture,Size,Color,Description,Material) VALUE(?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
        Long id = insert(sql, origin.getId(),tradeMark.getId(),itemClothesId,clothes.getBarcode(),clothes.getName(),clothes.getType(),clothes.getPrice(),clothes.getYearOfManufacture(),clothes.getSize(),clothes.getColor(),clothes.getDescription(),clothes.getMaterial());
        Clothes newClothes = getClothesByItemClothesId(itemClothesId);
        newClothes.setOrigin(origin);
        newClothes.setTrademark(tradeMark);
        return newClothes;
    }

    @Override
    public Clothes update(Clothes clothes) {
        String sql = "UPDATE clothes SET Barcode = ?, Name = ?, Type = ?, Price = ?, YearOfManufacture = ?,Size = ?,Color = ?,Description = ?,Material = ?  WHERE ID = ?";
        update(sql, clothes.getBarcode(),clothes.getName(),clothes.getType(),clothes.getPrice(),clothes.getYearOfManufacture(),clothes.getSize(),clothes.getColor(),clothes.getDescription(),clothes.getMaterial(),clothes.getId());
        originDAO.update(clothes.getOrigin());
        tradeMarkDAO.update(clothes.getTrademark());
        return clothes;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM clothes WHERE id = ?";
        update(sql, id);
    }
    
}
