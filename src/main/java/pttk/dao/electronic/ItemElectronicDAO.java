package pttk.dao.electronic;


import pttk.dao.BaseDAO;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.Mobile;

import java.util.List;

public interface ItemElectronicDAO extends BaseDAO<ItemElectronic> {
    List<ItemElectronic> findAll();
    List<ItemElectronic> findAllItemElectronics(int limit, int offset);
    ItemElectronic findItemElectronicById(int ItemElectronicId);
    List<ItemElectronic> findAllComputer();
    List<ItemElectronic> findAllMobile();
    ItemElectronic updateItemElectronic(ItemElectronic itemElectronic);
    void deleteItemElectronic(int id);

    public int getTotalItem();

}
