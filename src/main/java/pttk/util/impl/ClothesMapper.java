package pttk.util.impl;

import pttk.model.clothes.Clothes;
import pttk.model.clothes.Origin;
import pttk.model.clothes.Trademark;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ClothesMapper implements RowMapper<Clothes> {

    @Override
    public Clothes mapRow(ResultSet rs) {
        try {
            Clothes clothes = new Clothes();
            clothes.setId(rs.getInt("ID"));
            clothes.setName(rs.getString("Name"));
            clothes.setBarcode(rs.getString("Barcode"));
            clothes.setType(rs.getString("Type"));
            clothes.setPrice(rs.getFloat("Price"));
            clothes.setYearOfManufacture(rs.getInt("YearOfManufacture"));
            clothes.setSize(rs.getString("Size"));
            clothes.setColor(rs.getString("Color"));
            clothes.setMaterial(rs.getString("Material"));
            clothes.setDescription(rs.getString("Description"));
            Trademark trademark = new Trademark();
            trademark.setId(rs.getInt("TrademarkID"));
            clothes.setTrademark(trademark);
            Origin origin = new Origin();
            origin.setId(rs.getInt("OriginID"));
            clothes.setOrigin(origin);
            return clothes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
