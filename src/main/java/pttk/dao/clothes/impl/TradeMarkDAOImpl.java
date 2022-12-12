/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pttk.dao.clothes.impl;

import java.util.List;
import pttk.dao.BaseDAOImpl;
import pttk.dao.clothes.TradeMarkDAO;
import pttk.model.clothes.Trademark;
import pttk.util.impl.TrademarkMapper;

/**
 *
 * @author Admin88
 */
public class TradeMarkDAOImpl extends BaseDAOImpl<Trademark> implements TradeMarkDAO{

    @Override
    public Trademark getTradeMarkById(int tradeMarkId) {
        String sql = "SELECT * FROM trademark WHERE ID = ?";
        List<Trademark> tradeMarkList =  query(sql, new TrademarkMapper(), tradeMarkId);
        return tradeMarkList.isEmpty() ? null : tradeMarkList.get(0);
    }
    @Override
    public Trademark save(Trademark tradeMark) {
        String sql = "INSERT INTO trademark( Name, Address) VALUE( ?, ?)";
        Long id = insert(sql, tradeMark.getName(), tradeMark.getAddress());
        return getTradeMarkById(Math.toIntExact(id));
    }

    @Override
    public Trademark update(Trademark tradeMark) {
        String sql = "UPDATE trademark SET Name = ?, Address = ? WHERE ID = ?";
        update(sql, tradeMark.getName(), tradeMark.getAddress(), tradeMark.getId());
        return tradeMark;
    }
    
}
