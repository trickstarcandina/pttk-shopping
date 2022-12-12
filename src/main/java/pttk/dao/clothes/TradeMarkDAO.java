/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pttk.dao.clothes;

import pttk.dao.BaseDAO;
import pttk.model.clothes.Trademark;

/**
 *
 * @author Admin88
 */
public interface TradeMarkDAO extends BaseDAO<Trademark> {
    Trademark getTradeMarkById(int tradeMarkId);
    Trademark save(Trademark tradeMark);
    Trademark update(Trademark tradeMark);
}
