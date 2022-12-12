/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pttk.dao.clothes.impl;

import java.util.List;
import pttk.dao.BaseDAOImpl;
import pttk.dao.clothes.OriginDAO;
import pttk.model.clothes.Origin;
import pttk.util.impl.OriginMapper;

/**
 *
 * @author Admin88
 */
public class OriginDAOImpl extends BaseDAOImpl<Origin> implements OriginDAO{

    @Override
    public Origin getOriginById(int originId) {
         String sql = "SELECT * FROM origin WHERE ID = ?";
        List<Origin> originList =  query(sql, new OriginMapper(), originId);
        return originList.isEmpty() ? null : originList.get(0);
    }

    @Override
    public Origin save(Origin origin) {
        String sql = "INSERT INTO origin( Nation, Address) VALUE( ?, ?)";
        Long id = insert(sql, origin.getNation(), origin.getAddress());
        return getOriginById(Math.toIntExact(id));
    }

    @Override
    public Origin update(Origin origin) {
        String sql = "UPDATE origin SET Nation = ?, Address = ? WHERE ID = ?";
        update(sql, origin.getNation(), origin.getAddress(), origin.getId());
        return origin;
    }
    
}
