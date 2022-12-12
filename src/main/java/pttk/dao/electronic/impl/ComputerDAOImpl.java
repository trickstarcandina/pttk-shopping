package pttk.dao.electronic.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.electronic.ComputerDAO;
import pttk.dao.electronic.ElectronicDAO;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.Mobile;
import pttk.util.impl.ComputerMapper;
import pttk.util.impl.MobileMapper;

import java.util.List;

public class ComputerDAOImpl extends BaseDAOImpl<Computer> implements ComputerDAO {
    @Override
    public Computer findComputerByElectronicId(Electronic electronic) {
        String sql = "select * from Computer where ElectronicID = ?";
        List<Computer> listComputer = query(sql, new ComputerMapper(), electronic.getId());
        if (listComputer.isEmpty()) return null;
        else {
            Computer Computer = listComputer.get(0);
            Computer.setOrigin(electronic.getOrigin());
            Computer.setBrand(electronic.getBrand());
            Computer.setDescription(electronic.getDescription());
            Computer.setPrice(electronic.getPrice());
            Computer.setDiscount(electronic.getDiscount());
            return Computer;
        }
    }

    @Override
    public Computer updateComputer(Computer computer) {
        String sql = "UPDATE Computer SET Size = ?, Ram = ?, Power = ?, Rom = ? WHERE iD = ?";
        update(sql, computer.getSize(), computer.getRam(), computer.getPower(), computer.getRom(), computer.getId());
        return computer;
    }

    @Override
    public void deleteComputer(int electronicId) {
        String sql = "DELETE FROM Computer WHERE ElectronicId = ?";
        update(sql, electronicId);
    }
}
