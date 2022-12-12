package pttk.dao.electronic.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.electronic.MobileDAO;
import pttk.dao.shoes.ShoesForWomenDAO;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.Mobile;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForWomen;
import pttk.util.impl.MobileMapper;
import pttk.util.impl.ShoesForWomenMapper;

import java.util.List;

public class MobileDAOImpl extends BaseDAOImpl<Mobile> implements MobileDAO {

    @Override
    public Mobile findMobileByElectronicId(Electronic electronic) {
        String sql = "select * From Mobile where ElectronicID = ?";
        List<Mobile> listMobile = query(sql, new MobileMapper(), electronic.getId());
        if (listMobile.isEmpty()) return null;
        else {
            Mobile mobile = listMobile.get(0);
            mobile.setOrigin(electronic.getOrigin());
            mobile.setBrand(electronic.getBrand());
            mobile.setPrice(electronic.getPrice());
            mobile.setDescription(electronic.getDescription());
            mobile.setPrice(electronic.getPrice());
            return mobile;
        }
    }

    @Override
    public Mobile updateMobile(Mobile mobile) {
        String sql = "UPDATE Mobile SET Chip = ?, Camera = ?, Accessory = ?, Ram = ?, Power = ?, Rom = ?, Resolution = ? WHERE Id = ?";
        update(sql, mobile.getChip(), mobile.getCamera(), mobile.getAccessory(), mobile.getRam(), mobile.getPower(), mobile.getRom(), mobile.getResolution(), mobile.getId());
        return mobile;
    }

    @Override
    public void deleteMobile(int electronicId) {
        String sql = "DELETE FROM Mobile WHERE ElectronicId = ?";
        update(sql, electronicId);
    }
}
