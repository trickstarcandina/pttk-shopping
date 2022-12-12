package pttk.dao.electronic.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.electronic.ElectronicDAO;
import pttk.dao.electronic.ItemElectronicDAO;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.Mobile;
import pttk.model.shoes.ItemShoes;
import pttk.util.impl.ItemElectronicMapper;
import pttk.util.impl.ItemShoesMapper;
import pttk.util.impl.MobileMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ItemElectronicDAOImpl extends BaseDAOImpl<ItemElectronic> implements ItemElectronicDAO {

    private final ElectronicDAO electronicDAO = new ElectronicDAOImpl();

    @Override
    public List<ItemElectronic> findAll() {
        String sql = "SELECT * FROM ItemElectronic";
        List<ItemElectronic> itemElectronicList =  query(sql, new ItemElectronicMapper());
        itemElectronicList.stream().forEach(itemElectronic -> {
            itemElectronic.setElectronic(electronicDAO.findElectronicByItemElectronicId(itemElectronic.getId()));
        });
        return itemElectronicList;
    }

    @Override
    public List<ItemElectronic> findAllItemElectronics(int limit, int offset) {
        String sql = "SELECT * FROM ItemElectronic LIMIT ?, ?";
        List<ItemElectronic> listItemElectronic =  query(sql, new ItemElectronicMapper(), offset, limit);
        listItemElectronic.stream().forEach(itemElectronic -> {
            itemElectronic.setElectronic(electronicDAO.findElectronicByItemElectronicId(itemElectronic.getId()));
        });
        return listItemElectronic;
    }

    @Override
    public ItemElectronic findItemElectronicById(int ItemElectronicId) {
        String sql = "SELECT * FROM ItemElectronic WHERE id = ?";
        List<ItemElectronic> itemElectronicList =  query(sql, new ItemElectronicMapper(), ItemElectronicId);
        itemElectronicList.stream().forEach(itemElectronic -> {
            itemElectronic.setElectronic(electronicDAO.findElectronicByItemElectronicId(itemElectronic.getId()));
        });
        return itemElectronicList.isEmpty() ? null : itemElectronicList.get(0);
    }

    @Override
    public List<ItemElectronic> findAllComputer() {
        String sql = "SELECT * FROM ItemElectronic";
        List<ItemElectronic> listItemElectronic =  query(sql, new ItemElectronicMapper());
        listItemElectronic = listItemElectronic.stream().filter(itemElectronic -> {
            if(electronicDAO.getComputerByItemElectronicId(itemElectronic.getId())!=null){
                itemElectronic.setElectronic(electronicDAO.getComputerByItemElectronicId(itemElectronic.getId()));
                return true;
            }
            else{
                return false;
            }
        }).collect(Collectors.toList());
        return listItemElectronic;
    }

    @Override
    public List<ItemElectronic> findAllMobile() {
        String sql = "SELECT * FROM ItemElectronic";
        List<ItemElectronic> listItemElectronic =  query(sql, new ItemElectronicMapper());
        listItemElectronic = listItemElectronic.stream().filter(itemElectronic -> {
            if(electronicDAO.getMobileByItemElectronicId(itemElectronic.getId()) !=null ) {
                itemElectronic.setElectronic(electronicDAO.getMobileByItemElectronicId(itemElectronic.getId()));
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        return listItemElectronic;
    }

    @Override
    public ItemElectronic updateItemElectronic(ItemElectronic itemElectronic) {
        String sql = "UPDATE Electronic SET Price = ?, ImageUrl = ? WHERE ID = ?";
        update(sql, itemElectronic.getPrice(), itemElectronic.getImageUrl(), itemElectronic.getId());
        return itemElectronic;
    }

    @Override
    public void deleteItemElectronic(int id) {
        String sql = "DELETE FROM ItemElectronic WHERE Id = ?";
        update(sql, id);
    }
    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM ItemElectronic";
        return count(sql);
    }
}
