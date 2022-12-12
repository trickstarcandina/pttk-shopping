package pttk.util.impl;

import pttk.model.customer.FullName;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class FullNameMapper implements RowMapper<FullName> {
    @Override
    public FullName mapRow(ResultSet rs) {
        try {
            FullName fullName = new FullName();
            fullName.setId(rs.getInt("ID"));
            fullName.setFirstName(rs.getString("FirstName"));
            fullName.setMiddleName(rs.getString("MiddleName"));
            fullName.setLastName(rs.getString("LastName"));
            return fullName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
