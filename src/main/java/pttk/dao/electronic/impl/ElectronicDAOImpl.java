package pttk.dao.electronic.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.electronic.ComputerDAO;
import pttk.dao.electronic.ElectronicDAO;
import pttk.dao.electronic.MobileDAO;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.Mobile;
import pttk.util.impl.ElectronicMapper;

import java.util.List;

public class ElectronicDAOImpl extends BaseDAOImpl<Electronic> implements ElectronicDAO {
    final private ComputerDAOImpl computerDAOImpl = new ComputerDAOImpl();
    final private MobileDAOImpl mobileDAOImpl = new MobileDAOImpl();
    @Override
    public Electronic findElectronicByItemElectronicId(int electronicId) {
        String sql = "SELECT * FROM Electronic WHERE ItemElectronicId = ?";
        List<Electronic> electronicList = query(sql, new ElectronicMapper(), electronicId);
        Electronic electronic =  electronicList.isEmpty() ? null : electronicList.get(0);
        if (electronic != null) {
            Computer computer = computerDAOImpl.findComputerByElectronicId(electronic);
            Mobile mobile = mobileDAOImpl.findMobileByElectronicId(electronic);
            if(computer!=null) {
                computer.setName(electronic.getName());
                computer.setBrand(electronic.getBrand());
                computer.setPrice(electronic.getPrice());
                computer.setDescription(electronic.getDescription());
                computer.setDiscount(electronic.getDiscount());
                computer.setOrigin(electronic.getOrigin());
                return computer;
            }
            if(mobile!=null){
                mobile.setName(electronic.getName());
                mobile.setBrand(electronic.getBrand());
                mobile.setPrice(electronic.getPrice());
                mobile.setDescription(electronic.getDescription());
                mobile.setDiscount(electronic.getDiscount());
                mobile.setOrigin(electronic.getOrigin());
                return mobile;
            }

        }
        return null;

    }

    @Override
    public Electronic findElectronicById(int electronicId) {
        String sql = "SELECT * FROM Electronic WHERE Id = ?";
        List<Electronic> electronicList = query(sql, new ElectronicMapper(), electronicId);
        Electronic electronic =  electronicList.isEmpty() ? null : electronicList.get(0);
        if (electronic != null) {
            Computer computer = computerDAOImpl.findComputerByElectronicId(electronic);
            Mobile mobile = mobileDAOImpl.findMobileByElectronicId(electronic);
            if(computer!=null) {
                computer.setName(electronic.getName());
                computer.setBrand(electronic.getBrand());
                computer.setPrice(electronic.getPrice());
                computer.setDescription(electronic.getDescription());
                computer.setDiscount(electronic.getDiscount());
                computer.setOrigin(electronic.getOrigin());
                return computer;
            }
            if(mobile!=null){
                mobile.setName(electronic.getName());
                mobile.setBrand(electronic.getBrand());
                mobile.setPrice(electronic.getPrice());
                mobile.setDescription(electronic.getDescription());
                mobile.setDiscount(electronic.getDiscount());
                mobile.setOrigin(electronic.getOrigin());
                return mobile;
            }

        }
        return null;

    }

    @Override
    public Electronic getMobileByItemElectronicId(int itemElectronicId) {
        String sql = "SELECT * FROM Electronic WHERE Electronic.ItemElectronicId = ?";
        List<Electronic> listElectronic = query(sql, new ElectronicMapper(), itemElectronicId);
        Electronic electronic = listElectronic.isEmpty() ? null : listElectronic.get(0);
        if(electronic == null) return null;
        Mobile mobile = mobileDAOImpl.findMobileByElectronicId(electronic);
        if(mobile != null) {
            mobile.setName(electronic.getName());
            mobile.setBrand(electronic.getBrand());
            mobile.setPrice(electronic.getPrice());
            mobile.setDescription(electronic.getDescription());
            mobile.setDiscount(electronic.getDiscount());
            mobile.setOrigin(electronic.getOrigin());
            return mobile;
        }
        return null;
    }

    @Override
    public Electronic getComputerByItemElectronicId(int itemElectronicId) {
        String sql = "SELECT * FROM Electronic WHERE Electronic.ItemElectronicId = ?";
        List<Electronic> listElectronic = query(sql, new ElectronicMapper(), itemElectronicId);
        Electronic electronic = listElectronic.isEmpty() ? null : listElectronic.get(0);
        if(electronic == null) return null;
        Computer computer = computerDAOImpl.findComputerByElectronicId(electronic);
        if(computer!=null) {
            computer.setName(electronic.getName());
            computer.setBrand(electronic.getBrand());
            computer.setPrice(electronic.getPrice());
            computer.setDescription(electronic.getDescription());
            computer.setDiscount(electronic.getDiscount());
            computer.setOrigin(electronic.getOrigin());
            return computer;
        }
        return null;
    }

    @Override
    public Electronic updateElectronic(Electronic electronic) {
        String sql = "UPDATE Electronic SET Name = ?, Brand = ?, Price = ?, Discount = ?, Origin = ?, Description = ? WHERE ID = ?";
        update(sql, electronic.getName(), electronic.getBrand(), electronic.getPrice(), electronic.getDiscount(), electronic.getOrigin(), electronic.getDescription(), electronic.getId());
        return electronic;
    }

    @Override
    public void deleteElectronic(int itemElectronicId) {
        String sql = "DELETE FROM Electronic WHERE itemElectronicId = ?";
        update(sql, itemElectronicId);
    }

}
