package pttk.service.impl;

import pttk.dao.electronic.ComputerDAO;
import pttk.dao.electronic.ElectronicDAO;
import pttk.dao.electronic.ItemElectronicDAO;
import pttk.dao.electronic.MobileDAO;
import pttk.dao.electronic.impl.ComputerDAOImpl;
import pttk.dao.electronic.impl.ElectronicDAOImpl;
import pttk.dao.electronic.impl.ItemElectronicDAOImpl;
import pttk.dao.electronic.impl.MobileDAOImpl;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.Mobile;
import pttk.service.ItemElectronicService;

import java.util.List;

public class ItemElectronicServiceImpl implements ItemElectronicService {
    ItemElectronicDAO itemElectronicDAO = new ItemElectronicDAOImpl();
    ElectronicDAO electronicDAO = new ElectronicDAOImpl();
    ComputerDAO computerDAO = new ComputerDAOImpl();
    MobileDAO mobileDAO = new MobileDAOImpl();
    @Override
    public ItemElectronic findElectronicById(int itemElectronicId) {
        return itemElectronicDAO.findItemElectronicById(itemElectronicId);
    }

    @Override
    public List<ItemElectronic> findAll() {
        return itemElectronicDAO.findAll();
    }

    @Override
    public List<ItemElectronic> findAllItemElectronic(int limit, int offset) {
        return itemElectronicDAO.findAllItemElectronics(limit, offset);
    }


    @Override
    public List<ItemElectronic> findAllComputer() {
        return itemElectronicDAO.findAllComputer();
    }

    @Override
    public List<ItemElectronic> findAllMobile() {
        return itemElectronicDAO.findAllMobile();
    }

    @Override
    public Mobile findMobile(int itemElectronicId) {
        Electronic electronic = electronicDAO.findElectronicByItemElectronicId(itemElectronicId);
        if(electronic instanceof Mobile) {
            Mobile mobile = (Mobile) electronic;
            return mobile;
        }
        return null;
    }

    @Override
    public Computer findComputer(int itemElectronicId) {
        Electronic electronic = electronicDAO.findElectronicByItemElectronicId(itemElectronicId);
        if(electronic instanceof Computer) {
            Computer computer = (Computer) electronic;
            return computer;
        }
        return null;
    }

    @Override
    public int getTotalItem() {
        return itemElectronicDAO.getTotalItem();
    }

    @Override
    public ItemElectronic updateItemElectronic(ItemElectronic itemElectronic, Electronic electronic, Computer computer) {
        itemElectronic = itemElectronicDAO.updateItemElectronic(itemElectronic);
        Electronic electronicUpdate = electronicDAO.updateElectronic(electronic);
        if(computer!=null){
            Computer computerUpdate = computerDAO.updateComputer(computer);
        }
        return itemElectronicDAO.updateItemElectronic(itemElectronic);
    }

    @Override
    public ItemElectronic updateItemElectronic1(ItemElectronic itemElectronic, Electronic electronic, Mobile mobile) {
        itemElectronic = itemElectronicDAO.updateItemElectronic(itemElectronic);
        Electronic electronicUpdate = electronicDAO.updateElectronic(electronic);
        if(mobile!=null){
            Mobile mobileUpdate = mobileDAO.updateMobile(mobile);
        }
        return itemElectronic;
    }


    @Override
    public void deleteItemElectronic(String[] ids) {
        for (String id: ids) {
            itemElectronicDAO.deleteItemElectronic(Integer.parseInt(id));
            electronicDAO.deleteElectronic(Integer.parseInt(id));
            Electronic electronic = electronicDAO.findElectronicByItemElectronicId(Integer.parseInt(id));
            Mobile mobile = mobileDAO.findMobileByElectronicId(electronic);
            Computer computer = computerDAO.findComputerByElectronicId(electronic);
            if(mobile!=null){
                mobileDAO.deleteMobile(electronic.getId());
            }
            if(computer!=null){
                computerDAO.deleteComputer(electronic.getId());
            }
        }
    }


}
