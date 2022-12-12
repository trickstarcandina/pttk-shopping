package pttk.util.impl;

import pttk.model.electronic.Computer;
import pttk.model.electronic.Mobile;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ComputerMapper implements RowMapper<Computer> {
    @Override
    public Computer mapRow(ResultSet rs) {
        try {
            Computer computer = new Computer();
            computer.setId(rs.getInt("ID"));
            computer.setSize(rs.getString("Size"));
            computer.setPower(rs.getString("Power"));
            computer.setRam(rs.getString("Ram"));
            computer.setRom(rs.getString("Rom"));
            return computer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
