package pttk.util.impl;

import pttk.model.order.Cash;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class CashMapper implements RowMapper<Cash> {
    @Override
    public Cash mapRow(ResultSet rs) {
        try {
            Cash cash = new Cash();
            cash.setId(rs.getInt("ID"));
            cash.setCashTendered(rs.getString("CashTendered"));
            return cash;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
