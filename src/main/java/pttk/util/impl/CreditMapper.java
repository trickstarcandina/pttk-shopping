package pttk.util.impl;

import pttk.model.order.Cash;
import pttk.model.order.Credit;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class CreditMapper implements RowMapper<Credit> {
    @Override
    public Credit mapRow(ResultSet rs) {
        try {
            Credit credit = new Credit();
            credit.setId(rs.getInt("ID"));
            credit.setCreditId(rs.getString("CreditID"));
            credit.setName(rs.getString("Name"));
            return credit;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
