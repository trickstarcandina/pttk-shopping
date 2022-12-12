package pttk.util.impl;

import pttk.model.clothes.ItemClothes;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ItemClothesMapper implements RowMapper<ItemClothes> {

    @Override
    public ItemClothes mapRow(ResultSet rs) {
        try {
            ItemClothes itemClothes = new ItemClothes();
            itemClothes.setId(rs.getInt("ID"));
            itemClothes.setPrice(rs.getFloat("Price"));
            itemClothes.setImageUrl(rs.getString("imageUrl"));
            return itemClothes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
