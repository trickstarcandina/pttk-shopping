package pttk.util.impl;

import pttk.model.clothes.Origin;
import pttk.model.electronic.Mobile;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class MobileMapper implements RowMapper<Mobile> {
    @Override
    public Mobile mapRow(ResultSet rs) {
        try {
            Mobile mobile = new Mobile();
            mobile.setId(rs.getInt("ID"));
            mobile.setAccessory(rs.getString("Accessory"));
            mobile.setCamera(rs.getString("Camera"));
            mobile.setChip(rs.getString("Chip"));
            mobile.setPower(rs.getString("Power"));
            mobile.setRam(rs.getString("Ram"));
            mobile.setResolution(rs.getString("Resolution"));
            mobile.setRom(rs.getString("Rom"));
            return mobile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
